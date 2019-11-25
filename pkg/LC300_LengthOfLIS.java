package pkg;

public class LC300_LengthOfLIS {
	
	
	/**
	 * ˼·����̬�滮���ռ临�Ӷ�o(n),ʱ�临�Ӷ�o(n*n)
	 * dp[i]��ʾ����iΪ�����յ�������������������
	 * (
	 *    ֮ǰ����dp[i]�ĺ���Ϊ[0,i]��������������е�ֵ,�����ᵼ�°�dp[i]��ǰ�Ľ���ۼӽ�ȥ�����ܺܺõ�����dp[i]���������ĸ�Ԫ��Ϊ�������
	 *    ��ʹ��¼����dp[i]�����ĸ�Ԫ��Ϊ�����㣬Ҳ�������ʵ�����ֵ������nums[i]�ó����õĽ�����������ʱ��Ϊû�м�¼��nums[i]Ϊ�������������������е�ֵ
	 * ��
	 * ��ôdp[i]��nums[i]��dp[0]��dp[i-1]�йأ���Ϊ0��i-1������Ԫ�ؿ�ѡ�ɲ�ѡ
	 * dp[i] = max(dp[0]+1&&nums[0]<nums[i],dp[1]+1&&nums[1]<nums[i],...,dp[i-1]+1&&nums[i-1]<nums[i])
	 * ��ʼֵdp[0] = 1;ÿ��ѭ���е�imax��ʼ��1��Ҳ��Ĭ������Ϊ�������ֻ�����Լ�
	 * ����۵㣺���imax��ʼ��Ϊ1������Ҫ�ж�nums[i]������nums[j]��ʱ��Ҳ��Ҫ����dp[i]�Ƿ����imax������imax
	 * */
	public int lengthOfLIS(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		int dp[] = new int[nums.length],max = 1;
		for(int i=0;i<nums.length;i++) {
			dp[i] = 1;//��ʼ��Ϊ��ǰ���ֵ
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j]&&dp[j]+1>dp[i]) {//�����������ڸ�������������
					dp[i] = dp[j]+1;
				}
			}
			max = dp[i]>max?dp[i]:max;
		}
		return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC300_LengthOfLIS test = new LC300_LengthOfLIS();
		System.out.println(test.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
		System.out.println(test.lengthOfLIS(new int[] {2,2}));
		System.out.println(test.lengthOfLIS(new int[] {1,2,1}));
		System.out.println(test.lengthOfLIS(new int[] {4,10,4,3,8,9}));
	}

}
