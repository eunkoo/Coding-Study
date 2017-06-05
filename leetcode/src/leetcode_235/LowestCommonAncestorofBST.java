package leetcode_235;

public class LowestCommonAncestorofBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p==null || q==null) return null;
		while((root.val-p.val)*(root.val-q.val)>0)
			root = p.val > root.val ? root.right : root.left;

			return root;
	}


}