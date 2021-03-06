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
package org.eclipse.passage.lic.floating.edit.providers;

import java.util.function.Supplier;

final class GetOrUnknown implements Supplier<String> {

	private final String nullable;

	GetOrUnknown(String nullable) {
		this.nullable = nullable;
	}

	@Override
	public String get() {
		return nullable == null ? "unknown" : nullable; //$NON-NLS-1$
	}

}
