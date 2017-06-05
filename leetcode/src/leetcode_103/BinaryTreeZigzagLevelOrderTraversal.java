package leetcode_103;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lst = new ArrayList<List<Integer>>();
		if(root == null) return lst;
		travelTree(root, lst, 0);

		// travelTree(root.right,lst,1);
		// travelTree(root.left, lst,1);

		return lst;
	}

	void travelTree(TreeNode root, List<List<Integer>> lst, int depth){
		if(root == null) return;

		while(lst.size() <= depth )
			lst.add( new ArrayList<Integer>() );

		if(depth%2==0)
			lst.get(depth).add(root.val);
		else
			lst.get(depth).add(0,root.val);

		travelTree(root.left, lst, depth+1);
		travelTree(root.right, lst, depth+1);

		// if(depth%2==0){
			//     if(root.left!=null){
		//         travelTree(root.left.left, lst, depth+2);
		//         travelTree(root.left.right, lst, depth+2);
		//     }
		//     if(root.right!=null){
		//         travelTree(root.right.left, lst, depth+2);
		//         travelTree(root.right.right, lst, depth+2); 
		//     }
		// }else{

		//     if(root.right!=null){
		//         travelTree(root.right.right, lst, depth+2);
		//         travelTree(root.right.left, lst, depth+2); 
		//     }
		//     if(root.left!=null){
		//         travelTree(root.left.right, lst, depth+2);
		//         travelTree(root.left.left, lst, depth+2);
		//     }
		// }
	}
}