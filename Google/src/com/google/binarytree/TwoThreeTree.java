package com.google.binarytree;

import com.google.sorting.TestSorting;

public class TwoThreeTree<Key extends Comparable<Key>, Value> implements BinaryTree<Key, Value> {

	private RedBlackNode<Key, Value> root;
	private int size;

	public TwoThreeTree() {
		root = null;
		size = 0;
	}

	public static void main(final String... args) {
		final BinaryTree<Integer, String> binaryTree = new TwoThreeTree<>();

		final int length = 3000;
		final int[] data = TestSorting.randomData(length);
		for (int i = 0; i < length; i += 2)
			binaryTree.put(data[i], Integer.toString(data[i]) + "s");

		for (int i = 0; i < length; ++i)
			if (binaryTree.get(data[i]) == null == (i % 2 == 0))
				System.out.println("OOPS " + i);

		System.out.println("done");
	}

	@Override
	public void delete(final Key key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value get(final Key key) {
		return get(root, key);
	}

	public int getSize() {
		return size;
	}

	@Override
	public void put(final Key key, final Value value) {
		root = put(root, key, value);
		root.setRed(false);
	}

	private int findHeight(final RedBlackNode<Key, Value> node, final int height, final int level) {
		if (node == null)
			return height < level ? level : height;

		if (node.hasLeft())
			findHeight(node.getLeft(), height, level + 1);

		return 0;
	}

	private void flipColours(final RedBlackNode<Key, Value> node) {
		node.getLeft().setRed(false);
		node.getRight().setRed(false);
		node.setRed(true);
	}

	private Value get(final RedBlackNode<Key, Value> node, final Key key) {
		if (node == null)
			return null;
		final int compare = node.compareTo(key);
		if (compare == 0)
			return node.getValue();
		if (compare > 0)
			return get(node.getLeft(), key);
		return get(node.getRight(), key);
	}

	private RedBlackNode<Key, Value> put(final RedBlackNode<Key, Value> node, final Key key, final Value value) {
		if (node == null) {
			++size;
			return new RedBlackNode<>(key, value);
		}

		RedBlackNode<Key, Value> head = node;

		final int compare = head.compareTo(key);
		if (compare > 0)
			head.setLeft(put(head.getLeft(), key, value));
		else if (compare < 0)
			head.setRight(put(head.getRight(), key, value));
		else
			head.setValue(value);

		if (head.isLeftBlack() && head.isRightRed())
			head = rotateLeft(head);
		if (head.isLeftRed() && head.getLeft().isLeftRed())
			head = rotateRight(head);
		if (head.isLeftRed() && head.isRightRed())
			flipColours(head);

		return head;
	}

	private RedBlackNode<Key, Value> rotateLeft(final RedBlackNode<Key, Value> node) {
		final RedBlackNode<Key, Value> temp = node.getRight();
		node.setRight(temp.getLeft());
		temp.setLeft(node);
		temp.setRed(node.isRed());
		node.setRed(true);
		return temp;
	}

	private RedBlackNode<Key, Value> rotateRight(final RedBlackNode<Key, Value> node) {
		final RedBlackNode<Key, Value> temp = node.getLeft();
		node.setLeft(temp.getRight());
		temp.setRight(node);
		temp.setRed(node.isRed());
		node.setRed(true);
		return temp;
	}

}
