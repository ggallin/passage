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
package org.eclipse.passage.lbc.internal.api;

import org.eclipse.passage.lic.internal.api.conditions.mining.ContentType;

/**
 * @since 1.0
 */
public interface BackendLicensingRequest {

	ContentType contentType();

	String parameter(String key);

	String body();

	Requester requester();
}
