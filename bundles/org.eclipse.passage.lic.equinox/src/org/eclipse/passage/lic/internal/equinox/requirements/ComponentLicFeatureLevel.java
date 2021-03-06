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
package org.eclipse.passage.lic.internal.equinox.requirements;

import java.util.Map;

import org.eclipse.passage.lic.internal.api.restrictions.RestrictionLevel;
import org.eclipse.passage.lic.internal.base.NamedData;
import org.eclipse.passage.lic.internal.base.StringNamedData;

/**
 * Encapsulate reading of a raw {@linkplain RestrictionLevel} identifier from
 * {@code OSGi component}'s properties for the requirement under construction.
 * 
 * @see NamedData
 */
public final class ComponentLicFeatureLevel extends StringNamedData {

	public ComponentLicFeatureLevel(String version) {
		super(version);
	}

	public ComponentLicFeatureLevel(Map<String, Object> container) {
		super(container);
	}

	@Override
	public String key() {
		return "licensing.restriction.level"; //$NON-NLS-1$
	}

}
