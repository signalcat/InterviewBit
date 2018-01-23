//Given a linked list, swap every two adjacent nodes and return its head.
//For example,
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//Your algorithm should use only constant space. You may not modify the values in the list, 
//only nodes itself can be changed.
//**********************************************************************
// Add dummy node 0->1->2->3->4
// 0->2, 1->3->4
// 0->2->1->3->4
// 0->2->1->4, 3
// 0->2->1->4->3
public class SwapListNodePairs {
	public static ListNode swapPairs(ListNode A) {
		ListNode dummy = new ListNode(0);
		dummy.next = A;
		A = dummy;
		
		while (A.next != null && A.next.next != null) {
			ListNode n1= dummy.next;
			ListNode n2 = dummy.next.next;
			dummy.next = n2;
			dummy.next.next = n1;
			A = n1;
		}
		return dummy.next;
	}
}
