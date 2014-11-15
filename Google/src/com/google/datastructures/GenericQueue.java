package com.google.datastructures;

public class GenericQueue<T> {

	private static final int INITIAL_CAPACITY = 16;

	private Object[] data;
	private int capacity;
	private int front, length;

	public GenericQueue() {
		capacity = INITIAL_CAPACITY;
		data = new Object[capacity];
		front = length = 0;
	}

	public static void main(final String... args) {
		final GenericQueue<String> queue = new GenericQueue<>();
		queue.enqueue("10");
		queue.dequeue();
		queue.enqueue("20");
		queue.enqueue("30");
		queue.dequeue();
		if (!queue.dequeue().equals("30"))
			System.out.println("OOPS");
		for (int i = 0; i < 100; ++i)
			queue.enqueue(Integer.toString(i));
		for (int i = 0; i < 100; ++i)
			if (queue.isEmpty() || !queue.dequeue().equals(Integer.toString(i)))
				System.out.println("OOPS " + i);
		System.out.println(queue.isEmpty());
	}

	public void clear() {
		capacity = INITIAL_CAPACITY;
		data = new Object[capacity];
		front = length = 0;
	}

	public T dequeue() {
		if (length == 0)
			return null;

		@SuppressWarnings("unchecked")
		final T value = (T) data[front];
		data[front] = null;

		++front;
		if (front == capacity)
			front = 0;

		--length;

		if (length < capacity / 4)
			resizeData(capacity / 2);

		return value;
	}

	public void enqueue(final T value) {
		data[(front + length) % capacity] = value;

		++length;
		if (length == capacity)
			resizeData(2 * capacity);
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public T peek() {
		if (length == 0)
			return null;

		@SuppressWarnings("unchecked")
		final T value = (T) data[front];
		return value;
	}

	private void resizeData(final int newCapacity) {
		if (newCapacity < INITIAL_CAPACITY)
			return;

		final Object[] newData = new Object[newCapacity];
		for (int i = 0; i < length; ++i)
			newData[i] = data[(front + i) % capacity];
		front = 0;
		data = newData;
		capacity = newCapacity;
	}

}
