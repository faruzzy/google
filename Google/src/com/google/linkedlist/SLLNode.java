package com.google.linkedlist;

public class SLLNode<T> {

	private final T value;
	private SLLNode<T> next;

	public SLLNode(final T value) {
		this.value = value;
		next = null;
	}

	public SLLNode<T> getNext() {
		return next;
	}

	public T getValue() {
		return value;
	}

	public boolean hasNext() {
		return next != null;
	}

	public void setNext(final SLLNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
