package com.google.hashtable;

public class Cell {

	private final int hash;
	private final Object key, value;

	public Cell(final int hash, final Object key, final Object value) {
		this.hash = hash;
		this.key = key;
		this.value = value;
	}

	public Object getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}

	public boolean isKey(final int otherHash, final Object otherKey) {
		return hash == otherHash && (key == null ? otherKey == null : key.equals(otherKey));
	}

}
