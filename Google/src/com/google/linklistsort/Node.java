package com.google.linklistsort;

public class Node {

	private final int value;
	private Node next;

	public Node(final int value) {
		this.value = value;
		next = null;
	}

	public Node getNext() {
		return next;
	}

	public int getValue() {
		return value;
	}

	public void insertNext(final Node node) {
		node.next = next;
		next = node;
	}

	public Node popNext() {
		final Node node = next;
		if (node != null) {
			next = node.next;
			node.next = null;
		}
		return node;
	}

	public void setNext(final Node next) {
		this.next = next;
	}

}
