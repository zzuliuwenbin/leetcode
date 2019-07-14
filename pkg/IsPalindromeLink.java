package pkg;

/**
 * ���ж�һ�������Ƿ�Ϊ��������
 * */
public class IsPalindromeLink {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public boolean isPalindrome(ListNode head) {
    	if(head == null || head.next == null) return true;
    	ListNode slow = head, fast = head.next, pre = null, prepre = null;
    	while(fast != null && fast.next != null) {
    		//��ת��Ҫ�ӳ�һ���ڵ㣬����slow�޷�˳���ƶ�����һ��
    		//��һ����������Ҫ��ͷ�Ľڵ㣬slowҪǰ����һ���ˣ�������ʹ��
    		pre = slow;
    		//�ڶ������ҵ���һ��slow�ڵ㣬��Ȼһ�����ǰslow��ͷ�ˣ���һ�����Ҳ�����
    		slow = slow.next;
    		//����������ͷ����Ҫ��preָ�룬slow�Ѿ�����
    		pre.next = prepre;
    		//���Ĳ���Ϊ��һ�ε�ͷ��׼��
    		prepre = pre;
    		fast = fast.next.next;
    	}
    	
    	//��������slow����һ�����ÿ���м�ڵ�
    	//ż������slow����һ�����ÿ���м���
    	ListNode p2 = slow.next;
    	//slow�����һ���ڵ㻹δ��ͷ����Ҫ������Ľڵ�
    	slow.next = pre;
    	
    	//fastΪ�գ�����������ͷ��һ��������м�ڵ�
    	//fast.nextΪ�գ�ż������slow��λ�øպ����м������
    	ListNode p1 = fast == null? slow.next : slow;
    	while(p1 != null) {
    		if(p1.val != p2.val)
    			return false;
    		p1 = p1.next;
    		p2 = p2.next;
    	}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
