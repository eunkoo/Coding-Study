package leetcode_563;

public class BinaryTreeTilt {

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
	int total = 0;
	public int findTilt(TreeNode root) {
		if(root == null) return 0;
		travelTree(root);
		return total;
	}
	int travelTree(TreeNode root){
		if(root == null) return 0;

		int l = travelTree(root.left);
		int r = travelTree(root.right);
		int tilt = Math.abs(l-r);
		total += tilt;
		//System.out.println(tilt+root.val);

		return l+r+ root.val;
	}
}