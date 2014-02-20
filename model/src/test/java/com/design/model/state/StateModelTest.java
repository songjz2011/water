package com.design.model.state;

import org.junit.Test;

import com.design.model.status.ForenoonState;
import com.design.model.status.State;
import com.design.model.status.Work;

public class StateModelTest {

	@Test
	public void test() {
		Work work = new Work();
		State initState = new ForenoonState();
		work.setCurrentState(initState);
		
		work.setHour(8);
		work.writeProgram();
		
		work.setHour(12);
		work.writeProgram();
		
		work.setHour(13);
		work.writeProgram();
		
		work.setHour(17);
		work.writeProgram();
	}

}
