package com.desing.model.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 * 用两个栈实现队列 &amp;&amp; 用两个队列实现一个栈
 * </pre>
 * 
 * @author songjz
 * @time 2014年7月22日
 */
public class QueueImplementByTwoStacks {

	/**
	 * 入栈数据
	 */
	private Stack<Integer> inStack;
	/**
	 * 出栈数据
	 */
	private Stack<Integer> outStack;

	QueueImplementByTwoStacks() {
		inStack = new Stack<Integer>();
		outStack = new Stack<Integer>();
	}

	/**
	 * 获取并移除此队列的头，如果此队列为空
	 * @return
	 */
	public Integer poll() {
		// 若出栈数据对象存在数据，则从此种获取数据
		if (!outStack.isEmpty()) {
			return outStack.pop();
		}
		// 若出栈数据对象中不存在数据，则从入栈数据对象中获取
		if (inStack.isEmpty()) {
			return null;
		}
		while (!inStack.isEmpty()) {
			outStack.push(inStack.pop());
		}

		return outStack.pop();
	}

	public Integer add(int o) {
		inStack.push(o);
		return o;
	}

	public static void main(String[] args) {
		QueueImplementByTwoStacks queue = new QueueImplementByTwoStacks();
		List<Integer> re = new ArrayList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		re.add(queue.poll());
		queue.add(4);
		re.add(queue.poll());
		queue.add(5);
		re.add(queue.poll());
		re.add(queue.poll());
		re.add(queue.poll());
		System.out.println(re.toString());
	}

}
