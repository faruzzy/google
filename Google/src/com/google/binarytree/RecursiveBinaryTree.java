package com.google.binarytree;

public class RecursiveBinaryTree<Key extends Comparable<Key>, Value> implements BinaryTree<Key, Value> {

	private BinaryNode<Key, Value> root;
	private int size;

	public RecursiveBinaryTree() {
		root = null;
		size = 0;
	}

	public static void main(final String... args) {
		final BinaryTree<Integer, String> binaryTree = new RecursiveBinaryTree<>();

		for (int i = 0; i < 300; i += 2)
			binaryTree.put(i, Integer.toString(i) + "s");

		
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
	}

	private Value get(final BinaryNode<Key, Value> node, final Key key) {
		if (node == null)
			return null;
		final int compare = node.compareTo(key);
		if (compare == 0)
			return node.getValue();
		if (compare > 0)
			return get(node.getLeft(), key);
		return get(node.getRight(), key);
	}

	private BinaryNode<Key, Value> put(final BinaryNode<Key, Value> node, final Key key, final Value value) {
		if (node == null) {
			++size;
			return new BinaryNode<>(key, value);
		}

		final int compare = node.compareTo(key);
		if (compare > 0)
			node.setLeft(put(node.getLeft(), key, value));
		else if (compare < 0)
			node.setRight(put(node.getRight(), key, value));
		else
			node.setValue(value);

		return node;
	}

}
