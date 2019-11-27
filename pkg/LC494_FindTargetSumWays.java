package pkg;

/**
 * ����һ���Ǹ���������a1, a2, ...,an,��һ��Ŀ����,S������������������+��-�����������е�����һ���������㶼���Դ�+��-��ѡ��һ�����������ǰ�档
 * ���ؿ���ʹ���������ΪĿ����S��������ӷ��ŵķ�������
 * */
public class LC494_FindTargetSumWays {
	/**
	 * ˼·����̬�滮
	 * ��sum[n][S]��ʾ�����������ΪĿ����S��������ӷ��ŵķ�����
	 * ��ôsum[n][S] = sum[n-1][S+a[n]]+sum[n-1][S-a[n]]+sum[n][S]���ӷ����������Լ�ԭ�е�������
	 * ��ô���������һ�е�ֵ�ͳ�ʼ���ڵ�һ����������ֵλ�ã�����ĵ�һάS��ʾ�ͣ���ô������-1000��+1000�������鶨λΪ2001��С�����±�1000��Ϊ0
	 * ÿһ�б�ʾʹ���ϸ����ֺ����ʹ�ý����Ϊ������������ǰ����д��һ��
	 * 
	 * */
	public int findTargetSumWays(int[] nums, int S) {
		if(nums==null||nums.length==0||S>1000||S<-1000) {
			return 0;
		}
		int num = nums[0];
		int sum[][] = new int[nums.length][2001];
		sum[0][1000+num] ++;
		sum[0][1000-num] ++;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=0;j<2001;j++) {
				if(sum[i][j]!=0) {//�Ͳ�Ϊ��ĵط��ſ��ܵõ���һ����
					//��ǰ�ĺ���j-1000�������ǣ�+sums[i+1]����-sum[i+1]����Ϊj-1000+sums[i+1]���Լ�j-1000-sums[i+1]
					//��Ϊ��ƫ�ƴ��ڣ���ôʵ�ʲ�����������j-1000+sums[i+1]+1000��j-1000-sums[i+1]+1000
					sum[i+1][j+nums[i+1]] += sum[i][j];//�ӷ��õ����,��ԭ�еĻ��������ӵõ�sum[i][j]�ķ�������
					sum[i+1][j-nums[i+1]] += sum[i][j];//�����õ����
				}
			}
		}
        return sum[nums.length-1][S+1000];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC494_FindTargetSumWays test = new LC494_FindTargetSumWays();
		System.out.println(test.findTargetSumWays(new int[] {0,0,0,0,0,0,0,0,1}, 1));
	}

}
