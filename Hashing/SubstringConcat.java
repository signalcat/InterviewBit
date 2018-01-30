//You are given a string, S, and a list of words, L, that are all of the same length.
//Find all starting indices of substring(s) in S that is a concatenation of each word in 
//L exactly once and without any intervening characters.
//Example :
//S: "barfoothefoobarman"
//L: ["foo", "bar"]
//You should return the indices: [0,9].
//(order does not matter).
//******************************************************************************************
// Hash strings in L
// go through S by word length in L
// start with index i
// get a copy of hashmap
// if we encounter a substring in hashmap, count--
// 	if count == 0, delete entry
// 	check map size. if size == 0, means we find a substring is a cancat of every word
//  append the current index i
//  if this is not in hashmap, we move to the next substring
// end of string, increment i 

import java.util.*;
public class SubstringConcat {
	public static ArrayList<Integer> findSubstring(String A, final List<String> B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = B.get(0).length();
		for (int startIdx = 0; startIdx + len <= A.length(); startIdx++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (String s : B) {
				if (map.containsKey(s)) {
					map.put(s, map.get(s) + 1);
				} else {
					map.put(s, 1);
				}
			}
			for (int idx = startIdx; idx + len <= A.length(); idx += len) {
				String sub = A.substring(idx, idx + len);
				System.out.println(sub);
				if (map.containsKey(sub)) {
					map.put(sub, map.get(sub) - 1);
					if (map.get(sub) == 0) {
						map.remove(sub);
					}
				} else {
					break;
				}
			}
			if (map.size() == 0) {
				result.add(startIdx);
			}
		}
		return result;
	}
	
	public static void main (String[] args) {
		String A = "barfoothefoobarman";
		List<String> B = new ArrayList<String>();
		B.add("foo");
        B.add("bar");
        ArrayList<Integer> result = findSubstring(A, B);
        for (int a: result) {
        	System.out.println(a);
        }
        return;
	}
	
	
}
