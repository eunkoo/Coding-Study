package leetcode_83;

public class RemoveDuplsFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next = new ListNode(2);
		s.deleteDuplicates(head);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}

}
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
 class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next==null) return head;
        int curr = head.val;
        ListNode ret = head;
        ListNode prev = head;
        head = head.next;
        while(head!=null){
            if(curr == head.val)
                prev.next = head.next;
            else{
                curr = head.val;
                prev = head;
            }
            head = head.next;
        }
        return ret;
    }
}