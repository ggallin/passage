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
package org.eclipse.passage.lic.jface;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.passage.lic.equinox.ApplicationConfigurations;
import org.eclipse.passage.lic.equinox.requirements.EquinoxRequirements;
import org.eclipse.passage.lic.equinox.restrictions.EquinoxRestrictions;
import org.eclipse.passage.lic.jface.dialogs.LicensingStatusDialog;
import org.eclipse.passage.lic.runtime.ConfigurationRequirement;
import org.eclipse.passage.lic.runtime.LicensingConfiguration;
import org.eclipse.passage.lic.runtime.RestrictionVerdict;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class LicensingWidgets {

	public static IStatus validateLicense(String featureId) {
		LicensingConfiguration licensingConfiguration = ApplicationConfigurations.getLicensingConfiguration();
		Shell shell = Display.getDefault().getActiveShell();
		return validateLicense(featureId, licensingConfiguration, shell);
	}

	public static IStatus validateLicense(String featureId, Shell shell) {
		LicensingConfiguration licensingConfiguration = ApplicationConfigurations.getLicensingConfiguration();
		return validateLicense(featureId, licensingConfiguration, shell);
	}

	public static IStatus validateLicense(String featureId, LicensingConfiguration configuration, Shell shell) {
		Iterable<ConfigurationRequirement> required = EquinoxRequirements.getFeatureRequirements(featureId, configuration);
		Iterator<ConfigurationRequirement> iterator = required.iterator();
		if (!iterator.hasNext()) {
			return Status.OK_STATUS;
		}
		String featureName = iterator.next().getFeatureName();
		Iterable<RestrictionVerdict> verdicts = EquinoxRestrictions.getFeatureVerdicts(featureId, configuration);
		IStatus status = EquinoxRestrictions.getRestrictionStatus(verdicts, featureName);
		if (status.isOK()) {
			return status;
		}
		LicensingStatusDialog dialog = new LicensingStatusDialog(shell);
		
		dialog.updateLicensingStatus(required, verdicts);
		dialog.open();
		
		return status;
	}
}
