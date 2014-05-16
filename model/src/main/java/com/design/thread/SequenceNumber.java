package com.design.thread;

/**
 * <pre>
 * ThreadLoad使用测试
 * </pre>
 * 
 * @author songjz
 * @time 2014年5月13日
 */
public class SequenceNumber {

	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 0;
		}
	};

	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}

	private static class TestSequenceNumberDemo extends Thread {
		private SequenceNumber sn;

		public TestSequenceNumberDemo(SequenceNumber sn) {
			this.sn = sn;
		}

		public void run() {
			// 每个线程打出3个序列值
			for (int i = 0; i < 3; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append("thread[").append(Thread.currentThread().getName()).append("]");
				sb.append(" sn[").append(sn.getNextNum()).append("]");
				sb.append(" --").append(seqNum);
				System.out.println(sb.toString());
			}
		}

	}

	public static void main(String[] args) {
		SequenceNumber sn1 = new SequenceNumber();
		SequenceNumber sn2 = new SequenceNumber();
		SequenceNumber sn3 = new SequenceNumber();
		// 3个线程共享sn，各自产生序列号
//		TestSequenceNumberDemo t1 = new TestSequenceNumberDemo(sn1);
//		TestSequenceNumberDemo t2 = new TestSequenceNumberDemo(sn2);
//		TestSequenceNumberDemo t3 = new TestSequenceNumberDemo(sn3);
//		t1.start();
//		t2.start();
//		t3.start();
		sn1.getNextNum();
		sn2.getNextNum();
	}

}
