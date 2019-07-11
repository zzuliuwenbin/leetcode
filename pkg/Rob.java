package pkg;

/**
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
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
