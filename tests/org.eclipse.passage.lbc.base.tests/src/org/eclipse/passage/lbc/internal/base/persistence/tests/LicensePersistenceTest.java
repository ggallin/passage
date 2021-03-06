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
package org.eclipse.passage.lbc.internal.base.persistence.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.emf.common.util.URI;
import org.eclipse.passage.lbc.base.tests.LbcTestsBase;
import org.eclipse.passage.lbc.internal.api.persistence.PersistableLicense;
import org.eclipse.passage.lbc.internal.base.persistence.LockFolder;
import org.eclipse.passage.lbc.json.JsonLoadedLicense;
import org.eclipse.passage.lbc.json.JsonPersistableLicense;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

@SuppressWarnings("restriction")
public final class LicensePersistenceTest extends LbcTestsBase {

	@Rule
	public final TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void persistence() {
		JsonPersistableLicense persistable = new JsonPersistableLicense(boundLicense(1, 3),
				new LockFolder(() -> root()));
		try {
			folder.newFolder("locked"); //$NON-NLS-1$
			folder.newFile(condition().identifier());
			persistable.save();
			PersistableLicense loaded = new JsonLoadedLicense(new LockFolder(() -> root()))
					.apply(condition()).get();
			assertEquals(persistable.get().identifier().get().get(), loaded.get().identifier().get().get());
			assertEquals(persistable.get().taken().get().get(), loaded.get().taken().get().get());
			assertEquals(persistable.get().capacity().get().get(), loaded.get().capacity().get().get());
			assertTrue(loaded.get().takeable());
		} catch (IOException e) {
			fail();
		}
	}

	private Path root() {
		return Paths.get(URI.decode(folder.getRoot().getAbsolutePath()));
	}

}
