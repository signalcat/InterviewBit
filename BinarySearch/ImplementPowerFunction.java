//Implement pow(x, n) % d.
//In other words, given x, n and d,
//find (x^n % d)
//Note that remainders on division cannot be negative. 

// example: 
// x = 2, n = 3, d = 3
// 2 ^ 3 % 3 = 8 % 3 = 2

// We want to reduce the times of multiplicaton
// assume we have A = x ^ n/2, then x ^ n = A * A if n is even
// x ^ n = A * A * x if n is odd
// so we use recursion to calculate each half and multiply them together.

// about negative mod: 
// -1 % 20 = 19
// because in computer science -1 % 20 = the distance between -1 and the first multiple of 20 less than -1
// that's -1 - (-20) = 19

public class ImplementPowerFunction {
	public static int pow(int x, int n, int d) {
		int product = helper(x, n);
		System.out.println("product: " + product);
		if (product >= 0) {
			return product % d;
		} else {
			return product % d + d;
		}
	}

	public static int helper(int x, int n) {
		// base case: if n is reduced to 0
		if (n == 0) {
			return 1;
		}
		int half = helper(x, n/2);
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}
	public static void main (String[] args) {
		int result = pow(-1,1,20);
		System.out.println(result);
	}
	
}
