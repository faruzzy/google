package com.google.datastructures;

public class GenericStack<T> {

	private static final int INITIAL_CAPACITY = 16;

	private T[] data;
	private int top;

	public GenericStack() {
		@SuppressWarnings("unchecked")
		final T[] newData = (T[]) new Object[INITIAL_CAPACITY];
		this.data = newData;
		top = -1;
	}

	public static void main(final String... args) {
		final GenericStack<String> genericStack = new GenericStack<>();

		for (int i = 0; i < 300; ++i)
			genericStack.push(Integer.toString(i));
		for (int i = 299; i > -1; --i)
			if (genericStack.isEmpty() || !genericStack.pop().equals(Integer.toString(i)))
				System.out.println("OOPS " + i);
		System.out.println(genericStack.isEmpty());

		genericStack.push("Hello");
		genericStack.push("World");
		genericStack.push("Yeah");

		while (!genericStack.isEmpty())
			System.out.println(genericStack.pop());
	}

	public void clear() {
		@SuppressWarnings("unchecked")
		final T[] newData = (T[]) new Object[INITIAL_CAPACITY];
		data = newData;
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public T peek() {
		if (top == -1 || data[top] == null)
			return null;

		return data[top];
	}

	public T pop() {
		if (top == -1)
			return null;

		final T value = data[top];
		data[top] = null;

		if (top < data.length / 4)
			resizeData(data.length / 2);

		top--;

		return value;
	}

	public void push(final T value) {
		if (value == null)
			return;

		++top;
		if (top == data.length)
			resizeData(2 * data.length);
		data[top] = value;
	}

	private void resizeData(final int capactiy) {
		@SuppressWarnings("unchecked")
		final T[] newData = (T[]) new Object[capactiy];
		for (int i = 0; i < top; ++i)
			newData[i] = data[i];
		data = newData;
	}

}
