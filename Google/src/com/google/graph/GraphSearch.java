package com.google.graph;

public abstract class GraphSearch<T> {

	protected final Graph<T> graph;

	public GraphSearch(final Graph<T> graph) {
		this.graph = graph;
	}

	public abstract boolean process(T search, T value);

	public abstract boolean search(int start, T search);

	public boolean search(final T search) {
		return search(0, search);
	}

}
