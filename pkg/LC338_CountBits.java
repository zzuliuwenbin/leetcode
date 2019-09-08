package pkg;


/**
 * ����һ���Ǹ����� num������ 0 �� i �� num ��Χ�е�ÿ������ i ����������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
 * */

public class LC338_CountBits {
	
	/**
	 * ˼·һ���������
	 * */
	public int[] countBits(int num) {
		int bnum [] = new int[num+1];
		for(int i=0;i<=num;i++) {
			int t = 1,n = 0;
			for(int j=0;j<31;j++) {
				if((i&t)>0) {
					n++;
				}
				t = t<<1;
			}
			bnum[i] = n;
		}
		return bnum;
    }
	
	/**
	 * ˼·������̬�滮������������Чλ
	 * ���1��x������һ��k����ˣ���ôk+2��n�η���ǰ������ö�һ��1������������ǰ����ֱ�Ӽ�һ���
	 * 
	 * */
	public int[] countBits_dp(int num) {
		int bnum [] = new int[num+1];
		int i = 0;int b = 1;
		//[0,b)�����������
		while(b<=num) {//��Ҫ���ڣ�num���õ���b��ʱ������[b,2b)���������
			//����[0,b)����[b,2b)����Ϊ2b���ܻᳬ��num�������жϵ�ʱ���һ������
			while(i<b&&i+b<=num) {
				bnum[i+b] = bnum[i] + 1;
				i++;
			}
		}
		return bnum;
    }
	
	/**
	 * ˼·������̬�滮������������Чλ
	 * x��һ�ĸ�����x/2��һ�ĸ���ֻ�����һλ����Ϊ����x���Զ�Ӧͬһ��x/2
	 * ����x��x/2���ľ�����x�����һλ�ǲ���1
	 * */
	public int[] countBits_dp2(int num) {
		int bnum [] = new int[num+1];
		for(int i=1;i<=num;i++) {
			bnum[i] = bnum[i>>1]+(i&1);//�ѳ���ת��Ϊ��λ����(��λ�����ȼ��Ƚϵ�)
		}
		return bnum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
