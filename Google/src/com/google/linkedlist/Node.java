package com.google.linkedlist;

public class Node<T> {

	private final T value;
	private Node<T> next;

	public Node(final T value) {
		this.value = value;
		next = null;
	}

	public Node<T> getNext() {
		return next;
	}

	public T getValue() {
		return value;
	}

	public boolean hasNext() {
		return next != null;
	}

	public void setNext(final Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
