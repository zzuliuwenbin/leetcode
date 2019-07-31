package pkg;

public class MaxSubArray {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSubArray test = new MaxSubArray();
		System.out.println(test.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}

}
