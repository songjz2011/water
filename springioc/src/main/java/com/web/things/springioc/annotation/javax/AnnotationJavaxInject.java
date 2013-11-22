package com.web.things.springioc.annotation.javax;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * <pre>
 * @Inject相当于@Resource
 * </pre>
 * 
 * @author songjz
 * @time 2013年11月22日
 */
@Named
public class AnnotationJavaxInject {

	@Inject
	private AnnotationJavaxNamed annotationJavaxNamed;

	public AnnotationJavaxNamed getAnnotationJavaxNamed() {
		return annotationJavaxNamed;
	}

	public void setAnnotationJavaxNamed(AnnotationJavaxNamed annotationJavaxNamed) {
		this.annotationJavaxNamed = annotationJavaxNamed;
	}

}
