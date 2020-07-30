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
package org.eclipse.passage.lic.internal.base.tests.conditions.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.eclipse.passage.lic.api.tests.fakes.conditions.FakeConditionPack;
import org.eclipse.passage.lic.api.tests.fakes.conditions.evaluation.FakePermission;
import org.eclipse.passage.lic.internal.api.conditions.ConditionPack;
import org.eclipse.passage.lic.internal.api.conditions.evaluation.Emission;
import org.eclipse.passage.lic.internal.api.conditions.evaluation.Emission.Failed;
import org.eclipse.passage.lic.internal.api.conditions.evaluation.Emission.Successful;
import org.eclipse.passage.lic.internal.api.diagnostic.TroubleCode;
import org.eclipse.passage.lic.internal.base.conditions.evaluation.SumOfEmissions;
import org.eclipse.passage.lic.internal.base.diagnostic.BaseFailureDiagnostic;
import org.junit.Test;

@SuppressWarnings("restriction")
public final class SumOfEmissionsTest {

	@Test
	public void sumOfSuccessesIsSuccess() {
		ConditionPack common = new FakeConditionPack();
		assertTrue(new SumOfEmissions().apply(success(common), success(common)).successful());
	}

	@Test
	public void sumOfSuccessesAndFailureIsFailure() {
		ConditionPack common = new FakeConditionPack();
		assertFalse(new SumOfEmissions().apply(success(common), failure(common)).successful());
	}

	@Test
	public void sumOfFailureAndSuccessIsFailure() {
		ConditionPack common = new FakeConditionPack();
		assertFalse(new SumOfEmissions().apply(failure(common), success(common)).successful());
	}

	@Test
	public void sumOfFailuresIsFailure() {
		ConditionPack common = new FakeConditionPack();
		assertFalse(new SumOfEmissions().apply(failure(common), failure(common)).successful());
	}

	@Test(expected = NullPointerException.class)
	public void prohibitsNullFirstOperand() {
		new SumOfEmissions().apply(null, success(new FakeConditionPack()));
	}

	@Test(expected = NullPointerException.class)
	public void prohibitsNullSecondOperand() {
		new SumOfEmissions().apply(success(new FakeConditionPack()), null);
	}

	@Test
	public void sumsPermissions() {
		ConditionPack common = new FakeConditionPack();
		assertEquals(2, //
				new SumOfEmissions().apply(//
						new Emission.Successful(common, new FakePermission()), //
						new Emission.Successful(common, new FakePermission()))//
						.permissions().size());
	}

	@Test
	public void sumsDiagnostics() {
		ConditionPack common = new FakeConditionPack();
		assertEquals(2, new SumOfEmissions()//
				.apply(failure(common), failure(common))//
				.failureDiagnostic()//
				.troubles()//
				.size());
	}

	@Test(expected = Exception.class)
	public void doesNotSumDifferentPacks() {
		new SumOfEmissions().apply(//
				new Emission.Successful(new FakeConditionPack(), new FakePermission()), //
				new Emission.Successful(new FakeConditionPack(), new FakePermission()));
	}

	private Successful success(ConditionPack pack) {
		return new Emission.Successful(pack, Collections.emptyList());
	}

	private Failed failure(ConditionPack pack) {
		return new Emission.Failed(pack, new BaseFailureDiagnostic(new TroubleCode.Of(0, "0"), "")); //$NON-NLS-1$ //$NON-NLS-2$
	}
}