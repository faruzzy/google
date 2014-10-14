package com.google.sortstring;

public class TestSortString {

	public static void test() {
		String order = "jkmiphsxwtqygvrzu lfbedonca";
		System.out.println(order);
		SortString sortString = new SortString(order);
		String string = "hello world this is a big test for you";
		System.out.println(string);
		String sorted = sortString.sort(string);
		System.out.println(sorted);
	}

}
