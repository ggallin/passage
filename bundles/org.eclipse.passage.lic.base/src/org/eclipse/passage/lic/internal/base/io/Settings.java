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
package org.eclipse.passage.lic.internal.base.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.eclipse.passage.lic.internal.api.LicensingException;
import org.eclipse.passage.lic.internal.base.i18n.BaseMessages;

/**
 * <p>
 * Traverses all the files down to the given {@code base} directory looking for
 * <i>settings</i> files. These ones are read as property-files one by one and
 * merged into the final map of properties, until {@code enough} predicate (if
 * any) says these is no need to proceed.
 * </p>
 * 
 * @see PassageFileExtension.Settings
 */
public final class Settings {

	private final Supplier<Path> base;
	private final Predicate<Map<String, Object>> enough;

	/**
	 * Tell me where to start searching and when to stop
	 * 
	 * @param base
	 * @param enough
	 */
	public Settings(Supplier<Path> base, Predicate<Map<String, Object>> enough) {
		this.base = base;
		this.enough = enough;
	}

	/**
	 * Load all settings files located under the given {@code base} directory
	 */
	public Settings(Supplier<Path> base) {
		this(base, map -> false);
	}

	public Map<String, Object> get() throws LicensingException {
		HunterForSettingsFiles hunter = new HunterForSettingsFiles();
		try {
			Files.walkFileTree(base.get(), hunter);
		} catch (IOException e) {
			throw new LicensingException(BaseMessages.getString("Settings.error_on_reading_settings"), e); //$NON-NLS-1$
		}
		return hunter.findings();
	}

	private final class HunterForSettingsFiles extends SimpleFileVisitor<Path> {

		private final Map<String, Object> properties;
		private final PassageFileExtension extension = new PassageFileExtension.Settings();

		public HunterForSettingsFiles() {
			this.properties = new HashMap<String, Object>();
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			if (!extension.ends(file)) {
				return FileVisitResult.CONTINUE;
			}
			load(file).stream() //
					.forEach(e -> properties.put(//
							e.getKey().toString(), //
							e.getValue()));
			return enough.test(properties) ? FileVisitResult.TERMINATE : FileVisitResult.CONTINUE;
		}

		private Set<Entry<Object, Object>> load(Path file) throws IOException {
			Properties heap = new Properties();
			try (InputStream stream = new FileInputStream(file.toFile())) {
				heap.load(stream);
			}
			return heap.entrySet();
		}

		Map<String, Object> findings() {
			return properties;
		}

	}

}
