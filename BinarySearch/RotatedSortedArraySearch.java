import java.util.*;

public class RotatedSortedArraySearch {
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
//		    System.err.println("Pivot: " + pivot);
//			if (pivot != -1)
//					System.err.println("Value: " + a.get(pivot));
		    if (pivot == -1) {
		        return binarySearch(a, 0, a.size()-1, b);
		    }
		    
		    if (b == a.get(pivot)) {
		        return pivot;
		    } else if (b >= a.get(0)) {
		        return binarySearch(a, 0, pivot, b);
		    } else {
				return binarySearch(a, pivot + 1, a.size()-1, b);
		    }
		}
		
		public int findPivot(List<Integer> a) {
		    if (a.get(0) <= a.get(a.size() - 1)) {
		        return -1;
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
		
		public int binarySearch(List<Integer> a, int start, int end, int b) {
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
}
