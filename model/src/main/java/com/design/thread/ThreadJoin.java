package com.design.thread;

/**
 * <pre>
 * Thread.join方法测试
 * 
 * Java Thread中， join() 方法主要是让调用改方法的thread完成run方法里面的东西后， 
 * 再执行join()方法后面的代码
 * </pre>
 * 
 * @author songjz
 * @time 2014年5月4日
 */
public class ThreadJoin {

	class ThreadJoinA implements Runnable {
		private int counter;

		public void run() {
			while (counter <= 10) {
				System.out.print("Counter = " + counter + " ");
				counter++;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
			System.out.println("----------------");
		}
	}

	class ThreadJoinB implements Runnable {
		private int i;

		public void run() {
			while (i <= 10) {
				System.out.print("i = " + i + " ");
				i++;
			}
			System.out.println();
		}
	}

	public void test() throws InterruptedException {
		Thread t1 = new Thread(new ThreadJoinA());
		Thread t2 = new Thread(new ThreadJoinB());
		t1.start();
		t1.join(); // wait t1 to be finished
		t2.start();
		t2.join(); // in this program, this may be removed
	}

	public static void main(String[] args) throws InterruptedException {
		new ThreadJoin().test();
	}

}
