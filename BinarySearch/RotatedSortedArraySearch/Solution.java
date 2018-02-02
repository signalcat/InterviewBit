import java.util.*;

public class Solution {
	// DO NOT MODIFY THE LIST
	// if target value == pivot, return pivot
	// if target value < pivot, binary search a[0] to a[pivot]
	// else binary search a[pivot + 1] to a[n-1]
    // If a[0] <= a[length - 1] means It's not rotated. return -1
    // Binary searh pivot
    // if mid+1 is pivot(a[mid] > a[mid+1]), return mid + 1
    // else if a[start] <= a[mid] means all elements here are in sorted order
    // set start = mid + 1 so we look for pivot in second half
    // else set end = mid - 1, look for pivot in the first half
	public int search(final List<Integer> a, int b) {
	    if (a.size() == 0 || a == null) {
	        return -1;
	    }
	    
	    int pivot = findPivot(a);
//	    System.err.println("Pivot: " + pivot);
//	    System.err.println("Value: " + a.get(pivot));
	    if (pivot == -1) {
	        return binarySearch(a, b);
	    }
	    
	    if (b == a.get(pivot)) {
	        return pivot;
	    } else if (b >= a.get(0)) {
	        return binarySearch(a.subList(0, pivot), b);
	    } else {
			int retVal = binarySearch(a.subList(pivot + 1, a.size()), b);
	        return retVal == -1 ? retVal : retVal + pivot + 1;
	    }
	}
	
	public int findPivot(List<Integer> a) {
	    if (a.get(0) <= a.get(a.size() - 1)) {
	        return 0;
	    }
	    int start = 0;
	    int end = a.size() - 1;
	    while (start <= end) {
	        int mid = (start + end) / 2;
	        if (a.get(mid + 1) < a.get(mid)) {
	            return (mid + 1);
	        } else if (a.get(start) <= a.get(mid)) {
	            start = mid + 1;
	        } else {
	            end = mid - 1;
	        }
	    }
	    return -1;
	}
	
	public int binarySearch(List<Integer> a, int b) {
	    int start = 0;
	    int end = a.size() - 1;
	    while (start <= end) {
	        int mid = (start + end) / 2;
		//	System.out.printf("Start: %d, End: %d, Mid: %d\n", a.get(start), a.get(end), a.get(mid));
	        if (a.get(mid) == b) {
	            return mid;
	        } else if (a.get(mid) < b) {
	            start = mid + 1;
	        } else {
	            end = mid - 1;
	        }
	    }
	    return -1;
	}
//	public static void main(String[] args) {
////		Solution solution = new Solution();
////List<Integer> input = new ArrayList<Integer>(Arrays.asList(180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177));
////		int retVal = solution.search(input, 42);
////		System.out.printf("Expected Value: 43, Actual Value: %d\n", retVal);
//		Solution solution = new Solution();
//List<Integer> input = new ArrayList<Integer>(Arrays.asList(19, 20, 21, 22, 28, 29, 32, 36, 39, 40, 41, 42, 43, 45, 48, 49, 51, 54, 55, 56, 58, 60, 61, 62, 65, 67, 69, 71, 72, 74, 75, 78, 81, 84, 85, 87, 89, 92, 94, 95, 96, 97, 98, 99, 100, 105, 107, 108, 109, 110, 112, 113, 115, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 130, 131, 133, 134, 135, 136, 137, 138, 139, 141, 142, 144, 146, 147, 148, 149, 150, 153, 155, 157, 159, 161, 163, 164, 169, 170, 175, 176, 179, 180, 185, 187, 188, 189, 192, 196, 199, 201, 203, 205, 3, 7, 9, 10, 12, 13, 17 ));
//		int retVal = solution.search(input, 6);
//		System.out.printf("Expected Value: -1, Actual Value: %d\n", retVal);
//	}		
}

