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
package org.eclipse.passage.lic.internal.api.restrictions;

import org.eclipse.passage.lic.internal.api.LicensedProduct;
import org.eclipse.passage.lic.internal.api.conditions.evaluation.Permission;
import org.eclipse.passage.lic.internal.api.diagnostic.TroubleCode;
import org.eclipse.passage.lic.internal.api.requirements.Requirement;

/**
 * </p>
 * At the end of access cycle a {@linkplain Requirement} stays uncovered: none
 * of the leased {@linkplain Permission}s fit the {@code requirement}'s demands.
 * </p>
 * <p>
 * For each case of this sort a separate instance of {@code Restriction} is
 * created.
 * </p>
 * <p>
 * All restrictions begotten then come to {@code execution} - licensing
 * protection in action.
 * </p>
 */
public interface Restriction {

	LicensedProduct product();

	Requirement unsatisfiedRequirement();

	TroubleCode reason();

}
