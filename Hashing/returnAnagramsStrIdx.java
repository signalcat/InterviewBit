import java.util.*;
// Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.
//
// Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp' 
// Note: All inputs will be in lower-case. 
// Example :
//
// Input : cat dog god tca
// Output : [[1, 4], [2, 3]]
// cat and tca are anagrams which correspond to index 1 and 4. 
// dog and god are another set of anagrams which correspond to index 2 and 3.
// The indices are 1 based ( the first element has index 1 instead of index 0).
//***************************************************************************
// Iterate through the array list and generate N maps
// Add maps to a large map
// map: <i>
// keep adding map
// if the same map, add index to the value field. map: [i, i+1]
// if not, create a new pair

public class returnAnagramsStrIdx {
	public static ArrayList<ArrayList<Integer>> anagramIdx(final List<String> A) {
		
		HashMap<HashMap<Character, Integer>, ArrayList<Integer>> mapMap = new HashMap<HashMap<Character, Integer>, ArrayList<Integer>>(); 
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < A.size(); i++) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		    
			char[] charArr = A.get(i).toCharArray();
			for (char c:charArr) {
				if (map.containsKey(c)) {
					map.put(c, map.get(c)+1);
				}else{
					map.put(c, 1);
				}
			}
			
			ArrayList<Integer> indexList = new ArrayList<Integer>();
			
			if (mapMap.containsKey(map)) {
				indexList = mapMap.get(map);
			}
				indexList.add(i+1);
				mapMap.put(map, indexList);
		}
		
		for (ArrayList<Integer> value: mapMap.values()) {
			if (value.size() > 1) {
				result.add(value);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		List<String> A = new ArrayList<String>();
		A.add("cat");
		A.add("dog");
		A.add("god");
		A.add("tca");
		result = anagramIdx(A);
		System.out.println(result);
	}
}
