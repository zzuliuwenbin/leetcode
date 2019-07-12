package pkg;

public class ReverseList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	/*
	private ListNode a = new ListNode(0);
	private ListNode b = a;
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
		reverseList(head.next);
		b.next = new ListNode(head.val);
		b = b.next;
        return a.next;
    }
    */
	//递归原地翻转链表
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}else {
			ListNode pre = reverseList(head.next);
			head.next.next = head;
			head.next = null;
			return pre;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
