public class ReverseBit {
	public static long reverse(long a) {
		long b = 0;
		for (int i = 0; i < 32; i++){
			b <<= 1;
			System.out.println("b after shift left: " + Long.toBinaryString(b));
			if ((long) (a & 1) == 1) {
				b ^= 1;
			}
			System.out.println("b after mask: " + Long.toBinaryString(b));
			a >>= 1;
			System.out.println("a after shift right: " + Long.toBinaryString(a));
		}
		return b;
	}
	
	public static void main (String[] args) {
		long input = 3;
		System.out.println(reverse(input));
	}
}
