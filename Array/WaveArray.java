package com.codepath;
import java.util.*;

public class WaveArray {
	public ArrayList<Integer> wave (ArrayList<Integer> array) {
		Collections.sort(array);
		arange(array);
		return array;
	}
	
//	public static void sort(ArrayList<Integer> array) {
//		for (int i = 1; i < array.size(); i++) {
//			for (int j = i; j > 0; j--) {
//				if (array.get(j - 1) > array.get(j)) {
//					swap(array, j - 1, j);
//				}
//			}
//		}
//		return;
//	}
	
	public static void arange(ArrayList<Integer> array) {
		for (int i = 0; i < array.size() - 1; i = i + 2) {
			swap(array, i, i + 1);
		}
		return;
	}
	
	public static void swap(ArrayList<Integer> array, int left, int right) {
		int temp = array.get(left);
		array.set(left, array.get(right)); 
		array.set(right, temp);
		return;
	}
	
	public static void main (String[] args) {
		WaveArray solution = new WaveArray ();
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		result = solution.wave(input);
		System.out.println(Arrays.toString(result.toArray()));
		return;
	}
}
