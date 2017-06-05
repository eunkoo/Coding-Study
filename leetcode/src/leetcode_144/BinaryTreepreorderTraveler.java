package leetcode_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class BinaryTreepreorderTraveler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
class TreeNode{
	TreeNode left,right;
	int val;
}
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> lstPreOrder = new ArrayList<>();
       if(root == null) return lstPreOrder;
       TreeNode r = root;
       Stack<TreeNode> stack = new Stack<>();
       while(r != null){
           lstPreOrder.add(r.val);
           if(r.right!=null){
               stack.push(r.right);
           }
           r = r.left;
           if(r==null && !stack.isEmpty()){
               r = stack.pop();
               
           }
           
       }
       
       return lstPreOrder;
   }
   // public List<Integer> preorderTraversal(TreeNode root) {
   //     List<Integer> lstPreOrder = new ArrayList<>();
   //     if(root == null) return lstPreOrder;   
   //     findPreOrderList(lstPreOrder, root);
   //     return lstPreOrder;
   // }
   // void findPreOrderList(List<Integer> lst, TreeNode root){
       
   //     lst.add(root.val);
   //     if(root.left != null)
   //         findPreOrderList(lst, root.left);
   //     if(root.right != null)
   //         findPreOrderList(lst, root.right);
   // }
}