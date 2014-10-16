package com.google.tree.avl;

public class AVLNode {

	private final int value;
	private AVLNode left, right;
	private int height;

	public AVLNode(final int value) {
		this.value = value;

		left = null;
		right = null;

		height = 0;
	}

	private static AVLNode checkBalance(final AVLNode root) {
		AVLNode node = root;

		final int l = node.leftHeight();
		final int r = node.rightHeight();

		if (l > r + 1) {
			final AVLNode left = node.left;

			final int ll = left.leftHeight();
			final int lr = left.rightHeight();
			if (ll > lr) {
				// case 1
				node.left = left.right;
				left.right = node;
				node.processHeight();
				node = left;
			} else if (ll < lr) {
				// case 2
				
			}
		}

		return node;
	}

	public int getHeight() {
		return height;
	}

	public AVLNode getLeft() {
		return left;
	}

	public AVLNode getRight() {
		return right;
	}

	public int getValue() {
		return value;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void setLeft(final AVLNode left) {
		this.left = checkBalance(left);
		processHeight();
	}

	public void setRight(final AVLNode right) {
		this.right = checkBalance(right);
		processHeight();
	}

	private int leftHeight() {
		return left == null ? -1 : left.height;
	}

	private void processHeight() {
		height = 1 + Math.max(leftHeight(), rightHeight());
	}

	private int rightHeight() {
		return right == null ? -1 : right.height;
	}

}
