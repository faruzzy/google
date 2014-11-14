package com.google.queue;

public class TestQueue {

	public static void main(final String... args) {
		System.out.println("testing queue...");
		final boolean result = testLotsEnqueues(createQueue());
		System.out.println(result ? "all tests passed" : "test failed");
	}

	private static Queue<Integer> createQueue() {
		return new ArrayQueue<>();
	}

	private static boolean testLotsEnqueues(final Queue<Integer> queue) {
		final int times = 888;
		for (int i = 0; i < times; ++i)
			queue.enqueue(i);
		for (int i = 0; i < times; ++i)
			if (queue.dequeue() != i) {
				System.out.println("queue failed to dequeue on " + i);
				return false;
			}
		return queue.isEmpty();
	}

}
