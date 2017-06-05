package leetcode_173;

import java.util.Stack;

public class BinarySearchTreeIterator {

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

class BSTIterator {

	Stack<TreeNode> s=null;
	public BSTIterator(TreeNode root) {
		s = new Stack<>();
		TreeNode c = root;
		while(c != null){
			s.push(c);
			c = c.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !s.isEmpty();  
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode t = s.pop();
		int ret = t.val;
		TreeNode st = t.right;
		while(st != null){
			s.push(st);
			st = st.left;
		}
		return ret;
	}

}