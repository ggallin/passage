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
package org.eclipse.passage.loc.yars.internal.api.model;

import java.util.Arrays;
import java.util.List;

import org.eclipse.passage.loc.yars.internal.api.Storage;

@SuppressWarnings("restriction")
public class InMemoryStorage implements Storage<StoredEntry> {

	private final List<StoredEntry> dummies;

	InMemoryStorage(List<StoredEntry> dummies) {
		this.dummies = dummies;
	}

	public InMemoryStorage(StoredEntry... dummies) {
		this(Arrays.asList(dummies));
	}

	public List<StoredEntry> entries() {
		return dummies;
	}

}
