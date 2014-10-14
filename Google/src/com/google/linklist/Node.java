package com.google.linklist;

public class Node {

	private final int value;
	private Node next;

	public Node(final int value) {
		this.value = value;
		next = null;
	}

	public int getLength() {
		Node cur = next;
		int length = 1;
		while (cur != null) {
			length++;
			cur = cur.next;
		}
		return length;
	}

	public Node getNext() {
		return next;
	}

	public int getValue() {
		return value;
	}

	public boolean hasNext() {
		return next != null;
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

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append(value);
		Node cur = next;
		while (cur != null) {
			builder.append(", ").append(cur.value);
			cur = cur.next;
		}
		return builder.toString();
	}

}
