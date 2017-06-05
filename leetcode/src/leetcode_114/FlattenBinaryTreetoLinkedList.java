package leetcode_114;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNode{
	TreeNode left,right;
	int val;
	TreeNode(int v){val=v;}
}
class Solution {
    
    TreeNode tChild = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        flatten(left);
        flatten(right);
        root.right = left;
        
        TreeNode cur = root;
        while(cur.right != null)
            cur = cur.right;
        cur.right = right;
        
    }
}