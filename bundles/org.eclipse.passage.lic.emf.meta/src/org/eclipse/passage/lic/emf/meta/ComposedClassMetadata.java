package org.eclipse.passage.lic.emf.meta;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * Creates composed class metadata to suitable for dynamic environment
 * 
 * @since 0.6
 */
public final class ComposedClassMetadata implements ComposableClassMetadata {

	private final Set<ClassMetadata> registry;

	public ComposedClassMetadata() {
		registry = new LinkedHashSet<>();
	}

	@Override
	public Optional<EntityMetadata> find(Class<?> clazz) {
		return registry.stream()//
				.map(m -> m.find(clazz))//
				.filter(Optional::isPresent)//
				.map(Optional::get)//
				.findFirst();
	}

	@Override
	public void consider(ClassMetadata fragment) {
		Objects.requireNonNull(fragment);
		registry.add(fragment);
	}

	@Override
	public void forget(ClassMetadata fragment) {
		Objects.requireNonNull(fragment);
		registry.remove(fragment);
	}

}
