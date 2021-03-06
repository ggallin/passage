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
package org.eclipse.passage.lic.internal.api.access;

import java.util.Optional;

import org.eclipse.passage.lic.internal.api.acquire.GrantAcqisition;
import org.eclipse.passage.lic.internal.api.restrictions.ExaminationCertificate;

public interface GrantLock {

	ExaminationCertificate certificate();

	Optional<GrantAcqisition> grant();

}
