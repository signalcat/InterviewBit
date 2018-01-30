//Given an array of integers, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, 
// where index1 < index2. 
//Please note that your returned answers (both index1 and index2 ) are not zero-based. 
//Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). 
//Note that, if no pair exists, return empty list.
//If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

import java.util.*;
public class twoSum {
	 // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> twosum(final List<Integer> A, int B) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
  	    ArrayList<Integer> result = new ArrayList<Integer>();
  	    
  	    for (int i = 0; i < A.size(); i++){
  	        int cur = A.get(i);
  	        if (map.containsKey(B-cur)){
  	            int index = map.get(B-cur);
  	            result.add(index);
  	            result.add(i + 1);
  	            return result;
  	        }else if (!map.containsKey(cur)){
  	            map.put(cur, i + 1);
  	        }
  	    }
  	    return result;
  	}
    
    public static void main (String[] args) {
    	List<Integer> A = new ArrayList<Integer>();
    	ArrayList<Integer> result = new ArrayList<Integer>(); 
    	A.add(2);
    	A.add(7);
    	A.add(7);
    	A.add(2);
    	result = twosum(A, 9);
    	for (int i = 0; i < result.size(); i++) {
    		System.out.println(result.get(i));
    	}
    	return;
    }

}
