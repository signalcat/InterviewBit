package com.codepath;

public class insertionSort {
	public static void main (String args[]) {
		int[] items = {3,2,1};
		int[] result = sort(items);
		for(int a:result) {
			System.out.print(a);
		}
			
		return;
	}
	
	public static int[] sort(int[] items) {
		// compare the second element with the first one
		// if it's smaller: insert it before the first element
		// if it's larger: do nothing and move to the third element
		// until reach the end of the array
		int temp;
		for (int i = 1; i < items.length; i++) {
			for (int j = i; j > 0; j--) {
				if (items[j] < items[j-1]) {
					temp = items[j];
					items[j] = items[j-1];
					items[j-1] = temp;
				}
			}
		}
		return items;
	}
	
}
