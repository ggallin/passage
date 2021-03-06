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
package org.eclipse.passage.lic.internal.jface.dialogs.licensing;

import java.util.Map;
import java.util.function.Function;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

class HereLabelProvider<T> implements ITableLabelProvider, ITableColorProvider {

	private final Map<Integer, Function<T, String>> texts;
	private final Class<T> cls;

	HereLabelProvider(Map<Integer, Function<T, String>> texts, Class<T> cls) {
		this.texts = texts;
		this.cls = cls;
	}

	@Override
	public Color getForeground(Object element, int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getBackground(Object element, int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getColumnImage(Object element, int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int column) {
		return texts.get(column).apply(cls.cast(element));
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
	}
}
