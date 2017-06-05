package leetcode_111;

public class MinDepthBinaryTree {

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
    int minPath = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        travelTree(root,1);
        
        return minPath;
    }
    
    void travelTree(TreeNode root,int depth){
        if(root.left == null && root.right == null) {
            minPath = Math.min(depth, minPath);
            return;
        }
        if(depth > minPath) return;
        
        
        if(root.left != null)
            travelTree(root.left, depth+1);
        if(root.right != null)
            travelTree(root.right, depth+1);
        
    }
}