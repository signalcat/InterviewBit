package com.codepath;

import java.util.Arrays;

public class MergeSort {
	 
	 public static void main(String[] args) {
		 int[] array = {4,3,2,1};
		 MergeSort solution = new MergeSort();
		 array = solution.mergeSort(array);
		 System.out.println(Arrays.toString(array));
	 }
	
	 public int[] mergeSort(int[] array) {
		 if (array == null) return array;
		 int[] tempArr = new int[array.length];
		 mergeSort(array, tempArr, 0, array.length - 1);
		 return array;
	 }
	 
	 private void mergeSort(int[] array, int[]tempArr, int left, int right) {
		 if (left >= right) return;
		 int mid = left + (right - left)/2;
		 mergeSort(array, tempArr, left, mid);
		 mergeSort(array, tempArr, mid + 1, right);
		 merge(array, tempArr, left, mid, right);
	 }
	 
	 private void merge(int[] array, int[] tempArr, int left, int mid, int right) {
		 for (int i = left; i <= right; i++) {
			 tempArr[i] = array[i];
		 }
		 int leftIndex = left;
		 int rightIndex = mid + 1;
		 while (leftIndex <= mid && rightIndex <= right) {
			 if(tempArr[leftIndex] <= tempArr[rightIndex]) {
				 array[left++] = tempArr[leftIndex++];
			 }else{
				 array[left++] = tempArr[rightIndex++];
			 }
		 }
		 while (leftIndex <= mid) {
			 array[left++] = tempArr[leftIndex++];
		 }
	 }
	   
}
