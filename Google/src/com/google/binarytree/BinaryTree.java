package com.google.binarytree;

import com.google.datastructures.GenericStack;
import com.google.sorting.TestSorting;

public class BinaryTree<T extends Comparable<T>> {

	private Node<T> root;
	private int size;

	public BinaryTree() {
		root = null;
		size = 0;
	}

	public static void main(final String... args) {
		final int length = 30;
		final int[] data = TestSorting.randomData(length);

		final BinaryTree<Integer> binaryTree = new BinaryTree<>();
		for (int i = 0; i < length; ++i)
			binaryTree.insert(data[i]);

		System.out.println(binaryTree);
	}

	public void insert(final T value) {
		final Node<T> node = new Node<>(value);
		if (root == null)
			root = node;
		else {
			Node<T> curr = root;
			for (;;)
				if (curr.compareTo(node) <= 0) {
					if (curr.hasLeft())
						curr = curr.getLeft();
					else {
						curr.setLeft(node);
						break;
					}
				} else if (curr.hasRight())
					curr = curr.getRight();
				else {
					curr.setRight(node);
					break;
				}
		}
		++size;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();

		final GenericStack<Node<T>> stack = new GenericStack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			final Node<T> curr = stack.pop();
			if (curr.hasLeft())
				stack.push(curr.getLeft());
			if (curr.hasRight())
				stack.push(curr.getRight());
			builder.append(curr).append(' ');
		}

		return builder.toString();
	}

}
