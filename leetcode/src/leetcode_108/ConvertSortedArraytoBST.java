package leetcode_108;

public class ConvertSortedArraytoBST {

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
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length ==0) return null;
		return addTree(nums, nums.length-1,0);

	}

	TreeNode addTree(int[]nums, int h, int l){
		int mid = (h+l)/2 ;
		TreeNode root = new TreeNode(nums[mid]);
		if(h > l){
			if(mid>l)
				root.left = addTree( nums, mid-1,l);
			if(mid<h)
				root.right = addTree( nums, h, mid+1);
		}
		return root;

	}


}