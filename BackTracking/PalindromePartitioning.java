//Given a string s, partition s such that every string of the partition is a palindrome.
//Return all possible palindrome partitioning of s.
//For example, given s = "aab",
//Return
//  [
//    ["a","a","b"]
//    ["aa","b"],
//  ]
// Ordering the results in the answer : Entry i will come before Entry j if :
//len(Entryi[0]) < len(Entryj[0]) OR
//(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
//(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
//In the given example,
//["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")

// [a]  @  [b]    ->   [a,b]
// [a,b] @  [c,d]  ->   [a,c],[a,d],[b,c],[b,d]
// ([a,b] @ [c,d]) @ [e,f] -> ([a,c],[a,d],[b,c],[b,d]) @ [e,f]
import java.util.*;
public class PalindromePartitioning {
	static HashMap<Character, String> map = new HashMap<Character, String>();
	public static ArrayList<String> helper(String input, int startIdx) {
		// base case
		if (startIdx == input.length()) {
			ArrayList<String> subRes = new ArrayList<String>();
			subRes.add("");
			return subRes;
		}
		// Get the current letter combo for the number
		String curLetters = map.get(input.charAt(startIdx));
		System.out.println("curLetters:" + curLetters);
	    // Get the next letter combo list
		ArrayList<String> subComb = helper(input, startIdx + 1);
		// Combine the current letter and the next letter combo list
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < curLetters.length(); i++) {
			for (String str : subComb) {
				String strComb = Character.toString(curLetters.charAt(i)) + str;
				System.out.println(strComb);
				res.add(strComb);
			}
		}
		return res;
	}
	public static ArrayList<String> letterCombinations(String input) {
		if (input.length() == 0) {
			return new ArrayList<String>(); 
		}
		return helper(input, 0);
	}
	
	public static void main(String[] args) {
		map.put('0',"0");
		map.put('1', "1");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		String input = "23";
		ArrayList<String> output = new ArrayList<String>();
		output = letterCombinations(input);
		System.out.print(Arrays.toString(output.toArray()));
	}
}
