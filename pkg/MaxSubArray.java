package pkg;

public class MaxSubArray {
	
	
	/* *
	 * 思路：从头开始，sum[i]记录以为结束点的最大值
	 * 那么sum[i]取决于sum[i-1]，如果sum[i-1]大于0那么对sum[i]结果有贡献
	 * 如果小于0，也就没有必要把这个结果累加上去了，因为累加上去只能使得结果更小
	 * 两遍遍历，时间复杂度o(2n)，空间复杂度为o(n)
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
	 * 一遍遍历，时间复杂度o(n),空间复杂度o(1)
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
