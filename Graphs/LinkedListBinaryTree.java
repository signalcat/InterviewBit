import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedListBinaryTree {
	static ListNode head;
	public static TreeNode sortedListToBST(ListNode a) {
		if(a == null) {
			return null;
		}
		head = a;
        return helper(0, findLen(a)-1);
	}
	
	public static TreeNode helper(int start, int end) {
		if (start > end) {
			return null;		
		}
		int mid = (start + end)/2;
		
		TreeNode root = new TreeNode(head.val);
		head = head.next;
		TreeNode left = helper(start, mid-1);
		TreeNode right = helper(mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static int findLen(ListNode head) {
		int len = 0;
		ListNode node = head;
		while(node != null) {
			node = node.next;
			len++;
		}
		return len;
	}
	
	public static void main (String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		sortedListToBST(head);
		return;
	}
}
