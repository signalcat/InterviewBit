
public class Solution {

    /*
     * Complete the function below.
     */
     static long count(int[] numbers, int k) {
        long[] prefixProduct = new long[numbers.length];
        long runningProduct = 1L;

        for (int i = 0; i < numbers.length; i++) {
            runningProduct *= (long) numbers[i];
        	prefixProduct[i] = runningProduct;
            // There appears to be an overflow here, but the problem's bounds indicate that there should be no overflow; currently stuck here...
            if (prefixProduct[i] == 0) System.exit(1);
            //System.out.println(prefixProduct[i]);
        }
        
        
        long count = 0;
        for (int startIdx = 0; startIdx < numbers.length; startIdx++) {
            count += findMaxEndIdx(prefixProduct, startIdx, k);
            //System.out.println(count);
        }
        return count;
    }
    static long findMaxEndIdx(long[] prefixProduct, int startIdx, long k) {
        int start = startIdx;
        int end = prefixProduct.length - 1;
        long divisor = getDivisor(prefixProduct, startIdx);
       // System.out.println("divisor: " + divisor);
        //System.out.printf("ppEnd = %d, k = %d, divisor = %d, ppEnd / divisor = %d\n", prefixProduct[end], k, divisor,  prefixProduct[end] / divisor);
        if (prefixProduct[end]/divisor < k ) {
            return end - start + 1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (prefixProduct[mid] / divisor>= k ) {
                end = mid - 1;
            } else if (prefixProduct[mid] / divisor < k  && prefixProduct[mid + 1] / divisor >= k ){
                return mid - startIdx + 1;
            } else {
                start = mid + 1;
            }
        }
        return 0; 
    }

    static long getDivisor(long[] prefixProduct, int startIdx) {
        if (startIdx == 0) {
            return 1;
        }
        return prefixProduct[startIdx - 1];
    }



    public static void main (String[] args) {
    	int[] numbers = new int[]{4,13,20,32,44,59,61,71,75,86,88};
    	long count = count(numbers, 567601);
    	System.out.println(count);
    }
}
