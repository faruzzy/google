package com.google.linklist;

public class ReverseLinkedList {

	public static Node reverse(final Node head) {
		Node tail = head;
		while (head.hasNext()) {
			Node next = head.popNext();
			next.setNext(tail);
			tail = next;
		}
		return tail;
	}

}
