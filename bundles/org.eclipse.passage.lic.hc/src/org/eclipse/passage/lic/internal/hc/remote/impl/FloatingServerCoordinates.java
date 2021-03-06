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
package org.eclipse.passage.lic.internal.hc.remote.impl;

import org.eclipse.passage.lic.floating.model.api.FloatingLicenseAccess;
import org.eclipse.passage.lic.internal.api.LicensingException;
import org.eclipse.passage.lic.internal.net.HostPort;
import org.eclipse.passage.lic.internal.net.LicensingServerCoordinates;

final class FloatingServerCoordinates implements LicensingServerCoordinates {

	private final FloatingLicenseAccess access;

	FloatingServerCoordinates(FloatingLicenseAccess access) {
		this.access = access;
	}

	@Override
	public HostPort get() throws LicensingException {
		return new HostPort(access.getServer().getIp(), Integer.toString(access.getServer().getPort()));
	}

}
