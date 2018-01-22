package com.codepath;

public class atoi {
	public static int myAtoi(final String A) {
		if (A.isEmpty()) {
			return 0;
		}
		
		A.trim();
		
		int i = 0;
		int sign = 0;
		if (A.charAt(i) == '-') {
			sign = 1;
			i++;
		} else if (A.charAt(i) == '+') {
			i++;
		}
		
		double result = 0;
		while (i < A.length() && A.charAt(i) >= '0' && A.charAt(i) <= '9') {
			result = result * 10 + A.charAt(i) - '0';
			i++;
		}
		
		if (sign == 1) {
			result = -result;
		}
		
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		
		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		return (int) result;
	}
	
	public static void main(String[] args) {
		String A = "";
		int result = myAtoi(A);
		System.out.println(result);
		
		A = "a";
		result = myAtoi(A);
		System.out.println(result);
		
		A = "+a";
		result = myAtoi(A);
		System.out.println(result);
		
		A = "9 2704 01885D 9M 65291S844404U7463";
		result = myAtoi(A);
		System.out.println(result);
		
		A = "a-1";
		result = myAtoi(A);
		System.out.println(result);
		
		return;
	}
}
