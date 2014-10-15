package com.google.tree.bst;

public class AVLTree<T extends Comparable<T>> implements BinarySearchTree<T> {

	private AVLNode root;

	private class AVLNode extends Node<T> {

		private AVLNode left, right;
		private int visits;

		public AVLNode(final T value) {
			super(value);

			left = null;
			right = null;

			visits = -1;
		}

		public AVLNode getLeft() {
			return left;
		}

		public AVLNode getRight() {
			return right;
		}

		public boolean hasLeft() {
			return left != null;
		}

		public boolean hasRight() {
			return right != null;
		}

		public void setLeft(final AVLNode left) {
			this.left = left;
		}

		public void setRight(final AVLNode right) {
			this.right = right;
		}

		public int visit() {
			return visits = (visits + 1) % 3 + 1;
		}

	}

	public AVLTree() {
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
		AVLNode node = root;
		AVLNode parent = null;
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

		AVLNode subtree = node.getRight();
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

	private AVLNode find(final T value, @SuppressWarnings("hiding") final AVLNode root) {
		AVLNode node = root;

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
	private AVLNode findMax(@SuppressWarnings("hiding") final AVLNode root) {
		assert root != null;
		AVLNode node = root;
		while (node.hasRight())
			node = node.getRight();
		return node;
	}

	@SuppressWarnings("static-method")
	private AVLNode findMin(@SuppressWarnings("hiding") final AVLNode root) {
		assert root != null;
		AVLNode node = root;
		while (node.hasLeft())
			node = node.getLeft();
		return node;
	}

	private AVLNode insert(final T value, @SuppressWarnings("hiding") final AVLNode root) {
		if (root == null)
			return new AVLNode(value);

		final int compare = root.getValue().compareTo(value);

		if (compare > 0)
			root.setLeft(insert(value, root.getLeft()));
		else if (compare < 0)
			root.setRight(insert(value, root.getRight()));

		return root;
	}

	private void visit(@SuppressWarnings("hiding") final AVLNode root) {
		if (root == null)
			return;

		visit(root.getLeft());
		System.out.println(root.getValue());
		visit(root.getRight());
	}

}
