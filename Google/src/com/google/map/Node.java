package com.google.map;

public class Node<K, V> {

	private final K key;
	private final V value;

	public Node(final K key, final V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

}
