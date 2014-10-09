package com.google.sort;

import com.google.linklist.Node;

public class SortLinkedList {

	public static void main(final String... args) {
		final Node head = randomLinkedList(10);
		System.out.println(head);
		
		Node a = head.cut();
	}
	
	private Node extractLarger(Node head) {
		Node node = null;
		Node cur = head;
		int value = head.getData();
		while (cur.hasNext()) {
			Node temp = cur.next();
			if (temp.getData() > value) {
				if (node == null)
					node = temp;
				else
					node.setNext(temp);
				
				cur.setNext(temp.next());
				temp.setNext(null);
			}
		}
		return node;
	}

	private static int[] randomData(final int length) {
		final int[] data = new int[length];
		for (int i = 0; i < length; ++i) {
			final int r = (int) ((i + 1) * Math.random());
			data[i] = data[r];
			data[r] = i;
		}
		return data;
	}

	private static Node randomLinkedList(final int length) {
		final int[] data = randomData(length);
		final Node head = new Node(data[0]);
		Node cur = head;
		for (int i = 1; i < length; ++i) {
			final Node temp = new Node(data[i]);
			cur.setNext(temp);
			cur = temp;
		}
		return head;
	}

}
