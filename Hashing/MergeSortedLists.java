class ListNode {
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; next = null; }
}

//A 5-99
//B 4-15-20
	
public class MergeSortedLists {

	public static ListNode merge(ListNode A, ListNode B) {
		
//		ListNode newHead = new ListNode(Math.min(A.val, B.val));
//		newHead.next = new ListNode(Math.max(A.val, B.val));
//		
//		A = A.next;
//		B = B.next;
		
		ListNode cur = new ListNode(0);
		
		while (A != null && B != null) {
			if (A.val >= B.val) {
				append(cur, B.val); 
				B = B.next;
			} else {
				append(cur, A.val);
				A = A.next;
			}
			cur = cur.next;
		}
		
		if (A != null) {
			appendList(cur,A);
		}
		
		if (B != null) {
			appendList(cur,B);
		}
		
		return cur;
	}
	
	public static void main (String[] args) {

		ListNode A = new ListNode(5);
		append(A,99);
		
		ListNode B = new ListNode(4);
		append(B,15);
		append(B,20);
		
		ListNode C = merge(A,B);
		printList(C);
		
		return;
		
	}
	
	public static void append(ListNode head, int val) {
		ListNode cur = head;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = new ListNode(val);
		return;
	}
	
	public static void appendList(ListNode A, ListNode B) {
		ListNode cur = A;
		while (cur.next!= null) {
			cur = cur.next;
		}
		cur.next = B;
		return;
	}
	
	public static void printList(ListNode head) {
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		return;
	}
	
}
