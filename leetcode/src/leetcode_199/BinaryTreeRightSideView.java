package leetcode_199;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNode{
	TreeNode left,right;
	int val;
	TreeNode(int v){val = v;}
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lstRightSide = new ArrayList<>();
        travelTree(root, 0,lstRightSide);
        return lstRightSide;
        
    }
    void travelTree(TreeNode root, int depth, List<Integer> lst){
        if(root == null) return;
        
        if(depth == lst.size())
            lst.add(root.val);
            
        travelTree(root.right, depth+1, lst);
        travelTree(root.left, depth+1, lst);
    }

}