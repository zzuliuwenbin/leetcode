package pkg;

public class LC152_MaxProduct {

	//思路一：暴力DP，自底向上计算所有子序列的乘积，o(n*n)
	public int maxProduct(int[] nums) {
		if(nums==null||nums.length==0) { return 0; }
		int len = nums.length;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<len;i++) {
			int pro = 1;
			for(int j=i;j<len;j++) {
				pro *= nums[j];
				max = pro>max?pro:max;
			}
		}
        return max;
    }
	/**
	 * 思路二：类似于最大子序和，以o（n）实现求出结果
	 * 对于以nums[i]为结束点的区间，它的最大值取决于nums[i-1]结束时的最值，
	 * 如果连接上之前的结果能使得结果变大，那么连接上，不能的话就让当前的结果等于这个数
	 * 如果nums[i]为正数，那么运算到nums[i-1]的最大值再乘以这个值就是运算到nums[i]的最大值
	 * 如果nums[i-1]为负数，那么运算到nums[i]的最大值是用上一个的最小值乘，负数越“小”越大
	 * 用max和min保存运算到当前的最大值和最小值，初始值都为1，1乘以任何数不影响，每个循环都要更新max和min的值
	 * */
	public int maxProduct_dp(int[] nums) {
		int max = 1, min = 1, tmp , result = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<0) {
				tmp = max; max = min; min = tmp;
			}
			max = max*nums[i]>nums[i]?max*nums[i]:nums[i];
			min = min*nums[i]<nums[i]?min*nums[i]:nums[i];
			result = max >result?max:result;
		}
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC152_MaxProduct test = new LC152_MaxProduct();
		//System.out.println(test.maxProduct(new int[] {2,3,-2,4}));
		//System.out.println(test.maxProduct_dp(new int[] {2,3,-2,4}));
		System.out.println(test.maxProduct_dp(new int[] {-2,3,-4}));
	}

}
