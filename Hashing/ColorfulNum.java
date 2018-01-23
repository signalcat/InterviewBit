import java.util.HashMap;

//For Given Number N find if its COLORFUL number or not

//A number can be broken into different contiguous sub-subsequence parts. 
//Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
//And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
//************************************************************************************
//Find out the different subsequence parts
//
//2 -> 2
//12 -> 1,2
//123 -> 1, 2, 3, 12, 23
//1234 -> 1,2,3,4,12,23,34,123,234
// integer to string
// get all the substring
//
//Calculate the product of every part
//Store in hashmap as the hashcode
//Check how many times each prodcut appears
//If more than 1, then this is not a colorfull number
//If is 1, then this is a colorful numer

public class ColorfulNum {
	public static int isColorful (int N) {
		
		String str = Integer.toString(N);
		int len = str.length();
		if (len == 0 || len == 1) {
			return 1;
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < len; i++) {
			for (int j = 1; j <= len; j++) {
				if ( i + j > len) break;
				String sub = str.substring(i, i+j);
				int b = i+j;
				System.out.println(i + "to" + b);
				System.out.print(sub);
				System.out.println();
				int num = 1;
				for (int k = 0; k < sub.length(); k++) {
					num = num * (sub.charAt(k) - '0');
				}
				if (map.containsKey(num)) {
					return 0;
				} else {
					map.put(num, 1);
				}
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		int result = isColorful(122);
		System.out.println(result);
		return;
	}
}
