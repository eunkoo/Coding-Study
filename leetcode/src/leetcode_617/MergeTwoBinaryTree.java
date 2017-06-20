package leetcode_617;

public class MergeTwoBinaryTree {

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        int val = 0;
        if(t1==null&&t2==null)return null;
        if(t1!=null)    val+=t1.val;
        if(t2!=null)    val+=t2.val;
        TreeNode cur = new TreeNode(val);
        cur.left = mergeTrees(t1==null?null:t1.left,
                                t2==null?null:t2.left);
        cur.right = mergeTrees(t1==null?null:t1.right,
                                t2==null?null:t2.right);
        return cur;
    }
}