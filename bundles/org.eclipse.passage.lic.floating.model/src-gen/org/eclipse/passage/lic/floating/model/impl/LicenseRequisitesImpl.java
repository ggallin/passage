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

import java.util.Date;
import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.passage.lic.floating.model.api.LicenseRequisites;
import org.eclipse.passage.lic.floating.model.api.ProductRef;
import org.eclipse.passage.lic.floating.model.api.ValidityPeriod;
import org.eclipse.passage.lic.floating.model.meta.FloatingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>License
 * Requisites</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.passage.lic.floating.model.impl.LicenseRequisitesImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.floating.model.impl.LicenseRequisitesImpl#getIssueDate <em>Issue Date</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.floating.model.impl.LicenseRequisitesImpl#getCompany <em>Company</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.floating.model.impl.LicenseRequisitesImpl#getPlan <em>Plan</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.floating.model.impl.LicenseRequisitesImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.floating.model.impl.LicenseRequisitesImpl#getValid <em>Valid</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LicenseRequisitesImpl extends MinimalEObjectImpl.Container implements LicenseRequisites {
	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	private String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getIssueDate() <em>Issue Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIssueDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date ISSUE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIssueDate() <em>Issue Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIssueDate()
	 * @generated
	 * @ordered
	 */
	private Date issueDate = ISSUE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompany() <em>Company</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCompany()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPANY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompany() <em>Company</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCompany()
	 * @generated
	 * @ordered
	 */
	private String company = COMPANY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlan() <em>Plan</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPlan()
	 * @generated
	 * @ordered
	 */
	protected static final String PLAN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlan() <em>Plan</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPlan()
	 * @generated
	 * @ordered
	 */
	private String plan = PLAN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProduct() <em>Product</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected ProductRef product;

	/**
	 * The cached value of the '{@link #getValid() <em>Valid</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getValid()
	 * @generated
	 * @ordered
	 */
	protected ValidityPeriod valid;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LicenseRequisitesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FloatingPackage.eINSTANCE.getLicenseRequisites();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FloatingPackage.LICENSE_REQUISITES__IDENTIFIER,
					oldIdentifier, identifier));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getIssueDate() {
		return issueDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIssueDate(Date newIssueDate) {
		Date oldIssueDate = issueDate;
		issueDate = newIssueDate;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FloatingPackage.LICENSE_REQUISITES__ISSUE_DATE,
					oldIssueDate, issueDate));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCompany() {
		return company;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompany(String newCompany) {
		String oldCompany = company;
		company = newCompany;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FloatingPackage.LICENSE_REQUISITES__COMPANY,
					oldCompany, company));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPlan() {
		return plan;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlan(String newPlan) {
		String oldPlan = plan;
		plan = newPlan;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FloatingPackage.LICENSE_REQUISITES__PLAN, oldPlan,
					plan));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProductRef getProduct() {
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProduct(ProductRef newProduct, NotificationChain msgs) {
		ProductRef oldProduct = product;
		product = newProduct;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					FloatingPackage.LICENSE_REQUISITES__PRODUCT, oldProduct, newProduct);
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
	public void setProduct(ProductRef newProduct) {
		if (newProduct != product) {
			NotificationChain msgs = null;
			if (product != null)
				msgs = ((InternalEObject) product).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - FloatingPackage.LICENSE_REQUISITES__PRODUCT, null, msgs);
			if (newProduct != null)
				msgs = ((InternalEObject) newProduct).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - FloatingPackage.LICENSE_REQUISITES__PRODUCT, null, msgs);
			msgs = basicSetProduct(newProduct, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FloatingPackage.LICENSE_REQUISITES__PRODUCT,
					newProduct, newProduct));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValidityPeriod getValid() {
		return valid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValid(ValidityPeriod newValid, NotificationChain msgs) {
		ValidityPeriod oldValid = valid;
		valid = newValid;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					FloatingPackage.LICENSE_REQUISITES__VALID, oldValid, newValid);
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
	public void setValid(ValidityPeriod newValid) {
		if (newValid != valid) {
			NotificationChain msgs = null;
			if (valid != null)
				msgs = ((InternalEObject) valid).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - FloatingPackage.LICENSE_REQUISITES__VALID, null, msgs);
			if (newValid != null)
				msgs = ((InternalEObject) newValid).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - FloatingPackage.LICENSE_REQUISITES__VALID, null, msgs);
			msgs = basicSetValid(newValid, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FloatingPackage.LICENSE_REQUISITES__VALID, newValid,
					newValid));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FloatingPackage.LICENSE_REQUISITES__PRODUCT:
			return basicSetProduct(null, msgs);
		case FloatingPackage.LICENSE_REQUISITES__VALID:
			return basicSetValid(null, msgs);
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
		case FloatingPackage.LICENSE_REQUISITES__IDENTIFIER:
			return getIdentifier();
		case FloatingPackage.LICENSE_REQUISITES__ISSUE_DATE:
			return getIssueDate();
		case FloatingPackage.LICENSE_REQUISITES__COMPANY:
			return getCompany();
		case FloatingPackage.LICENSE_REQUISITES__PLAN:
			return getPlan();
		case FloatingPackage.LICENSE_REQUISITES__PRODUCT:
			return getProduct();
		case FloatingPackage.LICENSE_REQUISITES__VALID:
			return getValid();
		default:
			return super.eGet(featureID, resolve, coreType);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case FloatingPackage.LICENSE_REQUISITES__IDENTIFIER:
			setIdentifier((String) newValue);
			return;
		case FloatingPackage.LICENSE_REQUISITES__ISSUE_DATE:
			setIssueDate((Date) newValue);
			return;
		case FloatingPackage.LICENSE_REQUISITES__COMPANY:
			setCompany((String) newValue);
			return;
		case FloatingPackage.LICENSE_REQUISITES__PLAN:
			setPlan((String) newValue);
			return;
		case FloatingPackage.LICENSE_REQUISITES__PRODUCT:
			setProduct((ProductRef) newValue);
			return;
		case FloatingPackage.LICENSE_REQUISITES__VALID:
			setValid((ValidityPeriod) newValue);
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
		case FloatingPackage.LICENSE_REQUISITES__IDENTIFIER:
			setIdentifier(IDENTIFIER_EDEFAULT);
			return;
		case FloatingPackage.LICENSE_REQUISITES__ISSUE_DATE:
			setIssueDate(ISSUE_DATE_EDEFAULT);
			return;
		case FloatingPackage.LICENSE_REQUISITES__COMPANY:
			setCompany(COMPANY_EDEFAULT);
			return;
		case FloatingPackage.LICENSE_REQUISITES__PLAN:
			setPlan(PLAN_EDEFAULT);
			return;
		case FloatingPackage.LICENSE_REQUISITES__PRODUCT:
			setProduct((ProductRef) null);
			return;
		case FloatingPackage.LICENSE_REQUISITES__VALID:
			setValid((ValidityPeriod) null);
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
		case FloatingPackage.LICENSE_REQUISITES__IDENTIFIER:
			return !Objects.equals(IDENTIFIER_EDEFAULT, identifier);
		case FloatingPackage.LICENSE_REQUISITES__ISSUE_DATE:
			return !Objects.equals(ISSUE_DATE_EDEFAULT, issueDate);
		case FloatingPackage.LICENSE_REQUISITES__COMPANY:
			return !Objects.equals(COMPANY_EDEFAULT, company);
		case FloatingPackage.LICENSE_REQUISITES__PLAN:
			return !Objects.equals(PLAN_EDEFAULT, plan);
		case FloatingPackage.LICENSE_REQUISITES__PRODUCT:
			return product != null;
		case FloatingPackage.LICENSE_REQUISITES__VALID:
			return valid != null;
		default:
			return super.eIsSet(featureID);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (identifier: "); //$NON-NLS-1$
		result.append(identifier);
		result.append(", issueDate: "); //$NON-NLS-1$
		result.append(issueDate);
		result.append(", company: "); //$NON-NLS-1$
		result.append(company);
		result.append(", plan: "); //$NON-NLS-1$
		result.append(plan);
		result.append(')');
		return result.toString();
	}

} // LicenseRequisitesImpl
