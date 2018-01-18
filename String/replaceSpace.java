package com.codepath;

public class replaceSpace {
	public static void main (String args[]) {
		String input = "abc d";
		String result = replace(input,"20");
		System.out.println(result);
		return;
	}
	
	public static String replace(String x, String replace) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == ' ') {
				buffer.append(replace);
			} else {
				buffer.append(x.charAt(i));
			}
		}
		return buffer.toString();
	}
}
