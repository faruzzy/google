package com.google.hashtable;

public class HashCell {

	private final Object key;
	private Object value;

	private HashCell next;

	public HashCell(final Object key, final Object value) {
		this.key = key;
		this.value = value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

	public HashCell getNext() {
		return next;
	}

	public Object getValue() {
		return value;
	}

	public boolean isKey(final Object otherKey) {
		return key.equals(otherKey);
	}

	public void setNext(final HashCell next) {
		this.next = next;
	}
	
	public boolean hasNext() {
		return next != null;
	}

}
