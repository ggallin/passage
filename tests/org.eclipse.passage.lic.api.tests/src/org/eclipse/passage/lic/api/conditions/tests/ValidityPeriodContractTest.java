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
package org.eclipse.passage.lic.api.conditions.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.eclipse.passage.lic.internal.api.conditions.ValidityPeriod;
import org.junit.Test;

@SuppressWarnings("restriction")
public abstract class ValidityPeriodContractTest<V extends ValidityPeriod> {

	@Test
	public void dateCanBeValid() {
		assertTrue(atLeastMonthLong(movedNow(-1)).valid(new Date()));
	}

	@Test
	public void dateCanBeInvalid() {
		assertFalse(atLeastMonthLong(movedNow(1)).valid(new Date()));
	}

	protected Date movedNow(int hours) {
		return new Date(System.currentTimeMillis() - hours * 3_600_000);
	}

	protected abstract V atLeastMonthLong(Date from);

}