package com.google.stack;

public class TestStack {

	public static void main(final String... args) {
		System.out.println("testing stacks...");
		final boolean result = testPushingManyItems(createStack()) && testEmpty(createStack()) && testPushAndPop(createStack());
		System.out.println(result ? "all tests passed" : "test failed");

	}

	private static Stack<Integer> createStack() {
		return createStack(0);
	}

	private static <T> Stack<T> createStack(@SuppressWarnings("unused") final T t) {
		return new ArrayStack<>();
	}

	private static boolean testEmpty(final Stack<Integer> stack) {
		final boolean isEmpty = stack.isEmpty();
		if (!isEmpty)
			System.out.println("new stack being empty failed");
		return isEmpty;
	}

	private static boolean testPushAndPop(final Stack<Integer> stack) {
		for (int i = 0; i < 127; ++i)
			stack.push(i);
		if (stack.peek() != 126) {
			System.out.println("peek failed");
			return false;
		}
		if (stack.getSize() != 127) {
			System.out.println("size failed");
			return false;
		}
		stack.push(50);
		stack.push(100);
		stack.push(200);
		if (stack.pop() != 200) {
			System.out.println("stack failed to pop correctly");
			return false;
		}
		if (stack.pop() != 100) {
			System.out.println("stack failed to pop twice correctly");
			return false;
		}
		stack.push(500);
		if (stack.pop() != 500) {
			System.out.println("stack failed to pop and push correctly");
			return false;
		}

		return true;
	}

	private static boolean testPushingManyItems(final Stack<Integer> stack) {
		final int times = 678;
		for (int i = 0; i <= times; ++i)
			stack.push(i);
		for (int i = times; i > -1; --i)
			if (stack.isEmpty() || stack.pop() != i) {
				System.out.println("adding many items failed on removing " + i);
				return false;
			}
		return stack.isEmpty();
	}

}
