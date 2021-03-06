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

import java.util.function.Supplier;

import org.eclipse.passage.lic.internal.api.ServiceInvocationResult;
import org.eclipse.passage.lic.internal.api.conditions.mining.LicenseReadingService;
import org.eclipse.passage.lic.internal.base.BaseServiceInvocationResult;

@SuppressWarnings("restriction")
public final class LicenseReadingServiceRequest extends FrameworkAware
		implements Supplier<ServiceInvocationResult<LicenseReadingService>> {

	@Override
	public ServiceInvocationResult<LicenseReadingService> get() {
		return withFrameworkService(framework -> new BaseServiceInvocationResult<>(framework.licenseReader()));
	}

}
