package com.google.mosquestion;

public class MosQuestion {

	private final int width, height;
	private final Node[][] nodes;

	public MosQuestion(final Node[][] nodes) {
		this.nodes = nodes;
		height = nodes.length;
		width = nodes[0].length;
	}

	private static Node findMax(final Node... neighoburs) {
		Node maxNode = null;
		int maxLength = 0;
		for (final Node node : neighoburs) {
			if (node != null && node.getKnownLength() > maxLength) {
				maxNode = node;
				maxLength = node.getKnownLength();
			}
		}
		return maxNode;
	}

	public Node findMaxPath() {
		Node maxNode = nodes[0][0];

		for (int i = 0; i < height; ++i)
			for (int j = 0; j < width; ++j) {
				final Node node = explore(i, j, -1);
				if (node.getKnownLength() > maxNode.getKnownLength())
					maxNode = node;
			}

		return maxNode;
	}

	private Node explore(final int i, final int j, final int minName) {
		if (i < 0 || i >= height  || j < 0 || j >= width)
			return null;

		final Node node = nodes[i][j];
		final int name = node.getName();
		
		if (name < minName)
			return null;
		
		if (node.isExplored())
			return node;

		final Node[] neighbours = new Node[4];
		neighbours[0] = explore(i - 1, j, name);
		neighbours[1] = explore(i, j + 1, name);
		neighbours[2] = explore(i + 1, j, name);
		neighbours[3] = explore(i, j - 1, name);

		final Node maxNode = findMax(neighbours);

		if (maxNode == null) {
			node.addKnownLength(0);
			return node;
		}

		node.addKnownLength(maxNode.getKnownLength());
		node.appendKnownPath(maxNode.getKnownPath());

		return node;
	}

}
