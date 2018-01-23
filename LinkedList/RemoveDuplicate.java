//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.
//*****************************************************
//
// 

class ListNode {
	public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
 
public class RemoveDuplicate {
	public static ListNode deleteDuplicates(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}
		ListNode cur = A;
	    while (cur != null) {
	    	if (cur.next == null) {
	    		break;
	    	}
	    	if (cur.val == cur.next.val) {
	    		cur.next = cur.next.next;
	    	} else {
	    		cur = cur.next;
	    	}
	    }
	    return A;
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = null;
		
		printList(head);
		ListNode result = deleteDuplicates(head);
		System.out.println();
		printList(result);
	}
	
	public static void printList(ListNode A) {
		ListNode head = A;
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
