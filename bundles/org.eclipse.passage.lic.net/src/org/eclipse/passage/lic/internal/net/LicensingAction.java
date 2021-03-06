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
package org.eclipse.passage.lic.internal.net;

import java.util.Map;
import java.util.function.Function;

import org.eclipse.passage.lic.internal.api.conditions.ConditionAction;
import org.eclipse.passage.lic.internal.base.BaseNamedData;

@SuppressWarnings("restriction")
public final class LicensingAction extends BaseNamedData<ConditionAction> {

	public LicensingAction(Function<String, ConditionAction> retrieve) {
		super(retrieve);
	}

	public LicensingAction(Map<String, Object> data) {
		super(key -> new ConditionAction.Of(String.valueOf(data.get(key))));
	}

	public LicensingAction(ConditionAction action) {
		super(key -> action);
	}

	@Override
	public String key() {
		return "action"; //$NON-NLS-1$
	}

}
