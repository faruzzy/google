package com.google.datastructures;

public class Stack {

	private final int INITIAL_CAPACITY = 16;

	private int data[];
	private int top;

	public Stack() {
		data = new int[INITIAL_CAPACITY];
		top = -1;
	}

	public int getSize() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int peek() {
		if (top == -1)
			return -1;

		return data[top];
	}

	public int pop() {
		if (top == -1)
			return -1;

		final int value = data[top];
		data[top] = 0;
		if (top < data.length / 4)
			resizeData(data.length / 2);
		top--;
		return value;
	}

	public void push(final int value) {
		++top;
		if (top == data.length)
			resizeData(2 * data.length);
		data[top] = value;
	}

	private void resizeData(final int capacity) {
		final int[] newData = new int[capacity];
		for (int i = 0; i < top; ++i)
			newData[i] = data[i];
		data = newData;
	}
	
	public static void main(String... args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(40);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		
		for (int i = 0; i < 1000; ++i)
			stack.push(i);
		for (int i = 999; i > -1; --i)
			if (stack.isEmpty() || stack.pop() != i)
				System.out.println("OOPS " + i);
		
		System.out.println(stack.isEmpty());
	}

}
