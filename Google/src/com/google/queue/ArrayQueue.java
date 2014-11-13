package com.google.queue;

import java.util.Arrays;

public class ArrayQueue {

	private static final int MIN_CAPACITY = 16;

	private int[] data;
	private int front, back;

	public ArrayQueue() {
		data = new int[MIN_CAPACITY];
		front = 0;
		back = 0;
	}

	public int dequeue() {
		final int value = data[front];
		data[front] = 0;
		front++;
		if (back - front < data.length / 4)
			resizeData(data.length / 2);
		return value;
	}

	public void enqueue(final int value) {
		data[back] = value;
		back++;
		if (back == data.length)
			resizeData(data.length * 2);
	}

	public int getSize() {
		return back - front;
	}

	public boolean isEmpty() {
		return front == back;
	}

	private void resizeData(final int newCapacity) {
		if (newCapacity < MIN_CAPACITY)
			return;
		System.out.println(Arrays.toString(data));
		final int[] newData = new int[newCapacity];
		for (int i = 0; i < back - front; ++i)
			newData[i] = data[front + i];
		data = newData;
		System.out.println(Arrays.toString(data));
		System.out.println("**");
		back -= front;
		front = 0;
	}

}
