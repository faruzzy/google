package com.google.linklistsort;

public class SortLinkedList {

	public static boolean isSorted(final Node head) {
		Node cur = head;
		while (cur.hasNext()) {
			final Node node = cur.getNext();
			if (node.getValue() < cur.getValue())
				return false;
			cur = node;
		}
		return true;
	}

	public static void main(final String... args) {
		testSort();
	}

	public static int[] randomData(final int length) {
		final int[] data = new int[length];
		for (int i = 0; i < length; ++i) {
			final int r = (int) ((i + 1) * Math.random());
			data[i] = data[r];
			data[r] = i;
		}
		return data;
	}

	public static void testSort() {
		for (int length = 10; length < 10000001; length *= 10) {
			Node head = toLinkedList(randomData(length));
			head = QuickLinkSort.sort(head);
			if (!isSorted(head)) {
				System.out.println(head);
				System.out.println("oops");
				break;
			}
		}
		System.out.println("done");
	}

	public static Node toLinkedList(final int... data) {
		final Node head = new Node(data[0]);
		Node cur = head;
		for (int i = 1; i < data.length; ++i) {
			final Node node = new Node(data[i]);
			cur.setNext(node);
			cur = node;
		}
		return head;
	}

}
