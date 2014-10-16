package com.google.tree.avl;

public class Queue<T> {

	private Object[] data;
	private int length;
	private int count;
	private int start, end;

	public Queue() {
		length = 16;
		data = new Object[length];
		count = 0;
		start = 0;
		end = 0;
	}

	@SuppressWarnings("unchecked")
	public T dequeue() {
		count--;
		final Object value = data[start];
		start = (start + 1) % length;
		if (value == null)
			return null;
		return (T) value;
	}

	public void enqueue(final T value) {
		if (value == null)
			return;
		
		if (count == length - 1)
			resizeQueue(2 * length);

		count++;
		data[end] = value;
		end = (end + 1) % length;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	private void resizeQueue(final int newLength) {
		final int oldLength = length;
		final Object[] oldData = data;
		data = new Object[newLength];

		for (int i = 0; i < count; ++i)
			data[i] = oldData[(i + start) % oldLength];

		length = newLength;
		start = 0;
		end = count;
	}

}
