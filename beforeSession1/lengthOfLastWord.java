package com.laioffer.classone;
import java.util.ArrayList;

public class lengthOfLastWord {
	public static void main (String args[]) {
		lengthOfLastWord sll = new lengthOfLastWord();
		sll.run();
	}
	public void run() {
		String input = "Hello World ";
		int result = lengthOfLastWord(input);
		System.out.println(result);
	}
	
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        String x = A.trim();
        int n = x.length();
        int index = 0;
        int length = n;
        
        for (int i = 0; i < n; i++) {
        	char c = x.charAt(i);
        	if (c == ' ') {
        		index = i;
        	}
        }
        
        if (index != 0) {
        	length = n - 1 - index;
        }
        
        return length;
    }
}
