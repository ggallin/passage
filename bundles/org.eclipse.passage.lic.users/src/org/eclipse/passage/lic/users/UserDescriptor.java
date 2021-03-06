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
package org.eclipse.passage.lic.users;

/**
 * <p>
 * A <code>"User"</code> describes the licensee of your functionality.
 * <p>
 *
 */
public interface UserDescriptor {

	/**
	 * Returns the identifier of this user. Currently identification is performed
	 * via <code>"email"</code> attribute This is the value of its
	 * <code>"identifier"</code> attribute.
	 *
	 * @return the identifier
	 * @see #getEmail()
	 */
	String getIdentifier();

	/**
	 * Returns the email of this user, currently used as an identifier. This is the
	 * value of its <code>"email"</code> attribute.
	 *
	 * @return the email
	 */
	String getEmail();

	/**
	 * Returns the full name of this user. This is the value of its
	 * <code>"fullName"</code> attribute.
	 *
	 * @return the full name
	 */
	String getFullName();

	/**
	 * Returns the description of this user. This is the value of its
	 * <code>"description"</code> attribute.
	 *
	 * @return the description
	 */
	String getDescription();

	/**
	 * Returns the preferred condition type of this user. This is the value of its
	 * <code>"preferredConditionType"</code> attribute.
	 *
	 * @return the preferred condition type
	 * @since 0.5.0
	 * @see LicenseGrantDescriptor#getConditionType()
	 */
	String getPreferredConditionType();

	/**
	 * Returns the preferred condition expression of this user. This is the value of
	 * its <code>"preferredConditionExpression"</code> attribute.
	 *
	 * @return the preferred condition expression
	 * @since 0.5.0
	 * @see LicenseGrantDescriptor#getConditionExpression()
	 */
	String getPreferredConditionExpression();

	/**
	 * Returns the containing origin of this user.
	 *
	 * @return the user origin
	 */
	UserOriginDescriptor getUserOrigin();

	/**
	 * Returns the <code>"User License"</code>(s) issued for this user plan. This is
	 * the value of its <code>"userLicenses"</code> reference.
	 *
	 * @return the user licenses
	 */
	Iterable<? extends UserLicenseDescriptor> getUserLicenses();
}
