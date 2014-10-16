package com.google.tree.avl;

public class TestAVLTree {

	public static void testInserts() {
		final AVLTree tree = new AVLTree();
		int length = 30;
		int[] data = randomData(length);
		
		for (int value : data)
			tree.insert(value);
		
		System.out.println(tree.getHeight());
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
