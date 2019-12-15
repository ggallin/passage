/*******************************************************************************
 * Copyright (c) 2019 ArSysOp
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
package org.eclipse.passage.lic.internal.jface.dialogs;

import org.eclipse.osgi.util.NLS;
import org.eclipse.passage.lic.api.LicensingException;
import org.eclipse.passage.lic.api.LicensingResult;
import org.eclipse.passage.lic.base.LicensingResults;
import org.eclipse.passage.lic.internal.jface.i18n.JFaceMessages;
import org.eclipse.passage.lic.jface.dialogs.LicensingPage;
import org.eclipse.passage.lic.jface.dialogs.LicensingPageContributor;

public class BasePageContributor implements LicensingPageContributor {

	private final String pageIdentifier;
	private final String pageName;
	private final Class<? extends LicensingPage> pageClass;

	public BasePageContributor(String pageIdentifier, String pageName, Class<? extends LicensingPage> pageClass) {
		this.pageIdentifier = pageIdentifier;
		this.pageName = pageName;
		this.pageClass = pageClass;
	}

	@Override
	public String getPageIdentifier() {
		return pageIdentifier;
	}

	@Override
	public String getPageName() {
		return pageName;
	}

	@Override
	public LicensingPage createPage() throws LicensingException {
		try {
			return pageClass.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			String message = NLS.bind(JFaceMessages.BasePageContributor_e_create_page_instance, pageClass);
			LicensingResult error = LicensingResults.createError(message, pageIdentifier, e);
			throw new LicensingException(error);
		}
	}

}
