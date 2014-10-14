package com.google.linklist;

/**
 * Sort a linked list using Quick Sort
 *
 * @author Matthew Robertson
 */
public class QuickLinkSort {

	public static Node sort(final Node head) {
		return sort(head, head.getLength());
	}

	private static Node sort(final Node start, final int length) {
		Node head = start;

		if (length < 2)
			return head;

		Node pivot = head.getNext();
		if (pivot.getValue() < head.getValue()) {
			pivot = head;
			head = pivot.popNext();
			head.setNext(pivot);
		}
		final int value = pivot.getValue();

		Node small = head;
		Node big = pivot;
		int countBig = 1;
		for (int i = 2; i < length; ++i) {
			final Node node = big.getNext();
			if (node.getValue() >= value) {
				big = node;
				countBig++;
			} else if (node.getValue() < head.getValue()) {
				big.popNext();
				node.setNext(head);
				head = node;
			} else {
				big.popNext();
				small.insertNext(node);
				small = node;
			}
		}
		final int countSmall = length - countBig;

		sort(head, countSmall);
		sort(pivot, countBig);

		return head;
	}

}
