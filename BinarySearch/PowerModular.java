public class PowerModular {
	public static int pow(int x, int n, int d) {
        x %= d;
        if (x < 0) x += d;
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x % d;
    
        long half = pow(x, n/2, d);
        long full = (half * half) % d;
    
        // Odd
        if (n % 2 != 0) return (int)((full * x) % d);
        return (int) (full % d);
    }
}
