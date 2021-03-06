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
package org.eclipse.passage.lbc.base.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.passage.lbc.internal.api.BackendLicensingRequest;
import org.eclipse.passage.lbc.internal.base.BaseLicensingRequest;
import org.junit.Test;

public class RequestTest extends LbcTestsBase {

	private Map<String, String> params() {
		HashMap<String, String> params = new HashMap<>();
		params.put("action", "action"); //$NON-NLS-1$ //$NON-NLS-2$
		params.put("key", "value"); //$NON-NLS-1$//$NON-NLS-2$
		params.put(userValue(), userValue());
		return params;
	}

	@Test
	public void positiveTransition() {
		BackendLicensingRequest request = new BaseLicensingRequest<>(params(), this::requestParameter,
				this::requestBody);
		assertEquals("action", request.parameter("action")); //$NON-NLS-1$ //$NON-NLS-2$
		assertEquals("value", request.parameter("key")); //$NON-NLS-1$ //$NON-NLS-2$
		assertEquals(userValue(), request.requester().hardware());
	}

}
