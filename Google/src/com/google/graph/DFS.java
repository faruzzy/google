package com.google.graph;

public abstract class DFS<T> extends GraphSearch<T> {

	int[] state;

	public DFS(final Graph<T> graph) {
		super(graph);
		state = null;
	}

	@Override
	public boolean search(final int start, final T search) {
		state = new int[graph.getN()];
		return dfs(search, start);
	}

	private boolean dfs(final T search, final int i) {
		state[i] = 1;
		final int[] childrean = graph.getChildren(i);
		for (final int child : childrean)
			if (state[child] == 0) {
				if (dfs(search, child))
					return true;
				state[child] = 2;
			}
		return process(search, graph.getNode(i));
	}

}
