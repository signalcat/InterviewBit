//Implement int sqrt(int x).
//Compute and return the square root of x.
//If x is not a perfect square, return floor(sqrt(x))
//Example :
//Input : 11
//Output : 3

public class SquareRootOfInteger {
	public long sqrt(int a) {
	    if (a == 0 || a == 1) {
			return a;
		}
		
		long start = 1, end = a;
		long result = 0;
		while(start <= end) {
			long mid = (start + end) / 2;
			if (mid * mid == a) {
				return mid;
			}
			if (mid * mid < a) {
				start = mid + 1;
				result = mid;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}	
}
