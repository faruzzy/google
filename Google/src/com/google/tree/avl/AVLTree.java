package com.google.tree.avl;

public class AVLTree {

	private AVLNode root;

	public AVLTree() {
		root = null;
	}
	
	public int getHeight() {
		if (root == null)
			return -1;
		return root.getHeight();
	}

	private static AVLNode insert(final AVLNode node, final int value) {
		if (node == null)
			return new AVLNode(value);

		final int compare = node.getValue() - value;

		if (compare < 0)
			node.setRight(insert(node.getRight(), value));
		else if (compare > 0)
			node.setLeft(insert(node.getLeft(), value));

		return node;
	}

	public void insert(final int value) {
		root = insert(root, value);
	}
	
	public void printTree() {
		Queue<AVLNode> queue = new Queue<>();
		
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			AVLNode node = queue.dequeue();
			queue.enqueue(node.getLeft());
			queue.enqueue(node.getRight());
		}
		
	}


}
