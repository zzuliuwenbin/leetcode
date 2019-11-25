package pkg;

public class LC300_LengthOfLIS {
	
	
	/**
	 * 思路：动态规划，空间复杂度o(n),时间复杂度o(n*n)
	 * dp[i]表示，以i为区间终点的最大上升子序列数量
	 * (
	 *    之前假设dp[i]的含义为[0,i]的最大上升子序列的值,这样会导致把dp[i]以前的结果累加进去，不能很好的区分dp[i]究竟是以哪个元素为结束点的
	 *    即使记录下来dp[i]是以哪个元素为结束点，也会出现其实后面的值可以以nums[i]得出更好的结果的情况，此时因为没有记录以nums[i]为结束点的最大上升子序列的值
	 * ）
	 * 那么dp[i]和nums[i]、dp[0]到dp[i-1]有关，因为0到i-1的任意元素可选可不选
	 * dp[i] = max(dp[0]+1&&nums[0]<nums[i],dp[1]+1&&nums[1]<nums[i],...,dp[i-1]+1&&nums[i-1]<nums[i])
	 * 初始值dp[0] = 1;每轮循环中的imax初始化1，也即默认以它为结束点的只有它自己
	 * 错误观点：如果imax初始化为1，则还需要判断nums[i]不大于nums[j]的时候，也需要根据dp[i]是否大于imax来更新imax
	 * */
	public int lengthOfLIS(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		int dp[] = new int[nums.length],max = 1;
		for(int i=0;i<nums.length;i++) {
			dp[i] = 1;//初始化为当前最大值
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j]&&dp[j]+1>dp[i]) {//大于且有助于更新最后结果则更新
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
