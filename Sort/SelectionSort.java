package com.codepath;

import java.util.Arrays;

public class SelectionSort {
	public int[] selectionSort(int[] array) {
		// Check null and empty array
		if (array == null || array.length <= 1) {
			return array;
		}
		
		// Iterate through the array
		// Be careful with the boundary 
		for (int i = 0; i < array.length - 1; i++) {
			// Every iteration we assume the first element is the min
			int min = i;
			// find the min element in the subarray of (i, array.length - 1)
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			// swap with the current value
			swap(array, i, min);
		}
		return array;
	}
	
	public void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public static void main(String[] args) {
		
		SelectionSort solution = new SelectionSort();
		
		int[] array = null;
		array = solution.selectionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {4,3,2,1};
		array = solution.selectionSort(array);
		System.out.println(Arrays.toString(array));
	}
}
