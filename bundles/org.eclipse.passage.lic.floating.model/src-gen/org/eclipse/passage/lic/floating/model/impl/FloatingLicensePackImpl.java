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
package org.eclipse.passage.lic.floating.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.passage.lic.floating.model.api.FeatureGrant;
import org.eclipse.passage.lic.floating.model.api.FloatingLicensePack;
import org.eclipse.passage.lic.floating.model.api.FloatingServer;
import org.eclipse.passage.lic.floating.model.api.LicenseRequisites;
import org.eclipse.passage.lic.floating.model.api.UserGrant;
import org.eclipse.passage.lic.floating.model.meta.FloatingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>License
 * Pack</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.passage.lic.floating.model.impl.FloatingLicensePackImpl#getLicense <em>License</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.floating.model.impl.FloatingLicensePackImpl#getHost <em>Host</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.floating.model.impl.FloatingLicensePackImpl#getUsers <em>Users</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.floating.model.impl.FloatingLicensePackImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FloatingLicensePackImpl extends MinimalEObjectImpl.Container implements FloatingLicensePack {
	/**
	 * The cached value of the '{@link #getLicense() <em>License</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected LicenseRequisites license;

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected FloatingServer host;

	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<UserGrant> users;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureGrant> features;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FloatingLicensePackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FloatingPackage.eINSTANCE.getFloatingLicensePack();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LicenseRequisites getLicense() {
		return license;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLicense(LicenseRequisites newLicense, NotificationChain msgs) {
		LicenseRequisites oldLicense = license;
		license = newLicense;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					FloatingPackage.FLOATING_LICENSE_PACK__LICENSE, oldLicense, newLicense);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLicense(LicenseRequisites newLicense) {
		if (newLicense != license) {
			NotificationChain msgs = null;
			if (license != null)
				msgs = ((InternalEObject) license).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - FloatingPackage.FLOATING_LICENSE_PACK__LICENSE, null, msgs);
			if (newLicense != null)
				msgs = ((InternalEObject) newLicense).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - FloatingPackage.FLOATING_LICENSE_PACK__LICENSE, null, msgs);
			msgs = basicSetLicense(newLicense, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FloatingPackage.FLOATING_LICENSE_PACK__LICENSE,
					newLicense, newLicense));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FloatingServer getHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHost(FloatingServer newHost, NotificationChain msgs) {
		FloatingServer oldHost = host;
		host = newHost;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					FloatingPackage.FLOATING_LICENSE_PACK__HOST, oldHost, newHost);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHost(FloatingServer newHost) {
		if (newHost != host) {
			NotificationChain msgs = null;
			if (host != null)
				msgs = ((InternalEObject) host).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - FloatingPackage.FLOATING_LICENSE_PACK__HOST, null, msgs);
			if (newHost != null)
				msgs = ((InternalEObject) newHost).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - FloatingPackage.FLOATING_LICENSE_PACK__HOST, null, msgs);
			msgs = basicSetHost(newHost, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FloatingPackage.FLOATING_LICENSE_PACK__HOST, newHost,
					newHost));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UserGrant> getUsers() {
		if (users == null) {
			users = new EObjectContainmentEList<UserGrant>(UserGrant.class, this,
					FloatingPackage.FLOATING_LICENSE_PACK__USERS);
		}
		return users;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FeatureGrant> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentWithInverseEList<FeatureGrant>(FeatureGrant.class, this,
					FloatingPackage.FLOATING_LICENSE_PACK__FEATURES, FloatingPackage.FEATURE_GRANT__PACK);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FloatingPackage.FLOATING_LICENSE_PACK__FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getFeatures()).basicAdd(otherEnd, msgs);
		default:
			return super.eInverseAdd(otherEnd, featureID, msgs);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FloatingPackage.FLOATING_LICENSE_PACK__LICENSE:
			return basicSetLicense(null, msgs);
		case FloatingPackage.FLOATING_LICENSE_PACK__HOST:
			return basicSetHost(null, msgs);
		case FloatingPackage.FLOATING_LICENSE_PACK__USERS:
			return ((InternalEList<?>) getUsers()).basicRemove(otherEnd, msgs);
		case FloatingPackage.FLOATING_LICENSE_PACK__FEATURES:
			return ((InternalEList<?>) getFeatures()).basicRemove(otherEnd, msgs);
		default:
			return super.eInverseRemove(otherEnd, featureID, msgs);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FloatingPackage.FLOATING_LICENSE_PACK__LICENSE:
			return getLicense();
		case FloatingPackage.FLOATING_LICENSE_PACK__HOST:
			return getHost();
		case FloatingPackage.FLOATING_LICENSE_PACK__USERS:
			return getUsers();
		case FloatingPackage.FLOATING_LICENSE_PACK__FEATURES:
			return getFeatures();
		default:
			return super.eGet(featureID, resolve, coreType);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case FloatingPackage.FLOATING_LICENSE_PACK__LICENSE:
			setLicense((LicenseRequisites) newValue);
			return;
		case FloatingPackage.FLOATING_LICENSE_PACK__HOST:
			setHost((FloatingServer) newValue);
			return;
		case FloatingPackage.FLOATING_LICENSE_PACK__USERS:
			getUsers().clear();
			getUsers().addAll((Collection<? extends UserGrant>) newValue);
			return;
		case FloatingPackage.FLOATING_LICENSE_PACK__FEATURES:
			getFeatures().clear();
			getFeatures().addAll((Collection<? extends FeatureGrant>) newValue);
			return;
		default:
			super.eSet(featureID, newValue);
			return;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case FloatingPackage.FLOATING_LICENSE_PACK__LICENSE:
			setLicense((LicenseRequisites) null);
			return;
		case FloatingPackage.FLOATING_LICENSE_PACK__HOST:
			setHost((FloatingServer) null);
			return;
		case FloatingPackage.FLOATING_LICENSE_PACK__USERS:
			getUsers().clear();
			return;
		case FloatingPackage.FLOATING_LICENSE_PACK__FEATURES:
			getFeatures().clear();
			return;
		default:
			super.eUnset(featureID);
			return;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case FloatingPackage.FLOATING_LICENSE_PACK__LICENSE:
			return license != null;
		case FloatingPackage.FLOATING_LICENSE_PACK__HOST:
			return host != null;
		case FloatingPackage.FLOATING_LICENSE_PACK__USERS:
			return users != null && !users.isEmpty();
		case FloatingPackage.FLOATING_LICENSE_PACK__FEATURES:
			return features != null && !features.isEmpty();
		default:
			return super.eIsSet(featureID);
		}
	}

} // FloatingLicensePackImpl
