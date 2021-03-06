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
package org.eclipse.passage.lic.internal.licenses.migration.tobemoved;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.passage.lic.internal.api.conditions.Condition;
import org.eclipse.passage.lic.internal.api.conditions.EvaluationType;
import org.eclipse.passage.lic.internal.api.conditions.MatchingRule;
import org.eclipse.passage.lic.internal.api.conditions.mining.ConditionTransport;
import org.eclipse.passage.lic.internal.api.conditions.mining.ContentType;
import org.eclipse.passage.lic.internal.base.conditions.BaseCondition;
import org.eclipse.passage.lic.internal.base.conditions.BaseEvaluationInstructions;
import org.eclipse.passage.lic.internal.base.conditions.BaseValidityPeriodClosed;
import org.eclipse.passage.lic.internal.base.conditions.BaseVersionMatch;
import org.eclipse.passage.lic.internal.base.conditions.MatchingRuleDefault;
import org.eclipse.passage.lic.internal.base.conditions.MatchingRuleForIdentifier;
import org.eclipse.passage.lic.internal.licenses.migration.LicensesResourceHandler;
import org.eclipse.passage.lic.licenses.model.api.LicenseGrant;
import org.eclipse.passage.lic.licenses.model.api.LicensePack;

public final class XmiConditionTransport implements ConditionTransport {

	private final ContentType type = new ContentType.Xml();

	@Override
	public ContentType id() {
		return type;
	}

	@Override
	public Collection<Condition> read(InputStream input) throws IOException {
		Resource resource = new XMIResourceImpl();
		resource.load(input,
				Collections.singletonMap(XMLResource.OPTION_RESOURCE_HANDLER, new LicensesResourceHandler()));
		return resource.getContents().stream() //
				.filter(LicensePack.class::isInstance) //
				.map(LicensePack.class::cast) //
				.map(LicensePack::getLicenseGrants) //
				.flatMap(i -> StreamSupport.stream(i.spliterator(), false)) //
				.map(this::condition) //
				.collect(Collectors.toList());
	}

	private Condition condition(LicenseGrant descriptor) {
		return new BaseCondition(descriptor.getIdentifier(), //
				descriptor.getFeatureIdentifier(), //
				new BaseVersionMatch(descriptor.getMatchVersion(), //
						rule(descriptor.getMatchRule())), //
				new BaseValidityPeriodClosed(//
						fromDate(descriptor.getValidFrom()), //
						fromDate(descriptor.getValidUntil())), //
				new BaseEvaluationInstructions(//
						new EvaluationType.Of(descriptor.getConditionType()), //
						descriptor.getConditionExpression()));
	}

	/**
	 * It looks like default matching rule is not persisted my EMF, this we expect
	 * {@code null} here
	 */
	private MatchingRule rule(String origin) {
		if (origin == null) {
			return new MatchingRuleDefault();
		}
		return new MatchingRuleForIdentifier(origin).get();
	}

	private ZonedDateTime fromDate(Date date) {
		if (date == null) {
			// it should be in the past to be marked as invalid
			return ZonedDateTime.now().minusMinutes(1);
		}
		return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

}
