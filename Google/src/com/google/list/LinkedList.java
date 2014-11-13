package com.google.list;

public class LinkedList<T> {

	private Node<T> head;

	public void append(final T value) {
		final Node<T> node = new Node<>(value);
		if (head == null)
			head = node;
		else {
			Node<T> curr = head;
			while (curr.hasNext())
				curr = curr.getNext();
			curr.insert(node);
		}
	}

}
