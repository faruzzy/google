package com.google.graph;

public class TestGraph {

	public static void test(final Graph<String> graph) {
		final int n = 6;
		for (int i = 0; i < n; ++i)
			graph.addNode(numToLetter(i));

		final int m = n + 2;
		for (int x = 0; x < m; ++x) {
			final int i = rand(n, n);
			final int j = rand(n - 1, i);
			System.out.println(i + ", " + j);
			graph.addEdge(i, j);
		}

		final DFS<String> dfs = new DFS<String>(graph) {
			@Override
			public boolean process(final String search, final String value) {
				System.out.println(value);
				return false;
			}
		};
		
		dfs.search("a");
		
		System.out.println("***");
		
		final BFS<String> bfs = new BFS<String>(graph) {
			@Override
			public boolean process(final String search, final String value) {
				System.out.println(value);
				return false;
			}
		};
		
		bfs.search("a");
	}

	public static void testQueue() {
		final Queue queue = new Queue();

		final int size = 30;
		for (int i = 0; i < size; ++i) {
			queue.enqueue(i);
			if (Math.random() < 0.25)
				System.out.println(queue.dequeue());
		}

		System.out.println("***");

		while (!queue.isEmpty())
			System.out.println(queue.dequeue());
	}

	private static String numToLetter(final int i) {
		return new String(new char[] { (char) ('a' + i) });
	}

	private static int rand(final int max, final int not) {
		final int r = (int) (Math.random() * max); // [0, max - 1]

		if (r < not)
			return r;
		return r + 1;
	}

}
