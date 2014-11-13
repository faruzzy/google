package com.google.stack;

public interface Stack<T> {

	public int getSize();

	public boolean isEmpty();

	public T peek();

	public T pop();

	public void push(T value);

}
