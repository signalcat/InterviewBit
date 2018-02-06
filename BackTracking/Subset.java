import java.util.*;

public class Subset {
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		Collections.sort(A);
		ArrayList<Integer> subset = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		//System.out.println(Arrays.toString(subset.toArray()));
		ArrayList<Integer> empty = new ArrayList<Integer>();
		res.add(empty);
		//System.out.println(Arrays.toString(res.toArray()));
		helper(A, subset, res, 0);
		return res;
	}
	
	public static void helper(ArrayList<Integer> A, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> res, int idx) {
		for (int i = idx; i < A.size(); i++) {
			// include A[i] in subset
			subset.add(A.get(i));
			//System.out.println(Arrays.toString(subset.toArray()));
			
			res.add(new ArrayList<Integer>(subset));
			//System.out.println(Arrays.toString(res.toArray()));
			
			// move on to the next element
			helper(A, subset, res, i+1);
			
			// exclude A[i] from subset and triggers backtracking
			subset.remove(subset.size()-1);
			
		}
		return;
	}
	
	public static void main (String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		a.add(1);
		a.add(3);
		a.add(2);
		res = subsets(a);
		for (int i = 0; i < res.size(); i++) {
			ArrayList<Integer> b = res.get(i);
			System.out.println(Arrays.toString(b.toArray()));
		}
		return;
	}
	
	
}
