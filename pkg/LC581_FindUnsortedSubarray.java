package pkg;

/**
 * ����һ���������飬����ҪѰ��һ�������������飬���������������������������ô�������鶼���Ϊ��������
 * ���ҵ���������Ӧ����̵ģ���������ĳ��ȡ�
 * 
 * ˼·�����˷ֱ��ҿ��ܵı߽磬Ȼ���ҵ���Ҫ������������С���ֵ���ٻ��˱߽�
 * */
public class LC581_FindUnsortedSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int left = 0, right = nums.length,min,max;
		//�߽�����
		if(nums.length==0||nums.length==1) {
			return 0;
		}
		//�߽������������Լ�⵽���һ��Ԫ�أ��Ҳ���Լ�⵽left��ǰһ�������������һ����right-left+1,ԭʼ������Ҳ�ǶԵ�
		//Ѱ�����Ŀ��ܱ߽�
		for(int i=0;i<right-1;i++) {
			if(nums[i+1]<nums[i]) {
				left = i;//�����ܱ߽�
				break;
			}else {
				left = i+1;//������߽�
			}
		}
		//Ѱ���Ҳ�Ŀ��ܱ߽�
		for(int i=right-1;i>=left;i--) {
			if(nums[i-1]>nums[i]) {
				right = i;//�Ҳ���ܱ߽�
				break;
			}else {
				right = i-1;//�����ұ߽�
			}
		}
		
		//Ѱ����������ֵ
		min = nums[left];
		max = nums[left];
		for(int i=left;i<=right;i++) {
			min = nums[i]<min?nums[i]:min;
			max = nums[i]>max?nums[i]:max;
		}
		
		//������չ��Ԫ��ֵС�ڵ���min
		for(int i=left-1;i>=0;i--) {
			if(nums[i]<=min) {//����λ�ã���������ֱ��break
				break;
			}else {
				left = i;//����չ
			}
		}
		//������չ��Ԫ��ֵ���ڵ���max
		for(int i=right+1;i<nums.length;i++) {
			if(nums[i]>=max) {//����λ�ã���������ֱ��break
				break;
			}else {
				right = i;//����չ
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
