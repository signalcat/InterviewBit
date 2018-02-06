import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> subArr = new ArrayList<Integer>();
		helper(A, res, subArr);
		return res;
    }
	
	public static void helper(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
		if (temp.size() == A.size()) {
			res.add(new ArrayList<Integer>(temp));
			//System.out.println(Arrays.toString(res.toArray()));
			
		} else {
			for (int i = 0; i < A.size(); i++) {
				System.out.println("i:" + i);
				if (temp.contains(A.get(i))) continue;
				temp.add(A.get(i));
				//System.out.println(Arrays.toString(temp.toArray()));
				helper(A, res, temp);
				//System.out.println(Arrays.toString(temp.toArray()));
				temp.remove(temp.size() - 1);
				//System.out.println(Arrays.toString(temp.toArray()));
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		input.add(1);
		input.add(2);
		input.add(3);
		res = permute(input);
		for (int i = 0; i < res.size(); i++) {
			ArrayList<Integer> b = res.get(i);
			System.out.println(Arrays.toString(b.toArray()));
		}
	}
}
