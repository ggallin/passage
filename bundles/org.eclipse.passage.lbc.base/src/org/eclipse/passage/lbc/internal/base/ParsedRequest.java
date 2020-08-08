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
package org.eclipse.passage.lbc.internal.base;

import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.passage.lbc.internal.api.MiningRequest;
import org.eclipse.passage.lbc.internal.api.Requester;
import org.eclipse.passage.lic.internal.base.ProductIdentifier;
import org.eclipse.passage.lic.internal.base.ProductVersion;

/**
 * @since 1.0
 */
public final class ParsedRequest implements Function<HttpServletRequest, MiningRequest> {

	@Override
	public MiningRequest apply(HttpServletRequest request) {
		ProductIdentifier productId = new ProductIdentifier(key -> request.getParameter(key));
		ProductVersion productVersion = new ProductVersion(key -> request.getParameter(key));
		Requester user = new Requester(key -> request.getParameter(key));
		return new BaseMiningRequest(productId, productVersion, user);
	}

}
