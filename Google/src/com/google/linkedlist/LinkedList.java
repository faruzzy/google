package com.google.linkedlist;

public class LinkedList<T> {

	private SLLNode<T> head;
	private SLLNode<T> tail;
	private int length;

	public LinkedList() {
		head = tail = null;
		length = 0;
	}

	public static void main(final String... args) {
		final LinkedList<String> linkedList = new LinkedList<>();
		linkedList.append("Hello");
		linkedList.append("World");
		linkedList.prepend("Why");

		linkedList.insert("new end", 3);
		linkedList.insert("new start", 0);

		linkedList.insert("index 3", 3);

		System.out.println(linkedList);
		System.out.println(linkedList.getLength());

		System.out.println(linkedList.get(3));

		linkedList.reverse();

		System.out.println(linkedList);

		linkedList.append("new new end");

		System.out.println(linkedList);
	}

	public void append(final T value) {
		final SLLNode<T> node = new SLLNode<>(value);
		if (tail == null)
			head = tail = node;
		else {
			tail.setNext(node);
			tail = node;
		}
		++length;
	}

	public void clear() {
		head = tail = null;
		length = 0;
	}

	public T get(final int index) {
		if (index == 0)
			return head == null ? null : head.getValue();
		if (index == length - 1)
			return tail == null ? null : tail.getValue();
		if (index < 0 || index >= length)
			throw new IndexOutOfBoundsException();

		SLLNode<T> curr = head;
		for (int i = 0; i < index; ++i)
			curr = curr.getNext();

		return curr.getValue();
	}

	public int getLength() {
		return length;
	}

	public void insert(final T value, final int index) {
		if (index == 0)
			prepend(value);
		else if (index == length)
			append(value);
		else if (index > 0 && index < length) {
			SLLNode<T> curr = head;
			for (int i = 1; i < index; ++i)
				curr = curr.getNext();
			final SLLNode<T> node = new SLLNode<>(value);
			node.setNext(curr.getNext());
			curr.setNext(node);
			length++;
		} else
			throw new IndexOutOfBoundsException();
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public void prepend(final T value) {
		final SLLNode<T> node = new SLLNode<>(value);
		if (head == null)
			head = tail = node;
		else {
			node.setNext(head);
			head = node;
		}
		++length;
	}

	public void reverse() {
		if (head == null)
			return;

		tail = head;
		while (tail.hasNext()) {
			final SLLNode<T> next = tail.getNext();
			tail.setNext(next.getNext());
			next.setNext(head);
			head = next;
		}
	}

	public void set(final T value, final int index) {
		final SLLNode<T> node = new SLLNode<>(value);

		if (index == 0) {
			node.setNext(head == null ? null : head.getNext());
			if (head == tail)
				head = tail = node;
			else
				head = node;
		}
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append('[');
		builder.append(head);
		if (head != null) {
			SLLNode<T> curr = head.getNext();
			while (curr != null) {
				builder.append(", ").append(curr);
				curr = curr.getNext();
			}
		}
		builder.append(']');
		return builder.toString();
	}

}
