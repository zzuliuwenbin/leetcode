package pkg;

/**
 * 请判断一个链表是否为回文链表。
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
    		//翻转需要延迟一个节点，否则slow无法顺利移动到下一个
    		//第一步，保存下要掉头的节点，slow要前往下一个了，不能再使用
    		pre = slow;
    		//第二步，找到下一个slow节点，不然一会儿当前slow掉头了，下一个就找不到了
    		slow = slow.next;
    		//第三步，掉头，需要用pre指针，slow已经走了
    		pre.next = prepre;
    		//第四步，为下一次掉头做准备
    		prepre = pre;
    		fast = fast.next.next;
    	}
    	
    	//奇数个，slow向下一步正好跨过中间节点
    	//偶数个，slow向下一步正好跨过中间线
    	ListNode p2 = slow.next;
    	//slow的最后一个节点还未掉头，需要续上面的节点
    	slow.next = pre;
    	
    	//fast为空，奇数个，回头走一步，跨过中间节点
    	//fast.next为空，偶数个，slow的位置刚好在中间线左侧
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
