package leetcode_513;

import java.util.ArrayList;

public class FindBottomLeftTreeValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
class TreeNode{
	TreeNode left,right;
	int val;
	TreeNode(int v){val =v;}
}
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        ArrayList<ArrayList<Integer>> lstTree = new ArrayList<ArrayList<Integer>>();
        travelTree(root, 0, lstTree);
        int last = lstTree.size()-1;
        if(last < 0)    return 0;
        return lstTree.get(last).get(0);
    }
    
    void travelTree(TreeNode root,int depth, ArrayList<ArrayList<Integer>> lstTree){
        if(lstTree.size() == depth){
            lstTree.add(new ArrayList());   
        }
        lstTree.get(depth).add(root.val);
        
        if(root.left != null)
            travelTree(root.left,depth+1, lstTree);
        if(root.right != null)
            travelTree(root.right,depth+1, lstTree);
    }
}