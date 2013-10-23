package com.thinking.java.classtest;

import java.util.ArrayList;
import java.util.List;

public class FildedList<T> {

	private Class<T> type;

	public FildedList(Class<T> type) {
		this.type = type;
	}

	public List<T> create(int nElements) {
		List<T> result = new ArrayList<T>();

		try {
			for (int i = 0; i < nElements; i++) {
				result.add(type.newInstance());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	public static void main(String[] args) {
		FildedList<CountedInteger> fl = new FildedList<CountedInteger>(
				CountedInteger.class);
		System.out.println(fl.create(15));
	}

}
