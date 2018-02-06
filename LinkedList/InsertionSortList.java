//Sort a linked list using insertion sort.

class ListNode {
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; next = null; }
}

public class InsertionSortList {
	public ListNode insertionSortList(ListNode A) {
		ListNode cur = A;
	    ListNode dummy = new ListNode(0);
		while (cur != null) {
			ListNode next = cur.next;
			ListNode pre = dummy;
			while(pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return dummy.next;
    }
}
