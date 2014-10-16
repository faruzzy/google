package com.google.tree.bst;

public class TestTree<T extends Comparable<T>> implements BinarySearchTree<T> {

	private class TestNode extends Node<T> {

		private TestNode left, right;

		public TestNode(final T value) {
			super(value);

			left = null;
			right = null;
		}

		public TestNode getLeft() {
			return left;
		}

		public TestNode getRight() {
			return right;
		}

		public boolean hasLeft() {
			return left != null;
		}

		public boolean hasRight() {
			return right != null;
		}

		public void setLeft(final TestNode left) {
			this.left = left;
		}

		public void setRight(final TestNode right) {
			this.right = right;
		}

	}

	private TestNode root;

	public TestTree() {
		makeEmpty();
	}

	@Override
	public boolean contains(final T value) {
		return find(value, root) != null;
	}

	@Override
	public T findMax() {
		return findMax(root).getValue();
	}

	@Override
	public T findMin() {
		return findMin(root).getValue();
	}

	@Override
	public void insert(final T value) {
		root = insert(value, root);
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void makeEmpty() {
		root = null;
	}

	@Override
	public void printTree() {
		visit(root);
	}

	@Override
	public void remove(final T value) {
		TestNode node = root;
		TestNode parent = null;
		boolean leftChild = false;
		while (node != null) {
			final int compare = node.getValue().compareTo(value);
			if (compare > 0) {
				parent = node;
				node = node.getLeft();
				leftChild = true;
			} else if (compare < 0) {
				parent = node;
				node = node.getRight();
				leftChild = false;
			} else
				break;
		}

		if (node == null)
			return;

		TestNode subtree = node.getRight();
		if (subtree == null)
			subtree = node.getLeft();
		else
			findMin(subtree).setLeft(node.getLeft());

		if (parent == null)
			root = subtree;
		else if (leftChild)
			parent.setLeft(subtree);
		else
			parent.setRight(subtree);
	}

	private TestNode find(final T value, @SuppressWarnings("hiding") final TestNode root) {
		TestNode node = root;

		while (node != null) {
			final int compare = node.getValue().compareTo(value);
			if (compare > 0)
				node = node.getLeft();
			else if (compare < 0)
				node = node.getRight();
			else
				return node;
		}

		return null;
	}

	@SuppressWarnings("static-method")
	private TestNode findMax(@SuppressWarnings("hiding") final TestNode root) {
		assert root != null;
		TestNode node = root;
		while (node.hasRight())
			node = node.getRight();
		return node;
	}

	@SuppressWarnings("static-method")
	private TestNode findMin(@SuppressWarnings("hiding") final TestNode root) {
		assert root != null;
		TestNode node = root;
		while (node.hasLeft())
			node = node.getLeft();
		return node;
	}

	private TestNode insert(final T value, @SuppressWarnings("hiding") final TestNode root) {
		if (root == null)
			return new TestNode(value);

		final int compare = root.getValue().compareTo(value);

		if (compare > 0)
			root.setLeft(insert(value, root.getLeft()));
		else if (compare < 0)
			root.setRight(insert(value, root.getRight()));

		return root;
	}

	private void visit(@SuppressWarnings("hiding") final TestNode root) {
		if (root == null)
			return;

		visit(root.getLeft());
		System.out.println(root.getValue());
		visit(root.getRight());
	}

}
