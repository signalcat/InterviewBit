
public class InvertBinayTree {
	public TreeNode invertTree(TreeNode A) {
        if (A == null) {
            return null;
        }
        
        helper(A);
        return A;
    }
    public void helper(TreeNode A) {
        if (A == null) {
            return;
        }
        
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;    
        
        helper(A.left);
        helper(A.right);
    }
}
