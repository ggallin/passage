/*******************************************************************************
 * Copyright (c) 2019, 2020 ArSysOp
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     ArSysOp - initial API and implementation
 *******************************************************************************/
package org.eclipse.passage.loc.dashboard.ui.wizards;

import java.io.File;
import java.io.IOException;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.passage.lic.email.Mailing;
import org.eclipse.passage.lic.internal.api.ServiceInvocationResult;
import org.eclipse.passage.lic.internal.base.diagnostic.NoErrors;
import org.eclipse.passage.lic.internal.base.diagnostic.NoSevereErrors;
import org.eclipse.passage.lic.internal.jface.dialogs.licensing.DiagnosticDialog;
import org.eclipse.passage.lic.licenses.LicensePackDescriptor;
import org.eclipse.passage.lic.users.model.api.UserLicense;
import org.eclipse.passage.loc.dashboard.ui.wizards.license.WizardInfoBar;
import org.eclipse.passage.loc.internal.api.IssuedLicense;
import org.eclipse.passage.loc.internal.api.OperatorLicenseService;
import org.eclipse.passage.loc.internal.dashboard.ui.i18n.IssueLicensePageMessages;
import org.eclipse.passage.loc.internal.licenses.core.EmailTemplate;
import org.eclipse.passage.loc.internal.licenses.ui.i18n.LicensesUiMessages;
import org.eclipse.passage.loc.users.ui.UsersUi;
import org.eclipse.passage.loc.workbench.LocWokbench;
import org.eclipse.swt.SWT;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class IssueLicenseWizard extends Wizard {

	private final IEclipseContext context;
	private final PersonalDataPack initial;
	private IssueLicenseRequestPage request;
	private IssueLicensePackPage pack;
	private IssueLicenseDetailsPage info;

	public IssueLicenseWizard(IEclipseContext context, PersonalDataPack initial) {
		this.context = context;
		this.initial = initial;
		setWindowTitle(IssueLicensePageMessages.IssueLicenseWizard_window_title);
	}

	@Override
	public void addPages() {
		request = new IssueLicenseRequestPage(context, initial);
		addPage(request.get());
		pack = new IssueLicensePackPage(IssueLicensePackPage.class.getName(), request::request, context);
		addPage(pack);
		info = new IssueLicenseDetailsPage(IssueLicenseDetailsPage.class.getName(), pack::pack, context);
		addPage(info);
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage next = super.getNextPage(page);
		if (pack.equals(next)) {
			pack.init();
		}
		return next;
	}

	@Override
	public boolean performFinish() {
		OperatorLicenseService licenseService = context.get(OperatorLicenseService.class);
		LicensePackDescriptor licensePack = pack.pack();
		ServiceInvocationResult<IssuedLicense> result = licenseService.issueLicensePack(request.request(), licensePack);
		if (!new NoSevereErrors().test(result.diagnostic())) {
			new WizardInfoBar(this).installError("Export failed"); //$NON-NLS-1$
			new DiagnosticDialog(getShell(), result.diagnostic()).open();
			return false;
		} else {
			new WizardInfoBar(this).wipe();
			int kind = new NoErrors().test(result.diagnostic()) ? MessageDialog.INFORMATION : MessageDialog.WARNING;
			MessageDialog.open(kind, getShell(), //
					IssueLicensePageMessages.IssueLicenseWizard_ok_licensed_title,
					String.format(LicensesUiMessages.LicenseExportHandler_success_description, //
							result.data().get().encrypted().toAbsolutePath().toString(), //
							result.data().get().decrypted().toAbsolutePath().toString()),
					SWT.NONE);
			String mailFrom = info.mailFrom();
			if (!mailFrom.isEmpty()) {
				processingMail(mailFrom, licensePack, result.data().get());
			}
			broadcast(result.data().get());
			return true;
		}
	}

	private void processingMail(String from, LicensePackDescriptor licensePack, IssuedLicense result) {
		Mailing mailing = context.get(Mailing.class);
		EmailTemplate template = new EmailTemplate(mailing);
		try {
			File eml = template.createEmlFile(from, licensePack, result);
			String msg = NLS.bind(IssueLicensePageMessages.IssueLicenseMailRequestDialog_text, eml.getAbsolutePath());
			Display.getDefault().asyncExec(() -> MessageDialog.openInformation(context.get(Shell.class),
					IssueLicensePageMessages.IssueLicenseMailRequestDialog_title, msg));
			Program.launch(eml.getAbsolutePath());
		} catch (IOException e) {
			Display.getDefault().asyncExec(() -> MessageDialog.openError(context.get(Shell.class),
					IssueLicensePageMessages.IssueLicenseMailRequestDialog_title, e.getMessage()));
			Program.launch(template.mailTo(licensePack));
		}
	}

	private void broadcast(IssuedLicense result) {
		UserLicense userLicense = result.license();
		String perspectiveId = UsersUi.PERSPECTIVE_MAIN;
		LocWokbench.switchPerspective(context, perspectiveId);
		IEventBroker broker = context.get(IEventBroker.class);
		broker.post(LocWokbench.TOPIC_SHOW, userLicense);
	}

}
