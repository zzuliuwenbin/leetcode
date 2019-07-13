package pkg;
/**
 *  给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * */
import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		int index = 0;
		for(int i=0;i<nums.length;i++) {
			index = nums[i]>0?nums[i]-1:-nums[i]-1;
			if(nums[index]>0) {
				nums[index] = -nums[index];
			}
		}
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) {
				result.add(i+1);
			}
		}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindDisappearedNumbers test = new FindDisappearedNumbers();
		System.out.println(test.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
	}

}
