package pkg;

/**
 * 给定一个链表，判断链表中是否有环。
 * 思路：两个指针，分别向前走，一个一次走一步，一个一次两步，有环的话会在环内相遇
 * */

public class LC141_HasCycle {
	class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
		}
	}
	public boolean hasCycle(ListNode head) {
		//边界条件
		if(head==null) {
			return false;
		}
		ListNode slow = head,fast = head.next;
		while(fast!=null&&slow!=fast) {
			fast = fast.next==null?null:fast.next.next;
			slow = slow.next;
		}
		if(fast==null) {
			return false;
		}else {
			return true;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}