package pkg;

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int m=0,n=0,a=0,b=0,c=0;
		ListNode p1 = null;
		ListNode p2 = null;
		ListNode p3 = null;
		ListNode e1 = null;
		ListNode result = null;
		
		//计算最大节点数
		p1 = l1;while(p1!=null) {m++;p1=p1.next;}
		p1 = l2;while(p1!=null) {n++;p1=p1.next;}
		if(m<n) { m = n; }
		
		//创建结果链表
		result = new ListNode(0);
		p1 = result;
		for(int i=1;i<m;i++) {
			p1.next = new ListNode(0);
			p1 = p1.next;
		}
		
		p1.next = new ListNode(0);	//默认补一个节点，最后根据该节点是否为0,决定是否去除该节点
		e1 = p1;					//记录下最后节点的前一个节点，方便删除最后一个节点
		
		//开始求和
		p1 = l1;p2=l2;p3=result;
		while(p3!=null) {
			if(p1!=null) {//节点不为空，取出值，指针后移
				a = p1.val;
				p1 = p1.next;
			}else {
				a = 0;
			}
			
			if(p2!=null) {//节点不为空，取出值，指针后移
				b = p2.val;
				p2 = p2.next;
			}else {
				b = 0;
			}
			
			p3.val = (a+b+c)%10;
			c = (a+b+c)/10;//进位
			p3 = p3.next;
		}
		if(e1.next.val==0) {//删除最后一个节点
			e1.next = null;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers x = new AddTwoNumbers();
		ListNode p = null;
		ListNode l1 = x.new ListNode(5);
		ListNode l2 = x.new ListNode(5);
		l1.next = x.new ListNode(4);
		l2.next = x.new ListNode(6);
		l1.next.next = x.new ListNode(3);
		l2.next.next =x.new ListNode(4);
		p = x.addTwoNumbers(l1, l2);
		while(p!=null) {
			System.out.println(p.val);
			p=p.next;
		}

	}

}
