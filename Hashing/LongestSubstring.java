//Given a string, find the length of the longest substring without repeating characters.
//Example:
//The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
//For "bbbbb" the longest substring is "b", with the length of 1.


// find the substring starting with the longest possible length
// if each char can be put in a hashset successfully, then this is a non repeating string
// return the length
// if there is a duplicate, continue to the next string
// go through the next possible length
// if the length decrease to 1, return 1

// example input "ab"
// length: 2
// substring: "ab" -> non-repeating
// return 2

// example input "aa"
// length 2
// substring: "aa" -> repeating
// length 1
// substring: a -> non- repeating
// return 1


// second approach:
// maintain a window with non repeating string with left pointer and right pointer
// define a boolean type of array for ascii (max 256)
// iterate the string using left and right pointers, and keep tracking of the maxLen
// check if the current char is in the array 
// if not, mark it as true, and update the maxLen to be the distance between two pointers + 1
// if yes, then mark false, and move the left pointer to the right



import java.util.*;
import java.util.HashSet;

public class LongestSubstring {
//	public static int find(String inputStr) {
//		int strLen = inputStr.length();
//		int len = strLen;
//		for (; len > 0; len--) {
//			for (int startIdx = 0; startIdx + len <= strLen; startIdx++) {
//				HashSet<Character> set = new HashSet<Character>();
//				int count = 0;
//				for (int j = startIdx; j < startIdx + len; j++) {
//					if (set.add(inputStr.charAt(j))) {
//						count++;
//					} else {
//						continue;
//					}
//				}
//				if (count == len) {
//					return count;
//				}
//			}
//		}
//		return len;
//	}
	
// aa
//  i
//  j

	public static int find(String s) {
		 //define a boolean type array to keep record of char. axcii range 256
        boolean[] exist = new boolean[256];
        //define one indice to record the head of current substring
        //define max length as 0
        int i = 0; int maxLen = 0;
        //iterate through the string
        for (int j = 0; j < s.length(); j++) {
          //check if the current char appeared before.if yes, set the bit as false and increase the head index by one.
            if (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
          //mark the first showing char as true
            exist[s.charAt(j)] = true;
          //update the maximum length by comparing distance between index of current char and the last time appeared index 
            maxLen = Math.max(j - i + 1, maxLen);
        }
        
        return maxLen;
	}
	
	public static void main(String[] args) {
		String input = "bbb";
		int result = find(input);
		System.out.println(result);
		return;
	}
}
