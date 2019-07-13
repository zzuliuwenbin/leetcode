package pkg;
/**
 * ��дһ�������ҵ������������ཻ����ʼ�ڵ㡣 
 * */

public class GetIntersectionNode {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    ListNode pa = headA, pb = headB;
	    while (pa != pb) {
	        pa = pa == null ? headB : pa.next;
	        pb = pb == null ? headA : pb.next;
	    }
	    return pa;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���");
		System.out.println(111);
	}

}
