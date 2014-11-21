package com.google.binarytree;

public class RedBlackNode<Key extends Comparable<Key>, Value> implements Comparable<Key> {

	private final Key key;
	private Value value;
	private boolean red;
	private RedBlackNode<Key, Value> left, right;

	public RedBlackNode(final Key key, final Value value) {
		this.key = key;
		this.value = value;
		red = true;
		left = right = null;
	}

	@Override
	public int compareTo(final Key otherKey) {
		return key.compareTo(otherKey);
	}

	public Key getKey() {
		return key;
	}

	public RedBlackNode<Key, Value> getLeft() {
		return left;
	}

	public RedBlackNode<Key, Value> getRight() {
		return right;
	}

	public Value getValue() {
		return value;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public boolean isLeftBlack() {
		return left == null ? true : !left.red;
	}

	public boolean isLeftRed() {
		return left == null ? false : left.red;
	}

	public boolean isRed() {
		return red;
	}

	public boolean isRightBlack() {
		return right == null ? true : !right.red;
	}

	public boolean isRightRed() {
		return right == null ? false : right.red;
	}

	public void setLeft(final RedBlackNode<Key, Value> left) {
		this.left = left;
	}

	public void setRed(final boolean red) {
		this.red = red;
	}

	public void setRight(final RedBlackNode<Key, Value> right) {
		this.right = right;
	}

	public void setValue(final Value value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value == null ? "null" : value.toString();
	}

}
