package pkg;


/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * */

public class LC338_CountBits {
	
	/**
	 * 思路一：常规遍历
	 * */
	public int[] countBits(int num) {
		int bnum [] = new int[num+1];
		for(int i=0;i<=num;i++) {
			int t = 1,n = 0;
			for(int j=0;j<31;j++) {
				if((i&t)>0) {
					n++;
				}
				t = t<<1;
			}
			bnum[i] = n;
		}
		return bnum;
    }
	
	/**
	 * 思路二：动态规划（填表），最高有效位
	 * 如果1到x的任意一个k填好了，那么k+2的n次方比前面的整好多一个1，可以利用以前的数直接加一获得
	 * 
	 * */
	public int[] countBits_dp(int num) {
		int bnum [] = new int[num+1];
		int i = 0;int b = 1;
		//[0,b)均计算出来了
		while(b<=num) {//需要等于，num整好等于b的时候，是在[b,2b)计算出来的
			//利用[0,b)计算[b,2b)，因为2b可能会超过num，所以判断的时候加一个条件
			while(i<b&&i+b<=num) {
				bnum[i+b] = bnum[i] + 1;
				i++;
			}
		}
		return bnum;
    }
	
	/**
	 * 思路三：动态规划（填表），最底有效位
	 * x的一的个数和x/2的一的个数只差最后一位，因为有俩x可以对应同一个x/2
	 * 这俩x和x/2相差的就在于x的最后一位是不是1
	 * */
	public int[] countBits_dp2(int num) {
		int bnum [] = new int[num+1];
		for(int i=1;i<=num;i++) {
			bnum[i] = bnum[i>>1]+(i&1);//把除二转换为移位操作(按位与优先级比较低)
		}
		return bnum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
