package com.codepath;
public class StrStr {
	public static int strStr(String A, String B) {
		if (B == null || B.length() == 0 || B.length() < A.length()) {
			return -1;
		}
		for (int i = 0; i + A.length() <= B.length(); i++) {
			if (B.substring(i, i+A.length()).equals(A)) {
				return i;
			}
		}
		return -1; 
	}
	
	public static void main (String[] args) {
		String A = "a";
		String B = "ab";
		int result = strStr(A,B);
		System.out.print(result);
	}
}
