package org.eclipse.passage.loc.internal.workbench.wizards;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.passage.lic.emf.meta.EntityMetadata;
import org.eclipse.passage.loc.internal.emf.EditingDomainRegistry;
import org.eclipse.passage.loc.workbench.LocWokbench;

/**
 * Creates new root licensing object. Can be asked for a reference to a created
 * instance.
 * 
 */
public final class RootClassifierWizard extends BaseClassifierWizard<RootClassifierWizardPage> {

	/**
	 * Creates a new wizard for root licensing object with given metadata,
	 * initializer and registry
	 * 
	 * @param metadata    describes EMF metadata for an object to be created, must
	 *                    not be <code>null</code>
	 * @param registry    registry for an object to be created, must not be
	 *                    <code>null</code>
	 * @see BaseClassifierWizard
	 * @see EntityMetadata
	 * @see EditingDomainRegistry
	 * 
	 */
	public RootClassifierWizard(EntityMetadata metadata, EditingDomainRegistry<?> registry) {
		super(metadata, registry);
	}

	@Override
	protected RootClassifierWizardPage createNewClassifierPage() {
		return new RootClassifierWizardPage(metadata, registry.getFileExtension());
	}

	@Override
	protected void store() {
		store(newClassifierPage.path(), newClassifierPage.candidate());
	}

	protected void store(String path, EObject candidate) {
		URI fileURI = URI.createFileURI(path);
		Resource resource = resourceSet().createResource(fileURI);
		resource.getContents().add(candidate);
		LocWokbench.save(resource);
		registry.registerSource(fileURI.toFileString());
	}

}
