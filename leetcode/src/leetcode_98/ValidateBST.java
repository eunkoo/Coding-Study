package leetcode_98;

public class ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		//s.isValidBST(root)
	}

}
class TreeNode{
	TreeNode right;
	TreeNode left;
	long val;
}
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isRight(root.right,root.val,Long.MAX_VALUE) && isLeft(root.left,Long.MIN_VALUE,root.val);
    }
    boolean isRight(TreeNode right, long min,long max){
        if(right==null) return true;
        if(min < right.val && right.val < max)
            return isRight(right.right,right.val,max) && isLeft(right.left,min,right.val);
        else
            return false;
    }
    boolean isLeft(TreeNode left, long min,long max){
        if(left==null) return true;
        if(max > left.val && left.val > min)
            return isRight(left.right,left.val,max) && isLeft(left.left,min,left.val);
        else
            return false;
    }
}