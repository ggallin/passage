/*******************************************************************************
 * Copyright (c) 2018, 2020 ArSysOp
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
package org.eclipse.passage.lic.equinox.tests;

import static org.junit.Assert.assertNotNull;

import org.eclipse.passage.lic.api.requirements.LicensingRequirement;
import org.eclipse.passage.lic.internal.equinox.requirements.BundleCapabilityResolver;
import org.junit.Test;
import org.mockito.Mockito;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.runtime.ServiceComponentRuntime;
import org.osgi.service.log.LoggerFactory;

@SuppressWarnings("restriction")
public class BundleCapabilityResolverTest {

	@Test
	public void testResolveRequirements() {
		BundleCapabilityResolver resolver = new BundleCapabilityResolver();
		ServiceComponentRuntime src = Mockito.mock(ServiceComponentRuntime.class);
		resolver.bindScr(src);
		LoggerFactory factory = Mockito.mock(LoggerFactory.class);
		resolver.bindLoggerFactory(factory);
		BundleContext mock = Mockito.mock(BundleContext.class);
		Mockito.doReturn(new Bundle[0]).when(mock).getBundles();
		resolver.activate(mock);
		Iterable<LicensingRequirement> requirements = resolver.resolveLicensingRequirements(null);
		assertNotNull(requirements);
		resolver.deactivate();
		resolver.unbindLoggerFactory(factory);
		resolver.unbindScr(src);
	}

}
