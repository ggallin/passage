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
package org.eclipse.passage.lic.internal.equinox;

import java.util.Optional;
import java.util.function.Supplier;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.passage.lic.internal.base.InvalidLicensingConfiguration;
import org.eclipse.passage.lic.internal.base.ProductIdentifier;

@SuppressWarnings("restriction")
public final class ApplicationIdentifier implements Supplier<String> {
	private final IApplicationContext context;

	public ApplicationIdentifier(IApplicationContext context) {
		this.context = context;
	}

	@Override
	public String get() {
		Optional<String> property = new ProductIdentifier(context::getBrandingProperty).get();
		if (property.isPresent()) {
			return property.get();
		}
		String brandingId = context.getBrandingId();
		if (brandingId != null) {
			return brandingId;
		}
		String applicationId = context.getBrandingApplication();
		if (applicationId != null) {
			return applicationId;
		}
		// OK, no more ideas
		return new InvalidLicensingConfiguration().getProductIdentifier();
	}

}