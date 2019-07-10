package pkg;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * */
public class MoveZeroes {

	/*public void moveZeroes(int[] nums) {
		if(nums.length<=1) {
			return;
		}
		int i=0,j=0;
		while(i<nums.length&&nums[i++]!=0);i--;j=i;  		//i标志第一个为0的位置
		if(i==nums.length-1&&nums[i]!=0) {
			return;
		}
		while(j<nums.length&&nums[j++]==0);j--;    			//j标志第一个不为0的位置
		while(j<nums.length) {
			if(nums[j]!=0) {
				nums[i] = nums[j];
				nums[j] = 0;
				while(nums[i++]!=0) {
					if(i>=nums.length) {
						break;
					}
				};
				i--;//找到下一个为0的位置
			}
			j++;
		}
		
    }*/
	
	//精简后的算法
	public void moveZeroes(int[] nums) {
		int i=0,j=0;
		while(j<nums.length) {
			if(nums[j]!=0) {
				nums[i++] = nums[j];
			}
			j++;
		}
		while(i<nums.length) nums[i++] = 0;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveZeroes test = new MoveZeroes();
		int nums[] = new int[]{1,2,3,0,4};
		test.moveZeroes(nums);
		for(int i=0;i<nums.length;i++) {
			System.out.println(nums[i]);
		}
	}

}
