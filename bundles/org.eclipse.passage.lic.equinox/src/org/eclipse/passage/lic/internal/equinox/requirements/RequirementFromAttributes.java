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

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import org.eclipse.osgi.util.NLS;
import org.eclipse.passage.lic.internal.api.ServiceInvocationResult;
import org.eclipse.passage.lic.internal.api.diagnostic.Trouble;
import org.eclipse.passage.lic.internal.api.requirements.Requirement;
import org.eclipse.passage.lic.internal.api.restrictions.RestrictionLevel;
import org.eclipse.passage.lic.internal.base.BaseServiceInvocationResult;
import org.eclipse.passage.lic.internal.base.diagnostic.code.ServiceFailedOnMorsel;
import org.eclipse.passage.lic.internal.base.requirements.BaseFeature;
import org.eclipse.passage.lic.internal.base.requirements.BaseRequirement;
import org.eclipse.passage.lic.internal.base.restrictions.DefaultRestrictionLevel;
import org.eclipse.passage.lic.internal.base.version.DefaultVersion;
import org.eclipse.passage.lic.internal.base.version.SafeVersion;
import org.eclipse.passage.lic.internal.equinox.i18n.EquinoxMessages;
import org.osgi.framework.Bundle;

/**
 * Looks for {@linkplain Requirement} declaration in a single
 * {@code Capability}.
 * 
 * @see RequirementsFromBundle
 * @see BundleRequirements
 */
@SuppressWarnings("restriction")
final class RequirementFromAttributes implements Supplier<ServiceInvocationResult<Collection<Requirement>>> {

	private final Bundle bundle;
	private final Map<String, Object> attributes;

	public RequirementFromAttributes(Bundle bundle, Map<String, Object> attributes) {
		this.bundle = bundle;
		this.attributes = attributes;
	}

	@Override
	public ServiceInvocationResult<Collection<Requirement>> get() {
		Optional<String> feature = new CapabilityLicFeatureId(attributes).get();
		if (!feature.isPresent()) {
			return fail(NLS.bind(EquinoxMessages.RequirementsFromCapability_no_feature_id, //
					new LicCapabilityNamespace().get(), new BundleName(bundle).get()));
		}
		return succeed(requirementFromAttributes(feature.get()));
	}

	private Requirement requirementFromAttributes(String feature) {
		String version = new CapabilityLicFeatureVersion(attributes).get()//
				.map(value -> new SafeVersion(value).value())//
				.orElse(new DefaultVersion().value());
		String name = new CapabilityLicFeatureName(attributes).get()//
				.orElse(feature);
		String provider = new CapabilityLicFeatureProvider(attributes).get()//
				.orElseGet(new BundleVendor(bundle));
		RestrictionLevel level = new CapabilityLicFeatureLevel(attributes).get()//
				.<RestrictionLevel>map(RestrictionLevel.Of::new) //
				.orElseGet(new DefaultRestrictionLevel());
		BaseRequirement requirement = new BaseRequirement(//
				new BaseFeature(feature, version, name, provider), //
				level, //
				bundle.getSymbolicName());
		return requirement;
	}

	private ServiceInvocationResult<Collection<Requirement>> fail(String explanation) {
		return new BaseServiceInvocationResult<>(new Trouble(new ServiceFailedOnMorsel(), explanation));
	}

	private ServiceInvocationResult<Collection<Requirement>> succeed(Requirement requirement) {
		return new BaseServiceInvocationResult<>(Collections.singleton(requirement));
	}

}
