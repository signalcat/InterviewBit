import java.util.ArrayList;

//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//You may assume no duplicates in the array.
//Here are few examples.
//[1,3,5,6], 5 → 2
//[1,3,5,6], 2 → 1
//[1,3,5,6], 7 → 4
//[1,3,5,6], 0 → 0
public class SortedInsertPosition {
	public static int searchInsert(ArrayList<Integer> a, int b) {
		int start = 0;
		int end = a.size() - 1;
		
		if (b < a.get(start)) {
			return 0;
		}
		
		if (b > a.get(end)) {
			return a.size();
		}
		
		while (start <= end) {
			int mid = (start + end) / 2;
			if (a.get(mid) == b) {
				return mid;
			}
			
			if (a.get(mid) < b) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(3);
		input.add(5);
		input.add(6);
		int result = searchInsert(input, 2);
		System.out.println(result);
	}
}
