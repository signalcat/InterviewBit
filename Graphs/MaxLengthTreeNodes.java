import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxLengthTreeNodes {
	
//	public int solve(ArrayList<Integer> A) {
//    }
	
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
	
	public static void main(String[] args) {
		/* creating a binary tree and entering the nodes */
		TreeNode tree = new TreeNode(0);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        levelOrder(tree);
        return;
	}
	
}
