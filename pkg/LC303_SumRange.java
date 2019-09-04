package pkg;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 题目假设执行多次调用,可采用缓存，二维数组缓存，或者一维数组缓存
 * */
public class LC303_SumRange {
	
	public int sum[];
	public int nums[];
	
	public LC303_SumRange(int nums[]) {
		this.nums = nums;
		this.sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
	}
	
    //直接求解
    public int sumRange_1(int i, int j) {
        int sum = 0;
    	while(i<=j) {
        	sum+=this.nums[i++];
        }
    	return sum;
    }
    //缓存求解，任意区间i,j的和等于sum[j]-sum[i-1]
    //sum初始化时向后错一位，免得i-1小于0，sum[0]设置为0，不影响计算
    public int sumRange_2(int i, int j) {
    	return sum[j + 1] - sum[i];
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
