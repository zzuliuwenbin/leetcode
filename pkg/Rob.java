package pkg;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * */
public class Rob {

	/*
	 * f(n) = max(a[n]+f(n-2),f(n-1))
	 * f(1) = a[1]
	 * f(2) = max(a[1],a[2])
	 * */
	public int rob(int[] nums) {
		if(nums.length<=1) {
			return nums.length == 0?0:nums[0];
		}
		int len = nums.length;
		int f[] = new int[len];
		f[0] = nums[0];f[1] = nums[0]>nums[1]?nums[0]:nums[1];
		for(int i=2;i<len;i++) {
			f[i] = nums[i]+f[i-2]>f[i-1]?nums[i]+f[i-2]:f[i-1];
		}
        return f[len-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rob test = new Rob();
		System.out.println(test.rob(new int[]{1,2,3,4}));
	}

}
