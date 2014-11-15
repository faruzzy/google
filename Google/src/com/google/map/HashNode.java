package com.google.map;

public class HashNode<K, V> {

	private final K key;
	private final V value;

	public HashNode(final K key, final V value) {
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
