package com.google.queue;

public class ArrayQueue<T> implements Queue<T> {

	private static final int MIN_CAPACITY = 16;

	private Object[] data;
	private int front, back;

	public ArrayQueue() {
		data = new Object[MIN_CAPACITY];
		front = 0;
		back = 0;
	}

	@Override
	public T dequeue() {
		@SuppressWarnings("unchecked")
		final T value = (T) data[front];
		data[front] = null;
		front++;
		if (back - front < data.length / 4)
			resizeData(data.length / 2);
		return value;
	}

	@Override
	public void enqueue(final T value) {
		data[back] = value;
		back++;
		if (back == data.length)
			resizeData(data.length * 2);
	}

	@Override
	public int getSize() {
		return back - front;
	}

	@Override
	public boolean isEmpty() {
		return front == back;
	}

	private void resizeData(final int newCapacity) {
		if (newCapacity < MIN_CAPACITY)
			return;
		final Object[] newData = new Object[newCapacity];
		for (int i = 0; i < back - front; ++i)
			newData[i] = data[front + i];
		data = newData;
		back -= front;
		front = 0;
	}

}
