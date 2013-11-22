package com.web.things.springioc.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.web.things.springioc.entity.Person;

@Component
public class AnnotationBean {

	private static int i;

	@Bean
	@Qualifier("public")
	public Person publicInstance() {
		Person person = new Person();
		person.setName("ComponentAnnotation publicInstance 名称");
		person.setAddress("publicInstance address");
		return person;
	}

	// use of a custom qualifier and autowiring of method parameters

	@Bean
	protected Person protectedInstance(@Qualifier("public") Person spouse,
			@Value("#{privateInstance.address}") String address) {
		Person person = new Person();
		person.setName("ComponentAnnotation protectedInstance 名称");
		person.setAddress(address);
		return person;
	}

	@Bean
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	private Person privateInstance() {
		Person person = new Person();
		person.setName("ComponentAnnotation privateInstance 名称");
		i++;
		return person;
	}
}
