package pkg;

public class FindMedianSortedArrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		int m = nums1.length, n = nums2.length;
		int i = 1, j = 1;
		int f1 = -1;			//��ǰѰ�ҵ����ĸ�����
		int c = (m+n+1)/2;		//Ѱ�ҵ�λ��
		while(c>0) {			//�ߵ��м��Ǹ�����λ��
			if(i>m) {
				j++;
				c--;
				f1 = 0;			//ʣ�����nums2
				continue;		//�������ֱ�Ӽ������
			}
			if(j>n) {
				i++;
				c--;
				f1 = 1;			//ʣ�����nums1
				continue;
			}
			if(i<=m&&j<=n) {
				if(nums1[i-1]<nums2[j-1]) {//�������鶼�����������ƶ�ָ��
					i++;
					c--;
					f1 = 1;
				}else {
					j++;
					c--;
					f1 = 0;
				}
			}
		}
		//System.out.printf("%d,%d\n",i,j);
		double result = 0.0;//����ȡ��ֵ���ǶԵ�
		if(f1==1) {
			result = nums1[i-2];
			//System.out.println("1");
		}else {
			result = nums2[j-2];
			//System.out.println("2");
		}
		if((m+n)%2==0) {//ż�������������ۼ�һλ
			if(i>m) {
				j++;
				f1 = 0;			//ʣ�����nums2
			}else {
				if(j>n) {
					i++;
					c--;
					f1 = 1;			//ʣ�����nums1
				}else {
					if(nums1[i-1]<nums2[j-1]) {//�������鶼�����������ƶ�ָ��
						i++;
						f1 = 1;
					}else {
						j++;
						f1 = 0;
					}
				}
			}
			if(f1==1) {
				result = (result+nums1[i-2])/2;
				//System.out.println("3");
			}else {
				result = (result+nums2[j-2])/2;
				//System.out.println("4");
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = {};
		int nums2[] = {2,3};
		FindMedianSortedArrays test = new FindMedianSortedArrays();
		System.out.println(test.findMedianSortedArrays(nums1, nums2));
	}

}
