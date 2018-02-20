import java.util.*;
public class BestTimeBuyStock {
	static int[] maxProfitSoFar;
	public static int minPriceSofar(List<Integer> A, int curDay) {
    	int min = A.get(0);
    	for (int i = 0; i <= curDay; i++) {
    		min = Math.min(min, A.get(i));
    	}
    	return min;
    }
	
    public static int maxProfit(final List<Integer> A) {
        int	maxProfitSoFar = 0;
    	for (int buyDate = 0; buyDate < A.size(); buyDate++) {
    		maxProfitSoFar = Math.max(maxProfitSoFar, A.get(buyDate) - minPriceSofar(A, buyDate));
    	}
    	return maxProfitSoFar;
    }
    
    public static void main (String[] args) {
    	List<Integer> A = new ArrayList<Integer>();
    	A.add(1);
    	A.add(2);
    	int max = maxProfit(A);
    	System.out.println(max);
    }
}
