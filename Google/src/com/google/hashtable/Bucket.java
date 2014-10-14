package com.google.hashtable;

public class Bucket {

	private final Object key;
	private Object value;

	private Bucket next;

	public Bucket(final Object key, final Object value) {
		this.key = key;
		this.value = value;
	}

	public Object getKey() {
		return key;
	}

	public Bucket getNext() {
		return next;
	}

	public Object getValue() {
		return value;
	}

	public boolean hasNext() {
		return next != null;
	}

	public boolean isKey(final Object otherKey) {
		return key.equals(otherKey);
	}

	public void setNext(final Bucket next) {
		this.next = next;
	}

	public void setValue(final Object value) {
		this.value = value;
	}

}
