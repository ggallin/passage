/*******************************************************************************
 * Copyright (c) 2018-2019 ArSysOp
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
package org.eclipse.passage.lic.internal.features.migration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.passage.lic.emf.ecore.util.DelegatingEPackage;
import org.eclipse.passage.lic.features.model.meta.FeaturesPackage;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component
public class FeaturesMigrator {

	@Activate
	public void activate() {
		String nsUri = "http://www.eclipse.org/passage/lic/0.3.3"; //$NON-NLS-1$
		FeaturesPackage delegate = FeaturesPackage.eINSTANCE;
		List<String> classifiers = new ArrayList<>();
		classifiers.add(delegate.getFeatureSet().getName());
		classifiers.add(delegate.getFeature().getName());
		classifiers.add(delegate.getFeatureVersion().getName());
		DelegatingEPackage.delegate(nsUri, delegate, classifiers);
	}

}