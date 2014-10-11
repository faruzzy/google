package com.google.mosquestion;

public class Driver {

	public static void main(final String... args) {
		final int width = 500;
		final int height = 750;
		final int[] data = randomData(width * height);
		final Node[][] nodes = new Node[height][width];
		for (int i = 0; i < height; ++i)
			for (int j = 0; j < width; ++j)
				nodes[i][j] = new Node(data[i * width + j]);

		MosQuestion mosQuestion = new MosQuestion(nodes);
		Node node = mosQuestion.findMaxPath();
		System.out.println(node);
	}

	private static int[] randomData(final int length) {
		final int[] data = new int[length];
		for (int i = 0; i < length; ++i) {
			final int r = (int) ((i + 1) * Math.random());
			data[i] = data[r];
			data[r] = i;
		}
		return data;
	}

}
