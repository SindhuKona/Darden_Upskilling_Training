package com.priya;

import java.util.ArrayList;

public class Lamda4 {

	public static ArrayList<String> removedOdd(ArrayList<String> employeeList) {
		employeeList.removeIf((n) -> (n.length() % 2 != 0));
		return employeeList;
	}

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("abc");
		arr.add("abcd");
		arr.add("abcde");
		arr.add("abcdef");
		arr.add("abcdefg");

		ArrayList<String> arr1 = removedOdd(arr);
		for (String str : arr1) {
			System.out.println(str);
		}
	}
}
