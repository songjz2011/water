package com.model.state;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author songjz
 * @time 2013年8月27日
 */
public class MouseTrapTest {

	private static MouseTrap trap;

	private static MouseMoveList mouseMoveList;

	@BeforeClass
	public static void beforeClass() {
		trap = new MouseTrap();
		String textFilePath = MouseTrapTest.class.getClassLoader().getResource("MouseMoves.txt")
				.getPath();
		StringList stringList = new StringList(textFilePath);
		mouseMoveList = new MouseMoveList(stringList.iterator());
	}
	
	@Test
	public void runAll() {
		try {
			trap.runAll(mouseMoveList.iterator());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
