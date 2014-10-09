package com.google.linklist;

public class Node {

	private final int data;
	private Node next;

	public Node(final int data) {
		this.data = data;
		next = null;
	}

	public Node cut() {
		final Node node = next;
		next = null;
		return node;
	}

	public int getData() {
		return data;
	}

	public int getLength() {
		int length = 1;
		Node cur = next;
		while (cur != null) {
			cur = cur.next;
			length++;
		}
		return length;
	}

	public Node next() {
		return next;
	}

	public boolean hasNext() {
		return next != null;
	}

	public void setNext(final Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();
		Node cur = next;
		buffer.append(data);
		while (cur != null) {
			buffer.append(", ").append(cur.data);
			cur = cur.next;
		}
		return buffer.toString();
	}

}
