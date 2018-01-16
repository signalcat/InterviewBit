package com.laioffer.classone;
import java.util.ArrayList;

public class longestCommonPrefix {
	public static void main (String args[]) {
		longestCommonPrefix sll = new longestCommonPrefix();
		sll.run();
	}
	public void run() {
		ArrayList<String> A = new ArrayList<String>();
		A.add("a");
		A.add("");
		String result = getPrefix(A);
		System.out.println(result);
	}
	
	public String getPrefix(ArrayList<String> A) {
		String result = "";
		if (A.isEmpty() || A.size() == 1) {
			return result;
		}
		
		int min = findMinLength(A);
		for (int j = 0; j < min; j++) {
			for (int i = 1; i < A.size(); i++) {
				if (A.get(i).charAt(j) != A.get(i-1).charAt(j)) {
					return result;
				}
				result += A.get(i).charAt(j);
			}
		}
	
		return result;
	}
	
	public int findMinLength(ArrayList<String> A) {
		int min = A.get(0).length();
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i).length() < min) {
				min = A.get(i).length();
			}
		}
		return min;
	}
}
