package com.google.tree.arraybst;

public class TestBST {

	public static void test() {
		final ArrayBST binarySearchTree = new ArrayBST();

		final int length = 10;
		final int[] data = randomData(length);
		for (int i = 0; i < length; ++i)
			binarySearchTree.insert(2 * data[i] + 1);

		System.out.println(binarySearchTree.contains(4));
		System.out.println(binarySearchTree.contains(5));

		System.out.println(binarySearchTree.getMax());
		System.out.println(binarySearchTree.getMin());

		System.out.println(binarySearchTree);
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
