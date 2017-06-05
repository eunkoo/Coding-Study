package leetcode_222;

public class CountCompleteTreeNoe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		
	}

}
class TreeNode{
	TreeNode left,right;
	int val;
}
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)    return 0;
         int h=0;
        TreeNode l = root.right;
        TreeNode r = root.right;
        while(r != null){
            h++;
            l = l.left;
            r = r.right;
        }
        if(l!=null) 
            return 1 + (1<<h+1)-1 + countNodes(root.right);
        else
            return 1 + countNodes(root.left) + (1<<h)-1;
    }
}
