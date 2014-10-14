package com.google.classicsort;

public class Driver {

	public static void main(final String... args) {
		if (TestSortingAlgorithm.test(new QuickSort()))
			if (TestSortingAlgorithm.test(new MergeSort()))
				if (TestSortingAlgorithm.test(new HeapSort()))
					System.out.println("All Done!");
	}

}
