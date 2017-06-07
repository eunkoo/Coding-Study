package leetcode_437;

import java.util.ArrayList;
import java.util.List;

public class PathSum3 {

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
	public int pathSum(TreeNode root, int sum) {

		return findNum(root,sum,new ArrayList<Integer>());
	}

	int findNum(TreeNode root, int sum, List<Integer> lst){
		if(root == null) return 0;
		int count = 0;
		for(int i=0;i<lst.size();i++){
			lst.add(i,lst.get(i)+root.val);
			if(sum==lst.get(i)) count++;
			lst.remove(i+1);
		}
		if(root.val==sum)count++;
		lst.add(root.val);
		List<Integer> temp = new ArrayList<Integer>(lst);
		int lc =  findNum(root.left, sum, lst);
		int rc = findNum(root.right, sum, temp);

		return count+lc+rc;
	}
}