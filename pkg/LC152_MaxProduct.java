package pkg;

public class LC152_MaxProduct {

	//˼·һ������DP���Ե����ϼ������������еĳ˻���o(n*n)
	public int maxProduct(int[] nums) {
		if(nums==null||nums.length==0) { return 0; }
		int len = nums.length;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<len;i++) {
			int pro = 1;
			for(int j=i;j<len;j++) {
				pro *= nums[j];
				max = pro>max?pro:max;
			}
		}
        return max;
    }
	/**
	 * ˼·�����������������ͣ���o��n��ʵ��������
	 * ������nums[i]Ϊ����������䣬�������ֵȡ����nums[i-1]����ʱ����ֵ��
	 * ���������֮ǰ�Ľ����ʹ�ý�������ô�����ϣ����ܵĻ����õ�ǰ�Ľ�����������
	 * ���nums[i]Ϊ��������ô���㵽nums[i-1]�����ֵ�ٳ������ֵ�������㵽nums[i]�����ֵ
	 * ���nums[i-1]Ϊ��������ô���㵽nums[i]�����ֵ������һ������Сֵ�ˣ�����Խ��С��Խ��
	 * ��max��min�������㵽��ǰ�����ֵ����Сֵ����ʼֵ��Ϊ1��1�����κ�����Ӱ�죬ÿ��ѭ����Ҫ����max��min��ֵ
	 * */
	public int maxProduct_dp(int[] nums) {
		int max = 1, min = 1, tmp , result = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<0) {
				tmp = max; max = min; min = tmp;
			}
			max = max*nums[i]>nums[i]?max*nums[i]:nums[i];
			min = min*nums[i]<nums[i]?min*nums[i]:nums[i];
			result = max >result?max:result;
		}
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC152_MaxProduct test = new LC152_MaxProduct();
		//System.out.println(test.maxProduct(new int[] {2,3,-2,4}));
		//System.out.println(test.maxProduct_dp(new int[] {2,3,-2,4}));
		System.out.println(test.maxProduct_dp(new int[] {-2,3,-4}));
	}

}
