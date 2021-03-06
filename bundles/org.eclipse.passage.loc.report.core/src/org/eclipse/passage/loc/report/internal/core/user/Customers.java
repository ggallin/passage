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
package org.eclipse.passage.loc.report.internal.core.user;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.passage.lic.users.UserDescriptor;
import org.eclipse.passage.lic.users.UserLicenseDescriptor;
import org.eclipse.passage.loc.internal.users.UserRegistry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * <p>
 * OSGi {@code component} implementation for the {@linkplain CustomerStorage}
 * interface.
 * </p>
 * 
 * <p>
 * {@linkplain UserRegistry} injection is intended to be done by OSGi.
 * </p>
 * 
 * @since 0.2
 */
@Component
public final class Customers implements CustomerStorage {

	private UserRegistry users;

	@Override
	public Set<UserDescriptor> forProducts(Set<String> products) {
		return StreamSupport.stream(users.getUserLicenses().spliterator(), false)//
				.filter(lic -> products.contains(lic.getProductIdentifier())) //
				.map(UserLicenseDescriptor::getUser) //
				.collect(Collectors.toSet());
	}

	@Override
	public Set<String> products() {
		return StreamSupport.stream(users.getUserLicenses().spliterator(), false)//
				.map(UserLicenseDescriptor::getProductIdentifier) //
				.collect(Collectors.toSet());
	}

	/**
	 * It is required to install {@code LIC} {@linkplain UserRegistry} as it is the
	 * source of information provided.
	 * 
	 * @since 0.1
	 */
	@Reference
	public void installUserRegistry(UserRegistry registry) {
		this.users = registry;
	}

}
