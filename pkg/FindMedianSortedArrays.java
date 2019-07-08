package pkg;

public class FindMedianSortedArrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		int m = nums1.length, n = nums2.length;
		int i = 1, j = 1;
		int f1 = -1;			//当前寻找的是哪个数组
		int c = (m+n+1)/2;		//寻找的位置
		while(c>0) {			//走到中间那个数的位置
			if(i>m) {
				j++;
				c--;
				f1 = 0;			//剩余的是nums2
				continue;		//这里可以直接计算出来
			}
			if(j>n) {
				i++;
				c--;
				f1 = 1;			//剩余的是nums1
				continue;
			}
			if(i<=m&&j<=n) {
				if(nums1[i-1]<nums2[j-1]) {//两个数组都有数，往后移动指针
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
		double result = 0.0;//奇数取的值就是对的
		if(f1==1) {
			result = nums1[i-2];
			//System.out.println("1");
		}else {
			result = nums2[j-2];
			//System.out.println("2");
		}
		if((m+n)%2==0) {//偶数还得再往下累加一位
			if(i>m) {
				j++;
				f1 = 0;			//剩余的是nums2
			}else {
				if(j>n) {
					i++;
					c--;
					f1 = 1;			//剩余的是nums1
				}else {
					if(nums1[i-1]<nums2[j-1]) {//两个数组都有数，往后移动指针
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
