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
package org.eclipse.passage.loc.internal.licenses.trouble.code;

import org.eclipse.passage.lic.internal.api.diagnostic.TroubleCode;
import org.eclipse.passage.loc.internal.licenses.core.i18n.LicenseTroubleCodeMessages;

public final class LicenseIssuingFailed extends TroubleCode {

	public LicenseIssuingFailed() {
		super(900, LicenseTroubleCodeMessages.LicenseValidationFailed_explanation);
	}

}
