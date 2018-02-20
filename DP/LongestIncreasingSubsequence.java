import java.util.*;
public class LongestIncreasingSubsequence {
    public static int lis(final List<Integer> A) {
    	if (A.isEmpty()) return 0;
    	int[] maxLen = new int[A.size()];
    	maxLen[0] = 1;
    	for (int i = 1; i < A.size(); i++) {
    		int maxSoFar = 0;
    		for (int j = 0; j < i; j++) {
    			if (A.get(j) < A.get(i)) {
    				maxSoFar = Math.max(maxSoFar, maxLen[j]);
    			}
    		}
    		maxLen[i] = maxSoFar + 1;
    	}
    	int max = 0;
    	for (int i = 0; i < maxLen.length; i++) {
    		max = Math.max(max, maxLen[i]);
    	}
    	return max;
    }
    
    public static void main (String[] args) {
    	List<Integer> A = new ArrayList<Integer>();
    	A.add(0);
    	A.add(8);
    	A.add(4);
    	A.add(12);
    	A.add(2);
    	A.add(10);
    	A.add(6);
    	A.add(14);
    	A.add(1);
    	A.add(9);
    	A.add(5);
    	A.add(13);
    	A.add(3);
    	A.add(11);
    	A.add(7);
    	A.add(15);
    	int res = lis(A);
    	System.out.println(res);
    }
}
