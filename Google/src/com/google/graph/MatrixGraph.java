package com.google.graph;

import java.util.Arrays;

public class MatrixGraph implements Graph<String> {

	private String[] nodes;
	private int[][] data;
	private final boolean directed;
	private int n, m;

	public MatrixGraph() {
		this(true);
	}

	public MatrixGraph(final boolean directed) {
		final int size = 16;
		data = new int[size][size];
		nodes = new String[size];
		this.directed = directed;

		n = 0;
		m = 0;
	}

	@Override
	public void addEdge(final int i, final int j) {
		if (i != j && data[i][j] == 0) {
			m++;
			data[i][j] = 1;
			if (directed)
				data[j][i] = 1;
		}
	}

	@Override
	public int addNode(final String node) {
		if (n == data.length)
			resizeData(2 * n);

		nodes[n] = node;

		return n++;
	}

	@Override
	public boolean edgeExists(final int i, final int j) {
		return i == j || data[i][j] == 1;
	}

	@Override
	public int[] getChildren(final int i) {
		final int[] childrean = new int[n];
		int degree = 0;
		for (int j = 0; j < data[i].length; ++j)
			if (i != j && data[i][j] == 1)
				childrean[degree++] = j;
		return Arrays.copyOf(childrean, degree);
	}

	@Override
	public int getM() {
		return m;
	}

	@Override
	public int getN() {
		return n;
	}

	@Override
	public String getNode(final int i) {
		return nodes[i];
	}

	@Override
	public boolean isDirected() {
		return directed;
	}

	@Override
	public void removeEdge(final int i, final int j) {
		if (data[i][j] == 1) {
			m--;
			data[i][j] = 0;
			if (directed)
				data[j][i] = 0;
		}
	}

	@Override
	public void removeNode(final int i) {

	}

	private void resizeData(final int size) {
		final int[][] oldData = data;
		data = new int[size][size];
		nodes = Arrays.copyOf(nodes, size);
		for (int i = 0; i < oldData.length; ++i)
			for (int j = 0; j < oldData[i].length; ++j)
				data[i][j] = oldData[i][j];
	}

}
