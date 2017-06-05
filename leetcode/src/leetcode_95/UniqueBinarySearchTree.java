package leetcode_95;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeNode{
	TreeNode(int v){
		val = v;
	}
	TreeNode left,right;
	int val;
}
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0)return new ArrayList();
        return getTrees(1,n);
    }
    List<TreeNode> getTrees(int start, int end){
        List<TreeNode> lst = new ArrayList<TreeNode>();
        
        if(start > end){
            lst.add(null);    
        }
        
        for(int i=start;i<=end;i++){
            List<TreeNode> l = getTrees(start, i-1);
            List<TreeNode> r = getTrees(i+1,end);
            
            for(TreeNode lt : l){
                for(TreeNode rt : r){
                    TreeNode root = new TreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    lst.add(root);
                }
            }
        }
        return lst;
    }
}