/*******************************************************************************
 * Copyright (c) 2018-2019 ArSysOp
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     ArSysOp - initial API and implementation
 *******************************************************************************/
package org.eclipse.passage.loc.licenses.ui.handlers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.inject.Named;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.passage.lic.emf.edit.ComposedAdapterFactoryProvider;
import org.eclipse.passage.lic.licenses.LicensePlanDescriptor;
import org.eclipse.passage.lic.licenses.LicensePlanFeatureDescriptor;
import org.eclipse.passage.lic.licenses.model.api.LicenseGrant;
import org.eclipse.passage.lic.licenses.model.api.LicensePack;
import org.eclipse.passage.lic.licenses.model.meta.LicensesFactory;
import org.eclipse.passage.lic.products.ProductVersionDescriptor;
import org.eclipse.passage.lic.products.registry.ProductRegistry;
import org.eclipse.passage.lic.users.UserDescriptor;
import org.eclipse.passage.lic.users.registry.UserRegistry;
import org.eclipse.passage.loc.api.OperatorLicenseService;
import org.eclipse.passage.loc.internal.licenses.ui.i18n.LicensesUiMessages;
import org.eclipse.passage.loc.products.ui.ProductsUi;
import org.eclipse.passage.loc.users.ui.UsersUi;
import org.eclipse.swt.widgets.Shell;

//FIXME: should be moved to reduce dependencies
public class LicenseExportHandler {

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) LicensePlanDescriptor licensePlan,
			IEclipseContext context) {
		OperatorLicenseService licenseService = context.get(OperatorLicenseService.class);
		Shell shell = context.get(Shell.class);
		UserRegistry userRegistry = context.get(UserRegistry.class);
		ProductRegistry productRegistry = context.get(ProductRegistry.class);
		ComposedAdapterFactoryProvider provider = context.get(ComposedAdapterFactoryProvider.class);
		UserDescriptor user = UsersUi.selectUserDescriptor(shell, provider, userRegistry, null);
		if (user == null) {
			return;
		}
		ProductVersionDescriptor productVersion = ProductsUi.selectProductVersionDescriptor(shell, provider,
				productRegistry, null);
		if (productVersion == null) {
			return;
		}
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime year = now.plusYears(1);
		Date from = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		Date until = Date.from(year.atZone(ZoneId.systemDefault()).toInstant());

		LicensePack licensePack = createLicensePack(licensePlan, user, productVersion, from, until);
		IStatus status = licenseService.issueLicensePack(licensePack);
		if (status.isOK()) {
			MessageDialog.openInformation(shell, LicensesUiMessages.LicenseExportHandler_success_title,
					status.getMessage());
		} else {
			ErrorDialog.openError(shell, LicensesUiMessages.LicenseExportHandler_error_title,
					LicensesUiMessages.LicenseExportHandler_error_message, status);
		}
	}

	private LicensePack createLicensePack(LicensePlanDescriptor licensePlan, UserDescriptor userDescriptor,
			ProductVersionDescriptor productVersion, Date from, Date until) {
		LicensesFactory licenseFactory = LicensesFactory.eINSTANCE;
		LicensePack licensePack = licenseFactory.createLicensePack();
		licensePack.setProductIdentifier(productVersion.getProduct().getIdentifier());
		licensePack.setProductVersion(productVersion.getVersion());
		licensePack.setUserIdentifier(userDescriptor.getEmail());
		EList<LicenseGrant> grants = licensePack.getLicenseGrants();
		Iterable<? extends LicensePlanFeatureDescriptor> features = licensePlan.getLicensePlanFeatures();
		String conditionType = userDescriptor.getPreferredConditionType();
		String expression = userDescriptor.getPreferredConditionExpression();
		for (LicensePlanFeatureDescriptor planFeature : features) {
			LicenseGrant grant = licenseFactory.createLicenseGrant();
			grant.setFeatureIdentifier(planFeature.getFeatureIdentifier());
			grant.setMatchVersion(planFeature.getMatchVersion());
			grant.setMatchRule(planFeature.getMatchRule());
			grant.setCapacity(1);
			grant.setConditionExpression(expression);
			grant.setConditionType(conditionType);
			grant.setValidFrom(from);
			grant.setValidUntil(until);
			grants.add(grant);
		}
		return licensePack;
	}

	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional LicensePlanDescriptor licensePlan,
			IEclipseContext context) {
		OperatorLicenseService licenseService = context.get(OperatorLicenseService.class);
		if (licenseService == null) {
			return false;
		}
		return licensePlan != null;
	}

}