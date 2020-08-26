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
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.passage.lic.api.LicensingResult;
import org.eclipse.passage.lic.email.Mailing;
import org.eclipse.passage.lic.licenses.LicensePackDescriptor;
import org.eclipse.passage.lic.licenses.LicensePlanDescriptor;
import org.eclipse.passage.lic.products.ProductVersionDescriptor;
import org.eclipse.passage.lic.users.UserDescriptor;
import org.eclipse.passage.lic.users.model.api.UserLicense;
import org.eclipse.passage.lic.users.model.meta.UsersPackage;
import org.eclipse.passage.loc.api.OperatorLicenseService;
import org.eclipse.passage.loc.internal.api.LicensingRequest;
import org.eclipse.passage.loc.internal.dashboard.ui.i18n.IssueLicensePageMessages;
import org.eclipse.passage.loc.internal.licenses.core.EmailTemplate;
import org.eclipse.passage.loc.users.ui.UsersUi;
import org.eclipse.passage.loc.workbench.LocWokbench;
import org.eclipse.swt.SWT;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class IssueLicenseWizard extends Wizard {

	private final IEclipseContext context;

	private LicensePlanDescriptor licensePlanDescriptor;
	private UserDescriptor userDescriptor;
	private ProductVersionDescriptor productVersionDescriptor;

	private IssueLicenseRequestPage requestPage;
	private IssueLicensePackPage packPage;
	private IssueLicenseDetailsPage infoPage;

	public IssueLicenseWizard(IEclipseContext context) {
		this.context = context;
		setWindowTitle(IssueLicensePageMessages.IssueLicenseWizard_window_title);
	}

	public void init(LicensePlanDescriptor plan, UserDescriptor user, ProductVersionDescriptor version) {
		this.licensePlanDescriptor = plan;
		this.userDescriptor = user;
		this.productVersionDescriptor = version;
	}

	@Override
	public void addPages() {
		requestPage = new IssueLicenseRequestPage(IssueLicenseRequestPage.class.getName(), context);
		requestPage.init(licensePlanDescriptor, userDescriptor, productVersionDescriptor);
		addPage(requestPage);
		packPage = new IssueLicensePackPage(IssueLicensePackPage.class.getName(), context);
		addPage(packPage);
		infoPage = new IssueLicenseDetailsPage(IssueLicenseDetailsPage.class.getName(), context);
		addPage(infoPage);
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if (packPage.equals(nextPage)) {
			packPage.init(requestPage.getLicensingRequest());
		}
		if (infoPage.equals(nextPage)) {
			infoPage.init(packPage.getLicensePack());
		}
		return nextPage;
	}

	@Override
	public boolean performFinish() {
		OperatorLicenseService licenseService = context.get(OperatorLicenseService.class);
		LicensingRequest request = requestPage.getLicensingRequest();
		LicensePackDescriptor licensePack = packPage.getLicensePack();
		LicensingResult result = licenseService.issueLicensePack(request, licensePack);
		int severity = result.getSeverity();
		if (severity >= LicensingResult.ERROR) {
			setErrorMessage(result.getMessage());
			return false;
		} else {
			setErrorMessage(null);
			int kind = (severity == LicensingResult.WARNING) ? MessageDialog.WARNING : MessageDialog.INFORMATION;
			MessageDialog.open(kind, getShell(), IssueLicensePageMessages.IssueLicenseWizard_ok_licensed_title,
					result.getMessage(), SWT.NONE);
			String mailFrom = infoPage.mailFrom();
			if (!mailFrom.isEmpty()) {
				processingMail(mailFrom, licensePack, result);
			}
			broadcast(result);
			return true;
		}
	}

	private void processingMail(String from, LicensePackDescriptor licensePack, LicensingResult result) {
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

	private void broadcast(LicensingResult result) {
		Object attached = result.getAttachment(UsersPackage.eINSTANCE.getUserLicense().getName());
		if (attached instanceof UserLicense) {
			UserLicense userLicense = (UserLicense) attached;
			String perspectiveId = UsersUi.PERSPECTIVE_MAIN;
			LocWokbench.switchPerspective(context, perspectiveId);
			IEventBroker broker = context.get(IEventBroker.class);
			broker.post(LocWokbench.TOPIC_SHOW, userLicense);
		}
	}

	private void setErrorMessage(String message) {
		IWizardContainer container = getContainer();
		if (container instanceof TitleAreaDialog) {
			TitleAreaDialog dialog = (TitleAreaDialog) container;
			dialog.setErrorMessage(message);
		}
	}

}
