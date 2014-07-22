package com.desing.model.queue;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

/**
 * <pre>
 * 用两个栈实现队列 &amp;&amp; 用两个队列实现一个栈 Test
 * </pre>
 * 
 * @author songjz
 * @time 2014年7月22日
 */
public class QueueImplementByTwoStacksTest {
	
	private QueueImplementByTwoStacks queue;
	
	@Before
	public void before() {
		queue = new QueueImplementByTwoStacks();
	}

	@Test
	public void test() {
		queue.add(1);
		queue.add(2);
		queue.add(3);
		//assertThat(1, is(queue.poll()));
		assertThat(1, equalTo(queue.poll()));
	}
	
}
