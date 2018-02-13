// Return the level order traversal result
// enqueue root
// tempNode = root while it's not null
// enqueue tempNode's left and right children 
// dequeue first node from q as new tempNode

import java.util.*;


public class LevelOrderBTree {
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (A == null) return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(A);
		
		while(!queue.isEmpty()) {
			ArrayList<Integer> subList = new ArrayList<Integer>();
			int numPerLevel = queue.size();
			for (int i = 0; i < numPerLevel; i++) {
				TreeNode tempNode = queue.poll();
				subList.add(tempNode.val);
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
			System.out.print(Arrays.toString(subList.toArray()));
			res.add(subList);
		}
		return res;
	}	
	
	public static void main (String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		levelOrder(root);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		return;
	}
}
