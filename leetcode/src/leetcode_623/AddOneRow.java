package leetcode_623;

public class AddOneRow {

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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1) {
            TreeNode r = new TreeNode(v);
            r.left = root;
            return r;
        }
        return addOneRow(root,v,d-1,1);
    }
    TreeNode addOneRow(TreeNode root, int v, int d,int cur) {
         if(root == null) return null;
         if(d==cur){
            if(root.left!=null){
                TreeNode tem = root.left;
              root.left = new TreeNode(v);  
              root.left.left = tem;
              root.left.right = null;
            }else{
                root.left = new TreeNode(v);  
            }
            if(root.right!=null){
                TreeNode tem = root.right;
                root.right = new TreeNode(v);
                root.right.right = tem;
                root.right.left = null;
            }else{
                root.right = new TreeNode(v);
            }
         }else{
             root.left = addOneRow(root.left, v,d,cur+1);
             root.right = addOneRow(root.right,v,d,cur+1);
         }
         return root;
    }
}