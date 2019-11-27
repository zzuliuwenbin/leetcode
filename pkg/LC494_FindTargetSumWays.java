package pkg;

/**
 * 给定一个非负整数数组a1, a2, ...,an,和一个目标数,S。现在你有两个符号+和-。对于数组中的任意一个整数，你都可以从+或-中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数S的所有添加符号的方法数。
 * */
public class LC494_FindTargetSumWays {
	/**
	 * 思路：动态规划
	 * 设sum[n][S]表示，最终数组和为目标数S的所有添加符号的方法数
	 * 那么sum[n][S] = sum[n-1][S+a[n]]+sum[n-1][S-a[n]]+sum[n][S]（加法，减法，以及原有的数量）
	 * 那么按行填表，第一行的值就初始化在第一个数的正负值位置，数组的第一维S表示和，那么本题是-1000到+1000，则数组定位为2001大小，以下标1000作为0
	 * 每一行表示使用上该数字后可以使得结果变为的数，遍历当前行填写下一行
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
				if(sum[i][j]!=0) {//和不为零的地方才可能得到下一个和
					//当前的和是j-1000，操作是：+sums[i+1]或者-sum[i+1]，和为j-1000+sums[i+1]，以及j-1000-sums[i+1]
					//因为有偏移存在，那么实际操作的索引是j-1000+sums[i+1]+1000，j-1000-sums[i+1]+1000
					sum[i+1][j+nums[i+1]] += sum[i][j];//加法得到结果,在原有的基础上增加得到sum[i][j]的方法数量
					sum[i+1][j-nums[i+1]] += sum[i][j];//减法得到结果
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
