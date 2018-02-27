import java.util.*;
public class LongestSubSequence {
	public static int longestSubsequenceLength(final List<Integer> A) {
        if (A.isEmpty()) {
            return 0;
        }
        
        int[] incLens = maxIncSubArray(A);
        int[] decLens = maxDecSubArray(A);
        
//        for (int i = 0; i < A.size(); i++) {
//        	System.out.print(incLens[i]);
//        }
//        System.out.println();
//        for (int i = 0; i < A.size(); i++) {
//        	System.out.print(decLens[i]);
//        }
      
        for (int i = 0; i < A.size(); i++) {
        	incLens[i] = incLens[i] + decLens[i] - 1;	
        	//System.out.println(incLens[i]);
        }
        int max = incLens[0]; 
        for (int i = 1; i < A.size(); i++) {
            max = Math.max(max, incLens[i]);
        }
        return max;
    }
	
	public static int[] maxIncSubArray(List<Integer> input) {
		int[] lens = new int[input.size()];
		lens[0] = 1;
		for (int i = 1; i < input.size(); i++) {
			int maxSoFar = 0;
			for (int j = 0; j < i; j++) {
				if (input.get(j) < input.get(i)) {
					maxSoFar = Math.max(maxSoFar, lens[j]);
				}
			}
			lens[i] = maxSoFar + 1;
		}
		return lens;
	}
	
	public static int[] maxDecSubArray(List<Integer> input) {
		int[] lens = new int[input.size()];
		lens[input.size()-1] = 1;
		for (int i = input.size() - 2; i >= 0; i--) {
			int maxSoFar = 0;
			for (int j = input.size() - 1; j > i; j--) {
				if (input.get(j) < input.get(i)) {
					maxSoFar = Math.max(maxSoFar, lens[j]);
				}
			}
			lens[i] = maxSoFar + 1;
		}
		return lens;
	}
	
	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(3);
		A.add(5);
		A.add(6);
		A.add(4);
		A.add(8);
		A.add(4);
		A.add(3);
		A.add(2);
		A.add(1);
		int max = longestSubsequenceLength(A);
		System.out.println(max);
	}
}
