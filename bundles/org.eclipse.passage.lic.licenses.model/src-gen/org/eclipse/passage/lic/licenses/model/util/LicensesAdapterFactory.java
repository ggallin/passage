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
package org.eclipse.passage.lic.licenses.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.passage.lic.licenses.LicenseGrantDescriptor;
import org.eclipse.passage.lic.licenses.LicensePackDescriptor;
import org.eclipse.passage.lic.licenses.LicensePlanDescriptor;
import org.eclipse.passage.lic.licenses.LicensePlanFeatureDescriptor;
import org.eclipse.passage.lic.licenses.model.api.*;
import org.eclipse.passage.lic.licenses.model.api.LicenseGrant;
import org.eclipse.passage.lic.licenses.model.api.LicensePack;
import org.eclipse.passage.lic.licenses.model.meta.LicensesPackage;

/**
 * <!-- begin-user-doc -->
 * 
 * The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model.
 * 
 * <!-- end-user-doc -->
 * @see org.eclipse.passage.lic.licenses.model.meta.LicensesPackage
 * @generated
 */
public class LicensesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LicensesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LicensesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = LicensesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * 
	 * This implementation returns <code>true</code> if the object is either the
	 * model's package or is an instance object of the model.
	 * 
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LicensesSwitch<Adapter> modelSwitch = new LicensesSwitch<Adapter>() {
		@Override
		public Adapter caseLicensePlanDescriptor(LicensePlanDescriptor object) {
			return createLicensePlanDescriptorAdapter();
		}

		@Override
		public Adapter caseLicensePlanFeatureDescriptor(LicensePlanFeatureDescriptor object) {
			return createLicensePlanFeatureDescriptorAdapter();
		}

		@Override
		public Adapter caseLicensePackDescriptor(LicensePackDescriptor object) {
			return createLicensePackDescriptorAdapter();
		}

		@Override
		public Adapter caseLicenseGrantDescriptor(LicenseGrantDescriptor object) {
			return createLicenseGrantDescriptorAdapter();
		}

		@Override
		public Adapter caseLicensePlan(LicensePlan object) {
			return createLicensePlanAdapter();
		}

		@Override
		public Adapter caseLicensePlanFeature(LicensePlanFeature object) {
			return createLicensePlanFeatureAdapter();
		}

		@Override
		public Adapter caseLicensePack(LicensePack object) {
			return createLicensePackAdapter();
		}

		@Override
		public Adapter caseLicenseGrant(LicenseGrant object) {
			return createLicenseGrantAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.passage.lic.licenses.LicensePlanDescriptor <em>License Plan Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.passage.lic.licenses.LicensePlanDescriptor
	 * @generated
	 */
	public Adapter createLicensePlanDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.passage.lic.licenses.LicensePlanFeatureDescriptor <em>License Plan Feature Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.passage.lic.licenses.LicensePlanFeatureDescriptor
	 * @generated
	 */
	public Adapter createLicensePlanFeatureDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.passage.lic.licenses.LicensePackDescriptor <em>License Pack Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * 
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * 
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.passage.lic.licenses.LicensePackDescriptor
	 * @generated
	 */
	public Adapter createLicensePackDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.passage.lic.licenses.LicenseGrantDescriptor <em>License Grant Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * 
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * 
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.passage.lic.licenses.LicenseGrantDescriptor
	 * @generated
	 */
	public Adapter createLicenseGrantDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.passage.lic.licenses.model.api.LicensePlan <em>License Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.passage.lic.licenses.model.api.LicensePlan
	 * @generated
	 */
	public Adapter createLicensePlanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.passage.lic.licenses.model.api.LicensePlanFeature <em>License Plan Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.passage.lic.licenses.model.api.LicensePlanFeature
	 * @generated
	 */
	public Adapter createLicensePlanFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.passage.lic.licenses.model.api.LicensePack <em>License Pack</em>}'.
	 * <!-- begin-user-doc -->
	 * 
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * 
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.passage.lic.licenses.model.api.LicensePack
	 * @generated
	 */
	public Adapter createLicensePackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.passage.lic.licenses.model.api.LicenseGrant <em>License Grant</em>}'.
	 * <!-- begin-user-doc -->
	 * 
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * 
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.passage.lic.licenses.model.api.LicenseGrant
	 * @generated
	 */
	public Adapter createLicenseGrantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * 
	 * This default implementation returns null.
	 * 
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // LicensesAdapterFactory
