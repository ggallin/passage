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
package org.eclipse.passage.loc.users.emfforms.renderers;

import java.nio.file.Files;
import java.nio.file.Path;

import javax.inject.Inject;

import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.passage.lic.internal.base.BaseLicensedProduct;
import org.eclipse.passage.lic.internal.base.io.PassageFileExtension;
import org.eclipse.passage.lic.internal.base.io.UserHomeProductResidence;
import org.eclipse.passage.lic.users.model.api.UserLicense;
import org.eclipse.passage.loc.workbench.emfforms.renderers.FileContentRenderer;

@SuppressWarnings("restriction")
public class PackIdentifierRenderer extends FileContentRenderer<UserLicense> {

	@Inject
	public PackIdentifierRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService,
			EMFFormsDatabinding emfFormsDatabinding, EMFFormsLabelProvider emfFormsLabelProvider,
			VTViewTemplateProvider vtViewTemplateProvider) {
		super(vElement, viewContext, reportService, emfFormsDatabinding, emfFormsLabelProvider, vtViewTemplateProvider,
				UserLicense.class);
	}

	@Override
	protected String extractFilePath(String value, UserLicense observed) {
		BaseLicensedProduct product = new BaseLicensedProduct(//
				observed.getProductIdentifier(), observed.getProductVersion());
		Path dir = new UserHomeProductResidence(product).get();
		Path encrypted = dir.resolve(value + new PassageFileExtension.LicenseEncrypted().get());
		if (Files.exists(encrypted)) {
			return encrypted.toString();
		}
		return dir.resolve(value + new PassageFileExtension.LicenseDecrypted().get()).toString();
	}

}
