package com.thinking.java.twentyone2;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> result = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			result.add(exec.submit(new TaskWithResult(i)));
		}
		for(Future<String> fs : result) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				exec.shutdown();
			}
		}
	}
}
