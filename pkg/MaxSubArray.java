package pkg;

public class MaxSubArray {
	
	
	/* *
	 * ˼·����ͷ��ʼ��sum[i]��¼��Ϊ����������ֵ
	 * ��ôsum[i]ȡ����sum[i-1]�����sum[i-1]����0��ô��sum[i]����й���
	 * ���С��0��Ҳ��û�б�Ҫ���������ۼ���ȥ�ˣ���Ϊ�ۼ���ȥֻ��ʹ�ý����С
	 * ���������ʱ�临�Ӷ�o(2n)���ռ临�Ӷ�Ϊo(n)
	 * */
	public int maxSubArray(int[] nums) {
		int sum[] = new int[nums.length];
		sum[0] = nums[0];
		for(int i=1;i<nums.length;i++) {
			if(sum[i-1]>0){//sum[i-1]+nums[i]>nums[i]
				sum[i] = sum[i-1]+nums[i];
			}else {
				sum[i] = nums[i];
			}
		}
		for(int j=1;j<sum.length;j++) {
			if(sum[j]>sum[0]) {
				sum[0] = sum[j];
			}
		}
		return sum[0]; 
    }
	
	/* *
	 * һ�������ʱ�临�Ӷ�o(n),�ռ临�Ӷ�o(1)
	 * */
	public int maxSubArray_dp(int[] nums) {
		int max = nums[0];
		int sum = nums[0];
		for(int i=1;i<nums.length;i++) {
			sum = sum>0?sum+nums[i]:nums[i];
			max = sum>max?sum:max;
		}
		return max; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSubArray test = new MaxSubArray();
		System.out.println(test.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(test.maxSubArray_dp(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}

}
