package pkg;

public class MergeTwoLists {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode p1 = result;
		while(l1!=null&&l2!=null) {
			if(l1.val<l2.val) {
				p1.next = l1;
				l1 = l1.next;
			}else {
				p1.next = l2;
				l2 = l2.next;
			}
			p1 = p1.next;
		}
		if(l1==null) {
			p1.next = l2;
		}else {
			p1.next = l1;
		}
		return result.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
