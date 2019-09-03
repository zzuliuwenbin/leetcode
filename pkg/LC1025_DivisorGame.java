package pkg;

/**
 * ����˿�ͱ���һ������Ϸ,���������ж�������˿���ֿ��֡�
 * ������ڰ�����һ������N����ÿ����ҵĻغϣ������Ҫִ�����²�����
 * ѡ����һx,����0< x < N��N % x == 0��
 * �� N - x �滻�ڰ��ϵ����� N ��
 * �������޷�ִ����Щ�������ͻ������Ϸ��
 * ֻ���ڰ���˿����Ϸ��ȡ��ʤ��ʱ�ŷ��� true�����򷵻� false ������������Ҷ������״̬������Ϸ��
 * 
 * */

public class LC1025_DivisorGame {
	
	/**
	 * ˼·һ�������ݹ鷽��
	 * ˭����Ҫѡ1��Ҳ���޷�ѡ�ˣ�Ҳ���ݹ����������n�����1��
	 * ��ʱ����ݹ���Ϊ����˿�㣬����˿�䣬����Ӯ����ͨ���ݹ��������żʵ�֣�������NΪ1�㣬����˿��ѡ������˿ѡ�Ĳ�Ϊ�����㣩
	 * �����һ�ְ���˿��Ӯ�ķ�������÷�������Ҫ��֤���ǣ�
	 *     1���ֵ�����ѡ�Ĳ����棬���еĵݹ鷵��ֵ��Ϊtrue��Ҳ�����ϵ��
	 *     2������˿����ֻҪ��һ��true������˿ѡ���ɣ�Ҳ�����ϵ��
	 *     
	 * ʵ�ʲ��ԣ�ͨ��29/40���������������ֵݹ���ָ��������΢������ͻᳬʱ
	 * */
	
	public boolean dg(int N,int deep) {
		if(N==1) {//����Ҷ�ӽڵ�
			return deep%2==0?true:false;//1��ż������Ӯ
		}else {//��Ҷ�ӽڵ���ݹ���������
			int num = (int)Math.sqrt(N);
			boolean result = false;
			if(deep%2==1) {//����˿�������㣬��һ��true����
				result = false;
				for(int i=1;i<=num;i++) {
					if(N%i==0) {
						result = result||dg(N-i,deep+1);
					}
				}
			}else {//���ֲ㣬���н����Ϊtrue�����ܷ���true;
				result = true;
				for(int i=1;i<=num;i++) {
					if(N%i==0) {
						result = result&&dg(N-i,deep+1);
					}
				}
			}
			return result;
		}
	}
	
	/**
	 * ˼·���� �Ľ�����һ�����仯���������Ѿ�������Ľ����¼���������N��
	 * ��ʼһ��Nƽ������С�����飬�����ʼΪ����δ��ʼ����ֵ������true��1��ʾ��false��0��ʾ��-1��ʾδ��ʼ��
	 * �ݹ�֮ǰ�ȼ������������˿�õ��ѳ�ʼ����ֵ���������������¼�Ľ������������õ����򷵻ؼ�¼���෴��
	 * ʵ�ʲ��ԣ�ͨ�����в�������
	 * */
	public int flag[];
	public boolean dg_imp(int N,int deep) {
		if(N==1) {//����Ҷ�ӽڵ�
			return deep%2==0?true:false;//1��ż������Ӯ
		}else {//��Ҷ�ӽڵ���ݹ���������
			int num = (int)Math.sqrt(N);
			boolean result = false;
			if(deep%2==1) {//����˿�������㣬��һ��true����
				result = false;
				for(int i=1;i<=num;i++) {
					if(N%i==0) {
						if(flag[N-i]<0) {
							flag[N-i] = dg_imp(N-i,deep+1)?1:0;
						}
						result = result||(flag[N-i]==1?true:false);
					}
				}
			}else {//���ֲ㣬���н����Ϊtrue�����ܷ���true;
				result = true;
				for(int i=1;i<=num;i++) {
					if(N%i==0) {
						if(flag[N-i]<0) {
							flag[N-i] = dg_imp(N-i,deep+1)?1:0;
						}
						result = result&&(flag[N-i]==1?true:false);
					}
				}
			}
			return result;
		}
	}
	/**
	 * ˼·�������������ϵĶ�̬�滮��һ���ȡ�Ķ����Ե��������
	 * ����DP���ԣ���һ������f��f[i]��ʾ�õ�i���������Ӯ
	 * f[1],f[2]������f[3]��ǰ����������ֱ���Ƴ�
	 * Ȼ����Ҫ���ľ���˳�������f[i]ʱ��f[1]��f[i-1]һ����֪
	 * ��ֻҪ����i��һ������x��ʹ��f[i-x]Ϊ�䣬��ô�õ�i������˾Ϳ���ѡx��ʹ����һ�����õ�����i-x������
	 * ��ʽ���Ǳ���i�����ӣ�ֻҪ���ھͰ�i����Ϊtrue�������ֻ����false
	 * */
	public boolean dp(int N) {
		boolean f[] = new boolean [N+2];//����N����1��ʱ��Խ��
		f[1] = false;f[2] = true;
		for(int i=3;i<=N;i++) {
			for(int j=1;j<=Math.sqrt(i);j++) {
				if(i%j==0&&f[i-j]==false) {//���ڿ��Ե��¶Է����ѡ��
					f[i] = true;break;
				}
			}
		}
		return f[N];
	}
	
	/**
	 * ˼·�ģ��ɽ�
	 * �õ�������һ���䣬ż����һ��Ӯ
	 * */
	public boolean xj(int N) {
		return N % 2 == 0;
	}
	
	public boolean divisorGame(int N) {
		flag = new int [N+1];
		for(int i=0;i<flag.length;i++) {
			flag[i] = -1;
		}
        return dg_imp(N,1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC1025_DivisorGame test = new LC1025_DivisorGame();
		System.out.println(test.divisorGame(1000));
	}

}
