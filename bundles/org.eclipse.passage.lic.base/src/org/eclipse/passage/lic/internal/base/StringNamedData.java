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
package org.eclipse.passage.lic.internal.base;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * Auxiliary implementation for string valued data, as in the most cases we are
 * interested in retrieving string data.
 * 
 * @see NamedData
 */
public abstract class StringNamedData extends BaseNamedData<String> {

	protected StringNamedData(String value) {
		super(key -> value);
	}

	protected StringNamedData(Function<String, String> retrieve) {
		super(retrieve);
	}

	protected StringNamedData(Map<String, Object> container) {
		super(key -> Optional.ofNullable(container.get(key))//
				.map(String::valueOf) //
				.orElse(null));
	}

	@Override
	public String printed(String value) {
		return value;
	}

}
