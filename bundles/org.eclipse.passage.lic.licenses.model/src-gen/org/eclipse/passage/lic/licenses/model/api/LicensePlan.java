/*******************************************************************************
 * Copyright (c) 2019, 2020 ArSysOp
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
package org.eclipse.passage.lic.licenses.model.api;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.passage.lic.licenses.LicensePlanDescriptor;
import org.eclipse.passage.lic.licenses.LicensePlanFeatureDescriptor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>License Plan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.passage.lic.licenses.model.api.LicensePlan#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.licenses.model.api.LicensePlan#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.licenses.model.api.LicensePlan#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.licenses.model.api.LicensePlan#getLicensePlanFeatures <em>License Plan Features</em>}</li>
 * </ul>
 *
 * @see org.eclipse.passage.lic.licenses.model.meta.LicensesPackage#getLicensePlan()
 * @model superTypes="org.eclipse.passage.lic.licenses.model.api.LicensePlanDescriptor"
 * @generated
 */
public interface LicensePlan extends EObject, LicensePlanDescriptor {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.eclipse.passage.lic.licenses.model.meta.LicensesPackage#getLicensePlan_Identifier()
	 * @model id="true"
	 * @generated
	 */
	@Override
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.passage.lic.licenses.model.api.LicensePlan#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.passage.lic.licenses.model.meta.LicensesPackage#getLicensePlan_Name()
	 * @model
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.passage.lic.licenses.model.api.LicensePlan#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.passage.lic.licenses.model.meta.LicensesPackage#getLicensePlan_Description()
	 * @model
	 * @generated
	 */
	@Override
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.passage.lic.licenses.model.api.LicensePlan#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>License Plan Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.passage.lic.licenses.LicensePlanFeatureDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>License Plan Features</em>' containment reference list.
	 * @see org.eclipse.passage.lic.licenses.model.meta.LicensesPackage#getLicensePlan_LicensePlanFeatures()
	 * @model type="org.eclipse.passage.lic.licenses.model.api.LicensePlanFeatureDescriptor" containment="true"
	 * @generated
	 */
	@Override
	EList<LicensePlanFeatureDescriptor> getLicensePlanFeatures();

} // LicensePlan
