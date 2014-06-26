package com.design.model.iterator;

/**
 * <pre>
 * 迭代器
 * </pre>
 * 
 * @author songjz
 * @time 2014年6月24日
 */
public interface IteratorModel {

	Object first();
	
	Object next();
	
	boolean isDone();
	
	Object currentItem();
	
}
