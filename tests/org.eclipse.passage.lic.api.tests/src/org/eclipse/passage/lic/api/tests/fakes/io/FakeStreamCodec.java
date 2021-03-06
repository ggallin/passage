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
package org.eclipse.passage.lic.api.tests.fakes.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

import org.eclipse.passage.lic.internal.api.LicensedProduct;
import org.eclipse.passage.lic.internal.api.LicensingException;
import org.eclipse.passage.lic.internal.api.io.DigestExpectation;
import org.eclipse.passage.lic.internal.api.io.EncryptionAlgorithm;
import org.eclipse.passage.lic.internal.api.io.EncryptionKeySize;
import org.eclipse.passage.lic.internal.api.io.StreamCodec;

@SuppressWarnings("restriction")
public final class FakeStreamCodec implements StreamCodec, LicensedProduct {

	@Override
	public LicensedProduct id() {
		return this;
	}

	@Override
	public EncryptionAlgorithm algorithm() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EncryptionKeySize keySize() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void createKeyPair(Path publicKey, Path privateKey, String username, String password)
			throws LicensingException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void encode(InputStream input, OutputStream output, InputStream key, String username, String password)
			throws LicensingException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void decode(InputStream input, OutputStream output, InputStream key, DigestExpectation digest)
			throws LicensingException {
		// do nothing, it' a fake
	}

	@Override
	public String identifier() {
		return "fake-product-streammed"; //$NON-NLS-1$
	}

	@Override
	public String version() {
		return "1.0.0"; //$NON-NLS-1$
	}

}
