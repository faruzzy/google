package com.google.binarytree;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

	private final T value;
	private Node<T> left, right;

	public Node(final T value) {
		this.value = value;
		left = right = null;
	}

	@Override
	public int compareTo(final Node<T> node) {
		return value.compareTo(node.value);
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}

	public T getValue() {
		return value;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void setLeft(final Node<T> left) {
		this.left = left;
	}

	public void setRight(final Node<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
