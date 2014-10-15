package com.google.tree.bst;

public class TestBST {

	public static void testBST(final BinarySearchTree<Integer> bst) {
		final int length = 100000;
		final int[] data = randomData(length);
		final int max = 2 * length;

		data[0] = length;

		for (int i = 0; i < length; ++i)
			bst.insert(2 * data[i] + 1);

		bst.remove(2 * data[0] + 1);

		for (int i = 0; i < max; ++i) {
			final boolean should = i % 2 == 1;
			if (bst.contains(i) != should)
				System.out.println("Problem on " + i);
		}
		System.out.println(bst.findMin());
		System.out.println(bst.findMax());

		System.out.println("Done");
	}

	public static void testPrint(final BinarySearchTree<Integer> bst) {
		final int length = 30;
		final int[] data = randomData(length);
		for (int i = 0; i < length; ++i)
			bst.insert(data[i]);

		bst.printTree();
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
