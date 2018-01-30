import java.util.*;
class ListNode {
	public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class LinkedListCycle {
	public ListNode detectCycle(ListNode a) {
		Hashset<ListNode>() set = new HashSet<ListNode>();
		ListNode cur = a;
	    while(cur.next != null) {
	        if (set.add(cur)) {
	            cur = cur.next;
	        } else {
	            return cur;
	        }
	    }
	    return null;
	}
	
}
