import java.util.*;

public class GrayCode {
	public static ArrayList<String> helper(int size) {
		if (size == 1) {
			ArrayList<String> res = new ArrayList<String>();
			res.add("0");
			res.add("1");
			return res;
		}
		
		ArrayList<String> subList = helper(size - 1);
		ArrayList<String> resList = new ArrayList<String>();
		
		for (int i = 0; i < subList.size(); i++) {
			resList.add("0" + subList.get(i));
		}
		System.out.print(Arrays.toString(resList.toArray()));
		for (int i = subList.size() - 1; i >= 0; i--) {
			resList.add("1" + subList.get(i));
		}
		System.out.print(Arrays.toString(resList.toArray()));
		return resList;
	}
	
	public static ArrayList<Integer> grayCode(int input) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<String> resList = new ArrayList<String>(); 
		resList = helper(input);
	    for (String s : resList) {
	    	res.add(Integer.parseInt(s, 2));
	    }
		return res;
	}
	
	public static void main (String[] args) {
		int input = 3;
		ArrayList<Integer> res = new ArrayList<Integer>();
		res = grayCode(input);
		System.out.println(Arrays.toString(res.toArray()));
	}
}
