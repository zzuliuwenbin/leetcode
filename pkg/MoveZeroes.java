package pkg;

/**
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 * */
public class MoveZeroes {

	/*public void moveZeroes(int[] nums) {
		if(nums.length<=1) {
			return;
		}
		int i=0,j=0;
		while(i<nums.length&&nums[i++]!=0);i--;j=i;  		//i��־��һ��Ϊ0��λ��
		if(i==nums.length-1&&nums[i]!=0) {
			return;
		}
		while(j<nums.length&&nums[j++]==0);j--;    			//j��־��һ����Ϊ0��λ��
		while(j<nums.length) {
			if(nums[j]!=0) {
				nums[i] = nums[j];
				nums[j] = 0;
				while(nums[i++]!=0) {
					if(i>=nums.length) {
						break;
					}
				};
				i--;//�ҵ���һ��Ϊ0��λ��
			}
			j++;
		}
		
    }*/
	
	//�������㷨
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
