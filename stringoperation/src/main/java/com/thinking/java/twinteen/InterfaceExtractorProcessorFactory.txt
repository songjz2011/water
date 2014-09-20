package com.thinking.java.twinteen;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

/**
 * @author songjz
 * 
 */
public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sun.mirror.apt.AnnotationProcessorFactory#getProcessorFor(java.util
	 * .Set, com.sun.mirror.apt.AnnotationProcessorEnvironment)
	 */
	public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> arg0,
			AnnotationProcessorEnvironment env) {
		return new InterfaceExtractorProcessor(env);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sun.mirror.apt.AnnotationProcessorFactory#supportedAnnotationTypes()
	 */
	public Collection<String> supportedAnnotationTypes() {
		// TODO Auto-generated method stub
		return Collections.singleton("com.thinking.java.twinteen.ExtractInterface");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sun.mirror.apt.AnnotationProcessorFactory#supportedOptions()
	 */
	public Collection<String> supportedOptions() {
		return Collections.emptySet();
	}

}
