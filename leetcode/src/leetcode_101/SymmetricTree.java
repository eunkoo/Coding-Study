package leetcode_101;

public class SymmetricTree {

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
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return check(root.left,root.right);
	}

	boolean check(TreeNode p, TreeNode q){
		if(p == null && q == null)   {
			return true;
		}else if(p == null | q == null){
			return false;
		}
		return (p.val == q.val) && check(p.left, q.right) && check(p.right, q.left);
	}
}