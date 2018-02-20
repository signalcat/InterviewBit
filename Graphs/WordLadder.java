import java.util.*;

public class WordLadder {	
	static class ListNode {
		String wordStr;
		int curDepth;
		ListNode(String word, int depth) {
			wordStr = word;
			curDepth = depth;
		}
	}
	public static int ladderLength(String start, String end, ArrayList<String> dictV) {
	    dictV.add(end);
	    HashSet<String> visited = new HashSet<String>();
	    Queue<ListNode> queue = new LinkedList<>();
	    ListNode startNode = new ListNode(start, 1);
	    queue.add(startNode);
	    while (!queue.isEmpty()) {
	    	ListNode curNode = queue.poll();
	    	if (curNode.wordStr.equals(end)) {
	    		return curNode.curDepth;
	    	}
	    	for (String s : dictV) {
	    		if (letterDiff(curNode.wordStr, s) == 1) {
	    			if (visited.contains(s)) {
	    				continue;
	    			} else {
	    				visited.add(s);
	    				ListNode child = new ListNode(s, curNode.curDepth + 1);
		    			queue.add(child);
	    			}
	    			
	    		}
	    	}
	    }
	    return 0;
	}
	
	public static int letterDiff(String a, String b) {
		char[] c1 = a.toCharArray();
		char[] c2 = b.toCharArray();
		int count = 0;
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != c2[i]) {
				count++;
			}
		}
		return count;
	}
	
	
//	public static int ladderLength(String start, String end, ArrayList<String> dictV) {
//	    // Dump the arrayList to a hash set
//	    HashSet<String> dicSet = new HashSet<String>();
//	    for (String s : dictV) {
//	    	dicSet.add(s);
//	    }
//	    // Create a set to store unique combinations
//	    HashSet<String> visited = new HashSet<String>();
//	    return helper(start, end, visited, dicSet);
//	}
//	
//	public static int helper(String start, String end, HashSet<String> visited, HashSet<String> dicSet) {
//	    // Change each char in the string
//	    // Compare the current string with the word in the dict
//		//int sum = 0;
//	    char[] curChar = start.toCharArray();
//		for (int i = 0; i < curChar.length; i++) {
//			for (char c = 'a'; c <= 'z'; c++) {
//				if (curChar[i] == c) {
//					continue;
//				}
//				curChar[i] = c;
//				String curString = new String(curChar);
//				// Check if it's the same as end string, then we are done
//				if (curString.equals(end)) {
//					return 1;
//				}
//				if (!dicSet.contains(curString) || visited.contains(curString)) {
//					// We have stored this before
//					// need to have a new word
//					continue;
//				} else {			
//					// Mark as visited 
//					System.out.println(curString);
//					visited.add(curString);
//						// Recursively call the function to start checking using this new start string
//						int retVal = helper(curString, end, visited, dicSet);
//						if (retVal != -1)
//							return 1 + retVal;
//				}
//			}
//			curChar = start.toCharArray();
//		}
//		return -1;
//	}
	
	public static void main (String[] args) {
		ArrayList<String> dictV = new ArrayList<String>();
		System.out.print(ladderLength("bb", "ab", dictV));
	}
}
