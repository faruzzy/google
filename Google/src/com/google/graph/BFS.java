package com.google.graph;

public abstract class BFS<T> extends GraphSearch<T> {

	private int state[];
	private Queue queue;

	public BFS(final Graph<T> graph) {
		super(graph);
		state = null;
		queue = null;
	}

	@Override
	public boolean search(final int start, final T search) {
		state = new int[graph.getN()];
		queue = new Queue();

		state[start] = 1;
		queue.enqueue(start);

		while (!queue.isEmpty()) {
			final int node = queue.dequeue();
			process(search, graph.getNode(node));
			for (final int child : graph.getChildren(node))
				if (state[child] == 0) {
					state[child] = 1;
					queue.enqueue(child);
				}
		}

		return false;
	}

}
