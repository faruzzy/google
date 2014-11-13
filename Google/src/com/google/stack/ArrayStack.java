package com.google.stack;

public class ArrayStack<T> implements Stack<T> {

	private static final int INITIAL_CAPACITY = 16;

	private Object[] data;
	private int top;

	public ArrayStack() {
		data = new Object[INITIAL_CAPACITY];
		top = -1;
	}

	@Override
	public int getSize() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public T peek() {
		@SuppressWarnings("unchecked")
		final T value = (T) data[top];
		return value;
	}

	@Override
	public T pop() {
		@SuppressWarnings("unchecked")
		final T value = (T) data[top];
		if (top < data.length / 4)
			resizeData(data.length / 2);
		top--;
		return value;
	}

	@Override
	public void push(final T value) {
		top++;
		if (top == data.length)
			resizeData(data.length * 2);
		data[top] = value;
	}

	private void resizeData(final int capacity) {
		if (capacity < INITIAL_CAPACITY)
			return;

		final Object[] newData = new Object[capacity];
		for (int i = 0; i < top; ++i)
			newData[i] = data[i];

		data = newData;
	}

}
