package pkg;

public class SingleNumber {
	
	public int singleNumber(int[] nums) {
		int a = nums[0];
        for(int i=1;i<nums.length;i++) {
        	a = a^nums[i];
        }
        return a;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumber test = new SingleNumber();
		System.out.println(test.singleNumber(new int[]{4,1,2,1,2}));

	}

}
