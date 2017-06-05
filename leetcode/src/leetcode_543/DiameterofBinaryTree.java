package leetcode_543;

public class DiameterofBinaryTree {

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
	int maxDepth = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null) return 0;
		travelTree(root,0);
		return maxDepth;
	}

	int travelTree(TreeNode root, int depth){

		int r = depth, l = depth;
		if(root.right != null)
			r = travelTree(root.right, depth+1);
		if(root.left != null)
			l = travelTree(root.left, depth+1);

		maxDepth = Math.max(maxDepth, l+r-depth*2);
		return  Math.max(l , r) ;
	}
}