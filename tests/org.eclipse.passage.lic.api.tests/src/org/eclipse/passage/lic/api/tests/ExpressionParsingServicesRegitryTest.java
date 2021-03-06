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
package org.eclipse.passage.lic.api.tests;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

import org.eclipse.passage.lic.api.tests.fakes.conditions.evaluation.FakeExpressionParsingService;
import org.eclipse.passage.lic.internal.api.Framework;
import org.eclipse.passage.lic.internal.api.conditions.evaluation.ExpressionParsingService;

/**
 * <p>
 * Check that {@linkplain Framework} instance in use supplies read only
 * collection of condition expression parsing services.
 * </p>
 * <p>
 * Each {@code Framework} implementation must supply a test extending this class
 * and satisfy all the demands.
 * </p>
 */
@SuppressWarnings("restriction")
public abstract class ExpressionParsingServicesRegitryTest extends ReadOnlyCollectionTest<ExpressionParsingService> {

	@Override
	protected final Supplier<Collection<ExpressionParsingService>> collection() {
		return () -> framework().get().accessCycleConfiguration().expressionParsers().get().services();
	}

	@Override
	protected final ExpressionParsingService single() {
		return new FakeExpressionParsingService();
	}

	protected abstract Optional<Framework> framework();

}
