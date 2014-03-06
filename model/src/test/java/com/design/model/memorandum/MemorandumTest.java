package com.design.model.memorandum;

import org.junit.Test;

public class MemorandumTest {

	@Test
	public void test() {
		/*
		 * 初始数据
		 */
		Originator originator = new Originator();
		originator.setState("On");
		originator.showMemento();
		
		/*
		 * 对数据进行备忘
		 */
		Memento memento = originator.createMemento();
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(memento);
		
		/*
		 * 修改了数据 
		 */
		originator.setState("Off");
		originator.showMemento();
		
		/*
		 * 回滚备忘的数据
		 */
		originator.setMemento(caretaker.getMemento());
		originator.showMemento();
	}
	
}
