package pkg;
/**
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 * 
 * */
public class ClimbStairs {
	//������Ϲ�ʽ���㣬��������Ż���o(1)ʱ���ڼ��������������㷨Ӧ�û���ͦ��
	public int C(int a,int b) {
		long t1 = 1, t2 = 1;
		for(int i=b,j=1;i>b-a;i--) {
			t1 = t1*i;t2 = t2*j;j++;
			if(t1%t2==0) {//���㵽��β���������������t1�����int���ڵ�43����������ʱ���������
				t1 = t1/t2;
				t2 = 1;
			}
		}
		return (int)(t1/t2);
	}
	public int climbStairs(int n) {
		int sum = 0;
		for(int i=0;i<=n/2;i++) {
			if(i>(n-i)/2) {//������Ϲ�ʽ���ص���ټ�����
				sum = sum + C(n-2*i,n-i);
			}else {
				sum = sum + C(i,n-i);
			}
			
		}
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbStairs test = new ClimbStairs();
		System.out.println(test.climbStairs(44));
	}

}
