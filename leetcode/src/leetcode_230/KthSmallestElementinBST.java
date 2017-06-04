package leetcode_230;

import java.util.Stack;

public class KthSmallestElementinBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		//s.kthSmallest(root, k)
	}

}
 class TreeNode{
     int val;
     TreeNode left;
     TreeNode right;
     public TreeNode(int v){
         val = v;
     }
 }
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null ) return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode target = null;
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        while(k > 0 && stack.size() > 0){
            target = stack.pop();
            // System.out.println("target :"+target.val);
            // System.out.println("k :"+k);
            TreeNode r =target.right;
            while(r != null){
                stack.push(r);
                r = r.left;
            }
            k--;
        }
        return target.val;
    }
}