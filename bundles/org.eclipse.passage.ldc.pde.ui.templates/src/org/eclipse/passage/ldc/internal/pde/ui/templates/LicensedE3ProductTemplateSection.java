package org.eclipse.passage.ldc.internal.pde.ui.templates;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.internal.ui.templates.IHelpContextIds;
import org.eclipse.pde.internal.ui.templates.PDETemplateMessages;
import org.eclipse.pde.ui.IFieldData;

public class LicensedE3ProductTemplateSection extends BaseLicensedTemplateSection {

	private static final String LICENSED_E3_PRODUCT = "LicensedE3Product"; //$NON-NLS-1$

	public LicensedE3ProductTemplateSection() {
		setPageCount(1);
		createOptions();
	}

	@Override
	public void addPages(Wizard wizard) {
		WizardPage page = createPage(0, IHelpContextIds.TEMPLATE_RCP_MAIL);
		page.setTitle(PDETemplateMessages.HelloRCPTemplate_title);
		page.setDescription(PDETemplateMessages.HelloRCPTemplate_desc);
		wizard.addPage(page);
		markPagesAdded();
	}

	private void createOptions() {
		addOption(KEY_WINDOW_TITLE, PDETemplateMessages.HelloRCPTemplate_windowTitle, "Licensed RCP", 0); //$NON-NLS-1$
		addOption(KEY_PACKAGE_NAME, PDETemplateMessages.MailTemplate_packageName, (String) null, 0);
		addOption(KEY_APPLICATION_CLASS, PDETemplateMessages.HelloRCPTemplate_appClass, "LicensedApplication", 0); //$NON-NLS-1$
	}

	@Override
	protected void initializeFields(IFieldData data) {
		// In a new project wizard, we don't know this yet - the
		// model has not been created
		String packageName = getFormattedPackageName(data.getId());
		initializeOption(KEY_PACKAGE_NAME, packageName);
	}

	@Override
	public void initializeFields(IPluginModelBase modelBase) {
		String packageName = getFormattedPackageName(modelBase.getPluginBase().getId());
		initializeOption(KEY_PACKAGE_NAME, packageName);
	}

	@Override
	public String getSectionId() {
		return LICENSED_E3_PRODUCT;
	}

	@Override
	protected void updateModel(IProgressMonitor monitor) throws CoreException {
		setManifestHeader("Bundle-ActivationPolicy", "lazy"); //$NON-NLS-1$ //$NON-NLS-2$
		String productFqn = getStringOption(KEY_PACKAGE_NAME) + '.' + VALUE_PRODUCT_ID;
		createLicensingCapability(productFqn);
		String classValue = getStringOption(KEY_PACKAGE_NAME) + '.' + getStringOption(KEY_APPLICATION_CLASS);
		createApplicationExtension(VALUE_APPLICATION_ID, classValue);
		createPerspectiveExtension();
		createProductExtension();
		createProcessorExtension(VALUE_PROCESSOR_LICENSING_ID, VALUE_PROCESSOR_LICENSING_CLASS);
	}

	private void createPerspectiveExtension() throws CoreException {
		IPluginBase plugin = model.getPluginBase();

		IPluginExtension extension = createExtension("org.eclipse.ui.perspectives", true); //$NON-NLS-1$
		IPluginElement element = model.getPluginFactory().createElement(extension);
		element.setName("perspective"); //$NON-NLS-1$
		element.setAttribute("class", getStringOption(KEY_PACKAGE_NAME) + ".Perspective"); //$NON-NLS-1$ //$NON-NLS-2$
		element.setAttribute("name", VALUE_PERSPECTIVE_NAME); //$NON-NLS-1$
		element.setAttribute("id", plugin.getId() + ".perspective"); //$NON-NLS-1$ //$NON-NLS-2$
		extension.add(element);

		if (!extension.isInTheModel()) {
			plugin.add(extension);
		}
	}

	private void createProductExtension() throws CoreException {
		IPluginBase plugin = model.getPluginBase();
		IPluginExtension extension = createExtension("org.eclipse.core.runtime.products", true); //$NON-NLS-1$
		extension.setId(VALUE_PRODUCT_ID);

		IPluginElement element = model.getFactory().createElement(extension);
		element.setName("product"); //$NON-NLS-1$
		element.setAttribute("name", getStringOption(KEY_WINDOW_TITLE)); //$NON-NLS-1$
		element.setAttribute("application", plugin.getId() + "." + VALUE_APPLICATION_ID); //$NON-NLS-1$ //$NON-NLS-2$

		extension.add(element);

		if (!extension.isInTheModel()) {
			plugin.add(extension);
		}
	}

	@Override
	public IPluginReference[] getDependencies(String schemaVersion) {
		return getDependencies(getRCP3xDependencies());
	}

}
