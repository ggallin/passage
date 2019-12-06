/*******************************************************************************
 * Copyright (c) 2019 ArSysOp
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     ArSysOp - initial API and implementation
 *******************************************************************************/
package org.eclipse.passage.lic.integration.tests.permissionobservatory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.passage.lic.base.LicensingProperties;

/**
 * Bundle activation properties for {@code EquinoxPermissionObservatory}
 * 
 * @since 0.6
 */
class ConditionType {
	private final String type;

	ConditionType(String type) {
		this.type = type;
	}

	Map<String, Object> map() {
		Map<String, Object> output = new HashMap<>();
		output.put(LicensingProperties.LICENSING_CONDITION_TYPE_ID, type);
		return output;
	}
}