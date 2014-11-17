package com.google.binarytree;

public class BinaryNode<Key extends Comparable<Key>, Value> implements Comparable<Key> {

	private final Key key;
	private Value value;
	private BinaryNode<Key, Value> left, right;

	public BinaryNode(final Key key, final Value value) {
		this.key = key;
		this.value = value;
		left = right = null;
	}

	@Override
	public int compareTo(final Key otherKey) {
		return key.compareTo(otherKey);
	}

	public Key getKey() {
		return key;
	}

	public BinaryNode<Key, Value> getLeft() {
		return left;
	}

	public BinaryNode<Key, Value> getRight() {
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

	public void setLeft(final BinaryNode<Key, Value> left) {
		this.left = left;
	}

	public void setRight(final BinaryNode<Key, Value> right) {
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
