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
package org.eclipse.passage.lic.api.tests.fakes.conditions.mining;

import java.util.Collection;

import org.eclipse.passage.lic.internal.api.LicensedProduct;
import org.eclipse.passage.lic.internal.api.ServiceInvocationResult;
import org.eclipse.passage.lic.internal.api.conditions.ConditionMiningTarget;
import org.eclipse.passage.lic.internal.api.conditions.ConditionPack;
import org.eclipse.passage.lic.internal.api.conditions.mining.MinedConditions;

@SuppressWarnings("restriction")
public final class FakeMinedConditions implements MinedConditions {

	@Override
	public ConditionMiningTarget id() {
		return new ConditionMiningTarget.Of("fake-mining-service"); //$NON-NLS-1$
	}

	@Override
	public ServiceInvocationResult<Collection<ConditionPack>> all(LicensedProduct product) {
		throw new UnsupportedOperationException();
	}

}
