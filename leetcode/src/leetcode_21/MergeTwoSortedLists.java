package leetcode_21;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null && l2==null) return l1;
		ListNode head = new ListNode(0),ret=head;
		while(l1!=null || l2!=null){
			if(l1==null){
				head.next = new ListNode(l2.val);
				l2=l2.next;
			}else if(l2==null){
				head.next = new ListNode(l1.val);
				l1=l1.next;
			}else{
				if(l1.val < l2.val){
					head.next = new ListNode(l1.val);
					l1=l1.next;
				}else{
					head.next = new ListNode(l2.val);
					l2=l2.next;
				}   
			}
			head = head.next;
			if(ret==null) ret = head;
		}
		return ret.next;
	}
}