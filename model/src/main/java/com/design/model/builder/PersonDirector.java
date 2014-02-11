package com.design.model.builder;

/**
 * <pre>
 * 绘制小人 调用 对象
 * </pre>
 * 
 * @author songjz
 * @time 2014年1月22日
 */
public class PersonDirector {

	public static void builderPerson(PersonBuilder personBuilder) {
		personBuilder.builderHead();
		personBuilder.builderBody();
		personBuilder.builderLeftArm();
		personBuilder.builderRightArm();
		personBuilder.builderLeftLeg();
		personBuilder.builderRightLeg();
	}
	
}
