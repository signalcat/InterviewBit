package com.codepath;
import java.util.*;

public class maxSumContigiousSubArr {
	public int maxSubArray(final List<Integer> A) {
        int maxSoFar = A.get(0);
        int maxEndingHere = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            maxEndingHere = Math.max(maxEndingHere + A.get(i), A.get(i));
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar; 
    }
}
