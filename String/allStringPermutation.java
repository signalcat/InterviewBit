package com.codepath;
import java.util.*;

public class allStringPermutation {
	public static void main(String args[]) {
		permutate("abc");
	}
	
	public static void permutate(String str) {
		  permutation("", str);
		}
		  
	private static void permutation(String chosen, String s) {
		StringBuffer chosenBuf = new StringBuffer(chosen);
		// base case: if we choose nothing we print
		if (s.length() == 0) {
			System.out.println(chosenBuf.toString());
		} else {
		  // recursive case: 
		  // 1 choose a char
		  // 2 explore the rest
		  // 3 un-choose
			for (int i = 0; i < s.length(); i++) {
				// choose
				char c = s.charAt(i);
				// add to the accumulator
				chosenBuf.append(c);
				// delete the char
				s = s.substring(0, i) + s.substring(i+1,s.length());
				// explore
				permutation(chosenBuf.toString(), s);
				// un-choose
				s = c + s;
				chosenBuf.deleteCharAt(chosenBuf.length()-1);
			}
		}
	}
}
