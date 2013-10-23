package com.thinking.java.seventin9;

import java.util.AbstractMap;
import java.util.Set;

import sun.misc.OSEnvironment;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	static final int SIZE = 997;

	// LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return null;
	}

}
