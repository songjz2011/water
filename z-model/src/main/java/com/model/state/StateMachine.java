package com.model.state;

import java.util.Iterator;


/**
 * @author songjz 
 * @time 2013年8月27日
 */
public class StateMachine {
	
	private State currentState;
	
	public StateMachine(State initialState) {
		this.currentState = initialState;
		this.currentState.run();
	}
	
	public final void runAll(Iterator<? extends Input> inputs) {
		while(inputs.hasNext()) {
			Input i = inputs.next();
			System.out.println(i);
			this.currentState = currentState.next(i);
			currentState.run();
		}
	}

}
