package com.web.things.springioc;

/**
 * 私有构造函数，通过静态方法构建对象
 * 
 * @author songjz
 * @time 2013年10月12日
 */
public class ExampleBean3 {

	private ExampleBean3Another another;

	private int id;
	
	private ExampleBean3(ExampleBean3Another another, int id) {
		this.another = another;
		this.id = id;
	}

	public static ExampleBean3 createInstance(ExampleBean3Another another, int id) {
		return new ExampleBean3(another, id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ExampleBean3Another getAnother() {
		return another;
	}

	public void setAnother(ExampleBean3Another another) {
		this.another = another;
	}

}
