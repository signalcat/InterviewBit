package com.codepath;

public class isPermutation {
	public static void main (String args[]) {
		boolean result;
		result = isPermutation("abb", "bca");
		return;
	}
	
	public static boolean isPermutation(String a, String b) {
		// Check length
		if (a.length() != b.length()) {
			return false;
		}
		// Iterate through a/b (to charArray)
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
		// Initialize an array as counter
		int[] count = new int[128];
		// Count how many times each char occurs
		for (char c:aArr) {
			count[c]++;
		}
		// Match a's counter with b
		for (char c:bArr) {
			// -1 if b has the same char
			// eventually if the count not 0 then it's different
			if(--count[c] < 0) {
				return false;
			}
		}
		return true;
	}
}
