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
package org.eclipse.passage.seal.demo.tests.registries;

import java.util.Optional;

import org.eclipse.passage.lic.api.tests.PermissionEmittingServicesRegitryTest;
import org.eclipse.passage.lic.internal.api.Framework;
import org.eclipse.passage.seal.internal.demo.DemoFrameworkSupplier;

@SuppressWarnings("restriction")
public final class SealedPermissionEmttingServicesRegistryTest extends PermissionEmittingServicesRegitryTest {

	@Override
	protected Optional<Framework> framework() {
		return new DemoFrameworkSupplier().get();
	}

}
