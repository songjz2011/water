package com.model.state;

/**
 * @author songjz
 * @time 2013年8月27日
 */
public class MouseTrap extends StateMachine {

	public static State waiting = new Waiting(), luring = new Luring(), trapping = new Trapping(),
			holding = new Holding();

	public MouseTrap() {
		super(waiting);
	}

}
