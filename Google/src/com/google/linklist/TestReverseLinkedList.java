package com.google.linklist;

public class TestReverseLinkedList {

	public static void test() {
		int length = 31;
		Node head = makeLinkedList(length);
		System.out.println(head);
		head = ReverseLinkedList.reverse(head);
		System.out.println(head);
	}
	
	private static Node makeLinkedList(int length) {
		Node head = new Node(0);
		Node curr = head;
		for (int i = 1; i < length; ++i) {
			Node node = new Node(i);
			curr.setNext(node);
			curr = node;
		}
		return head;
	}
	
}
