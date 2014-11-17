package com.google.binarytree;

public interface BinaryTree<Key extends Comparable<Key>, Value> {

	public void delete(final Key key);

	public Value get(final Key key);

	public void put(final Key key, final Value value);

}
