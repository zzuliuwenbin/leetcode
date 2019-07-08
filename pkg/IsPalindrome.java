package pkg;
/**
 *  �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 * 
 * */
public class IsPalindrome {
	
	public boolean isPalindrome(int x) {
		if(x<0) {
			return false;
		}
		int tem = x;
		int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) 
                return false;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) 
                return false;
            ans = ans * 10 + pop;
            x /= 10;
        }
        if(ans == tem) {
        	return true;
        }else {
        	return false;
        }
    }

	/*public boolean isPalindrome(int x) {
        // ���������
        // ������������ x < 0 ʱ��x ���ǻ�������
        // ͬ���أ�������ֵ����һλ�� 0��Ϊ��ʹ������Ϊ���ģ�
        // �����һλ����ҲӦ���� 0
        // ֻ�� 0 ������һ����
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // �����ֳ���Ϊ����ʱ�����ǿ���ͨ�� revertedNumber/10 ȥ��������λ�����֡�
        // ���磬������Ϊ 12321 ʱ���� while ѭ����ĩβ���ǿ��Եõ� x = 12��revertedNumber = 123��
        // ���ڴ�����λ�����ֲ�Ӱ����ģ����������Լ���ȣ����������ǿ��Լ򵥵ؽ���ȥ����
        return x == revertedNumber || x == revertedNumber/10;
    }*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPalindrome test = new IsPalindrome();
		System.out.println(test.isPalindrome(3221));
		
	}

}
