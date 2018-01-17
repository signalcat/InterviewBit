package com.codepath;

public class reverseSentence {
	public static void main (String args[]) {
		String result = reverse("I am good");
		System.out.println(result);
		return;
	}
	
	public static String reverse(String x) {
		// Reverse whole string
		x = reverseString(x);
		// Split around space
		String[] words = x.split(" ");
		StringBuffer buff = new StringBuffer();
		// Adding reversed single word to the sentence buffer
		for (int i = 0; i < words.length; i++) {
			// Adding back the white space
			buff.append(reverseString(words[i]) + " ");
		}
		return buff.toString();
	}
	
	public static String reverseString(String x) {
		StringBuffer buff = new StringBuffer();
		char[] str = x.toCharArray();
		for (int i = str.length - 1; i >= 0; i--)
		{
			buff.append(str[i]);
		}
		return buff.toString();
	}
}
