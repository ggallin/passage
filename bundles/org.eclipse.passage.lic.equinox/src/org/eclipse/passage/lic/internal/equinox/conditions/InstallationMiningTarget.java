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
package org.eclipse.passage.lic.internal.equinox.conditions;

import java.util.function.Supplier;

import org.eclipse.passage.lic.internal.api.conditions.ConditionMiningTarget;

public final class InstallationMiningTarget implements Supplier<ConditionMiningTarget> {

	@Override
	public ConditionMiningTarget get() {
		return new ConditionMiningTarget.Local().child("installation-conditions"); //$NON-NLS-1$
	}

}
