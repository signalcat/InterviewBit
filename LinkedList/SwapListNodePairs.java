//Given a linked list, swap every two adjacent nodes and return its head.
//For example,
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//Your algorithm should use only constant space. You may not modify the values in the list, 
//only nodes itself can be changed.
//**********************************************************************

public class SwapListNodePairs {
	public static ListNode swapPairs(ListNode A) {
		if (A == null || A.next == null) return A;
		ListNode cur = A;
		ListNode newHead = A.next;
	    ListNode pre = null;
	    
		while (cur != null) {
			ListNode nextCur = cur.next.next;
			newHead.next = cur;
			cur.next = null;
			pre = cur;
			if (pre != null) {
				pre.next = nextCur.next;
			}
			cur = nextCur;	
		}
	}
}


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) return A;
        // Take things two at a time.
        ListNode retVal = A.next;
        ListNode cur = A;
        ListNode prev = null;
        while (cur != null) {
            // Reached the end of the list
            if (cur.next == null) {
                prev.next = cur;
                break;
            }

            ListNode nextCur = cur.next.next;
            cur.next.next = cur;
            if (prev != null) prev.next = cur.next;
            cur.next = null;
            prev = cur;
            cur = nextCur;
        }
        return retVal;
    }
}
