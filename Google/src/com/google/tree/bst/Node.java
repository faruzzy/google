package com.google.tree.bst;

public abstract class Node<T extends Comparable<T>> {

	private final T value;

	public Node(final T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

}
