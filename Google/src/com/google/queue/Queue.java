package com.google.queue;

public interface Queue<T> {

	public T dequeue();

	public void enqueue(T value);

	public int getSize();

	public boolean isEmpty();

}
