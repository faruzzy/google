package com.google.graph;

public class Queue {

	private int[] data;
	private int length;
	private int count;
	private int start, end;

	public Queue() {
		length = 16;
		data = new int[length];
		count = 0;
		start = 0;
		end = 0;
	}

	public int dequeue() {
		count--;
		final int value = data[start];
		start = (start + 1) % length;
		return value;
	}

	public void enqueue(final int value) {
		if (count == length - 1)
			resizeQueue(2 * length);

		count++;
		data[end] = value;
		end = (end + 1) % length;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int peek() {
		return data[start];
	}

	private void resizeQueue(final int newLength) {
		final int oldLength = length;
		final int[] oldData = data;
		data = new int[newLength];

		for (int i = 0; i < count; ++i)
			data[i] = oldData[(i + start) % oldLength];

		length = newLength;
		start = 0;
		end = count;
	}

}
