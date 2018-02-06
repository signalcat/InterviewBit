import java.util.*;
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = A;
        
       while (cur != null || !stack.isEmpty()) {
           if (cur != null) {
               stack.push(cur);
               cur = cur.left;
           } else {
               cur = stack.pop();
               res.add(cur.val);
               cur = cur.right;
           }
       }
       return res;
    }
}