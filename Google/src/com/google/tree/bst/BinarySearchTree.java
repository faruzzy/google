package com.google.tree.bst;

public interface BinarySearchTree<T extends Comparable<T>> {

	public boolean contains(T value);

	public T findMax();

	public T findMin();

	public void insert(T value);

	public boolean isEmpty();

	public void makeEmpty();

	public void printTree();

	public void remove(T value);

}
