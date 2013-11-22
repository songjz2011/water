package com.web.things.springioc.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("annotationQualifier")
public class AnnotationQualifierForClass {

}
