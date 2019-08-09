package pkg;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * 
 * 思路：两端分别找可能的边界，然后找到需要排序的区间的最小最大值，再回退边界
 * */
public class LC581_FindUnsortedSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int left = 0, right = nums.length,min,max;
		//边界条件
		if(nums.length==0||nums.length==1) {
			return 0;
		}
		//边界条件，左侧可以检测到最后一个元素，右侧可以检测到left的前一个，这样结果就一定是right-left+1,原始就升序也是对的
		//寻找左侧的可能边界
		for(int i=0;i<right-1;i++) {
			if(nums[i+1]<nums[i]) {
				left = i;//左侧可能边界
				break;
			}else {
				left = i+1;//更新左边界
			}
		}
		//寻找右侧的可能边界
		for(int i=right-1;i>=left;i--) {
			if(nums[i-1]>nums[i]) {
				right = i;//右侧可能边界
				break;
			}else {
				right = i-1;//更新右边界
			}
		}
		
		//寻找区间内最值
		min = nums[left];
		max = nums[left];
		for(int i=left;i<=right;i++) {
			min = nums[i]<min?nums[i]:min;
			max = nums[i]>max?nums[i]:max;
		}
		
		//向左扩展到元素值小于等于min
		for(int i=left-1;i>=0;i--) {
			if(nums[i]<=min) {//结束位置，不包含，直接break
				break;
			}else {
				left = i;//左扩展
			}
		}
		//向右扩展到元素值大于等于max
		for(int i=right+1;i<nums.length;i++) {
			if(nums[i]>=max) {//结束位置，不包含，直接break
				break;
			}else {
				right = i;//右扩展
			}
		}
		
		return right-left+1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC581_FindUnsortedSubarray test = new LC581_FindUnsortedSubarray();
		System.out.println(test.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
	}

}
