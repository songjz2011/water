package com.model.state;

/**
 * @author songjz 
 * @time 2013年8月27日
 */
public interface State {

	void run();
	
	State next(Input i);
	
}
