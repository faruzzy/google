package com.google.datastructures;

public class CircularQueue {

	private static final int INITIAL_CAPACITY = 16;

	private int[] data;
	private int capacity;
	private int front, length;

	public CircularQueue() {
		capacity = INITIAL_CAPACITY;
		data = new int[capacity];
		front = length = 0;
	}

	public static void main(final String... args) {
		final CircularQueue queue = new CircularQueue();
		queue.enqueue(10);
		queue.dequeue();
		queue.enqueue(20);
		queue.enqueue(30);
		queue.dequeue();
		if (queue.dequeue() != 30)
			System.out.println("OOPS");
		for (int i = 0; i < 100; ++i)
			queue.enqueue(i);
		for (int i = 0; i < 100; ++i)
			if (queue.isEmpty() || queue.dequeue() != i)
				System.out.println("OOPS " + i);
		System.out.println(queue.isEmpty());
	}

	public void clear() {
		capacity = INITIAL_CAPACITY;
		data = new int[capacity];
		front = length = 0;
	}

	public int dequeue() {
		if (length == 0)
			return -1;

		final int value = data[front];
		data[front] = 0;

		++front;
		if (front == capacity)
			front = 0;
		
		--length;
		
		if (length < capacity / 4)
			resizeData(capacity / 2);

		return value;
	}

	public void enqueue(final int value) {
		data[(front + length) % capacity] = value;

		++length;
		if (length == capacity)
			resizeData(2 * capacity);
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public int peek() {
		if (length == 0)
			return -1;

		return data[front];
	}

	private void resizeData(final int newCapacity) {
		if (newCapacity < INITIAL_CAPACITY)
			return;
		
		final int[] newData = new int[newCapacity];
		for (int i = 0; i < length; ++i)
			newData[i] = data[(front + i) % capacity];
		front = 0;
		data = newData;
		capacity = newCapacity;
	}

}
