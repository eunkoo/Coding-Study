package leetcode_109;

public class ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) return null;
		return toBST(head,null);
	}
	public TreeNode toBST(ListNode head, ListNode tail){
		ListNode fast = head;
		ListNode slow = head;
		if(head == tail) return null;

		while(fast!=tail && fast.next!=tail){
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = toBST(head, slow);
		root.right = toBST(slow.next,tail);

		return root;
	}
}