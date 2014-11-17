package com.google.binarytree;

public class RedBlackNode<Key extends Comparable<Key>, Value> extends BinaryNode<Key, Value> {

	private boolean red;

	public RedBlackNode(final Key key, final Value value) {
		super(key, value);
		red = true;
	}

	public boolean isRed() {
		return red;
	}

	public void setRed(final boolean red) {
		this.red = red;
	}

}
