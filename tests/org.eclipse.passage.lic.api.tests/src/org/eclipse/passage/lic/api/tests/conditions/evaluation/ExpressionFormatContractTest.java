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
package org.eclipse.passage.lic.api.tests.conditions.evaluation;

import org.eclipse.passage.lic.api.tests.registry.ServiceIdContractTest;
import org.eclipse.passage.lic.internal.api.conditions.evaluation.ExpressionProtocol;
import org.eclipse.passage.lic.internal.api.registry.ServiceId;

@SuppressWarnings("restriction")
public class ExpressionFormatContractTest extends ServiceIdContractTest {

	@Override
	protected ServiceId ofSameData() {
		return new ExpressionProtocol.Of("abra-cadabra"); //$NON-NLS-1$
	}

}
