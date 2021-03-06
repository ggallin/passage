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
package org.eclipse.passage.lbc.internal.base.i18n;

import org.eclipse.osgi.util.NLS;

public class BaseMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.passage.lbc.internal.base.i18n.BaseMessages"; //$NON-NLS-1$
	public static String BaseRequestDispatcher_e_executor_not_available;
	public static String ServerKeyKeeper_input_stream_error;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, BaseMessages.class);
	}

	private BaseMessages() {
	}
}
