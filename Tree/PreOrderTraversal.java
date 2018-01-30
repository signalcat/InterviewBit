
public class PreOrderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode root = A;
        if (root == null) {
            return result;
        }
        
        helper(result, root);
        return result;
    }
     
    public void helper(ArrayList<Integer> result, TreeNode node) {
        if (node != null) {
            result.add(node.val);
            helper(result, node.left);
            helper(result, node.right);
        }
    }
}
