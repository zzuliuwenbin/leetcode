package pkg;

/**
 * ����һ����������  nums�������������� i �� j  (i �� j) ��Χ��Ԫ�ص��ܺͣ����� i,  j ���㡣
 * ��Ŀ����ִ�ж�ε���,�ɲ��û��棬��ά���黺�棬����һά���黺��
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
	
    //ֱ�����
    public int sumRange_1(int i, int j) {
        int sum = 0;
    	while(i<=j) {
        	sum+=this.nums[i++];
        }
    	return sum;
    }
    //������⣬��������i,j�ĺ͵���sum[j]-sum[i-1]
    //sum��ʼ��ʱ����һλ�����i-1С��0��sum[0]����Ϊ0����Ӱ�����
    public int sumRange_2(int i, int j) {
    	return sum[j + 1] - sum[i];
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
