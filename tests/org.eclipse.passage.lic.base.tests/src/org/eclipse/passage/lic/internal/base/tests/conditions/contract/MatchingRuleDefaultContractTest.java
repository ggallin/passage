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
package org.eclipse.passage.lic.internal.base.tests.conditions.contract;

import org.eclipse.passage.lic.internal.api.conditions.MatchingRule;
import org.eclipse.passage.lic.internal.base.conditions.MatchingRuleDefault;

@SuppressWarnings("restriction")
public final class MatchingRuleDefaultContractTest extends BaseMatchingRuleContractTest {

	@Override
	protected MatchingRule rule() {
		return new MatchingRuleDefault();
	}

}