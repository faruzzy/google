package com.google.datastructures;

public class Queue {

	private static final int INITIAL_CAPACITY = 16;

	private int[] data;
	private int front, back;

	public Queue() {
		data = new int[INITIAL_CAPACITY];
		front = back = 0;
	}

	public static void main(final String... args) {
		final Queue queue = new Queue();
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

	public int dequeue() {
		if (front == back)
			return -1;
		final int value = data[front];
		data[front] = 0;
		++front;
		if (back - front < data.length / 4)
			resizeData(data.length / 2);
		return value;
	}

	public void enqueue(final int value) {
		data[back] = value;
		++back;
		if (back == data.length)
			resizeData(2 * data.length);
	}

	public int getSize() {
		return back - front;
	}

	public boolean isEmpty() {
		return front == back;
	}

	public int peek() {
		return data[front];
	}

	private void resizeData(final int capacity) {
		if (capacity < INITIAL_CAPACITY)
			return;

		final int[] newData = new int[capacity];
		for (int i = front; i < back; ++i)
			newData[i - front] = data[i];
		back -= front;
		front = 0;
		data = newData;
	}

}
