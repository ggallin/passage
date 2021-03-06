/*******************************************************************************
 * Copyright (c) 2020 ArSysOp
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
package org.eclipse.passage.lic.internal.e4.ui.addons;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.passage.lic.internal.api.ServiceInvocationResult;
import org.eclipse.passage.lic.internal.api.restrictions.ExaminationCertificate;
import org.eclipse.passage.lic.internal.base.restrictions.CertificateIsRestrictive;
import org.eclipse.passage.lic.internal.e4.ui.restrictions.WorkbenchShutdown;
import org.eclipse.passage.lic.internal.equinox.EquinoxPassage;
import org.eclipse.passage.lic.internal.equinox.LicensedProductFromContext;
import org.eclipse.passage.lic.internal.jface.EquinoxPassageUI;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.event.Event;

@SuppressWarnings("restriction")
public final class E4LicensingAddon {

	private final IApplicationContext application;
	private final IEclipseContext context;
	private java.util.Optional<ExaminationCertificate> certificate = java.util.Optional.empty();

	@Inject
	public E4LicensingAddon(IApplicationContext application, IEclipseContext context) {
		this.application = application;
		this.context = context;
	}

	@Inject
	@Optional
	public void applicationStarted(//
			@SuppressWarnings("unused") //
			@UIEventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE) //
			Event event) {
		ServiceInvocationResult<ExaminationCertificate> response = //
				new EquinoxPassageUI(this::shell)
						.acquireLicense(new LicensedProductFromContext(application).get().identifier());
		certificate = response.data();
		if (new CertificateIsRestrictive().test(certificate)) {
			new WorkbenchShutdown().run();
		}
	}

	@Inject
	@Optional
	public void applicationFainted(//
			@SuppressWarnings("unused") //
			@UIEventTopic(UIEvents.UILifeCycle.APP_SHUTDOWN_STARTED) //
			Event event) {
		certificate.ifPresent(new EquinoxPassage()::releaseLicense);
	}

	private Shell shell() {
		return context.get(Shell.class);
	}

}
