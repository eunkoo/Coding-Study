package leetcode_257;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if(root == null) return result;
		String path = root.val+"";
		if(root.left == null && root.right == null) {
			result.add(path);
		}
		if(root.left != null)
			travelTree(result, path, root.left);
		if(root.right != null)
			travelTree(result, path, root.right);

		return result;
	}

	void travelTree(List<String> result, String path, TreeNode root){
		if(root.left == null && root.right == null){
			path += "->"+root.val;
			result.add(path);
			return;
		}
		path += "->"+root.val;
		if(root.left != null)
			travelTree(result, path, root.left);
		if(root.right != null)
			travelTree(result, path, root.right);

	}
}