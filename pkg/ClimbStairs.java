package pkg;
/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * */
public class ClimbStairs {
	//排列组合公式计算，如果可以优化到o(1)时间内计算出来组合数，算法应该还算挺快
	public int C(int a,int b) {
		long t1 = 1, t2 = 1;
		for(int i=b,j=1;i>b-a;i--) {
			t1 = t1*i;t2 = t2*j;j++;
			if(t1%t2==0) {//计算到结尾再求结果会溢出，用t1如果用int，在第43个测试用例时依旧溢出了
				t1 = t1/t2;
				t2 = 1;
			}
		}
		return (int)(t1/t2);
	}
	public int climbStairs(int n) {
		int sum = 0;
		for(int i=0;i<=n/2;i++) {
			if(i>(n-i)/2) {//利用组合公式的特点减少计算量
				sum = sum + C(n-2*i,n-i);
			}else {
				sum = sum + C(i,n-i);
			}
			
		}
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbStairs test = new ClimbStairs();
		System.out.println(test.climbStairs(44));
	}

}
