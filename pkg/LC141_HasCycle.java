package pkg;

/**
 * ����һ�������ж��������Ƿ��л���
 * ˼·������ָ�룬�ֱ���ǰ�ߣ�һ��һ����һ����һ��һ���������л��Ļ����ڻ�������
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
		//�߽�����
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