package pkg;

/**
 * 爱丽丝和鲍勃一起玩游戏,他们轮流行动。爱丽丝先手开局。
 * 最初，黑板上有一个数字N。在每个玩家的回合，玩家需要执行以下操作：
 * 选出任一x,满足0< x < N且N % x == 0。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * 只有在爱丽丝在游戏中取得胜利时才返回 true，否则返回 false 。假设两个玩家都以最佳状态参与游戏。
 * 
 * */

public class LC1025_DivisorGame {
	
	/**
	 * 思路一：暴力递归方案
	 * 谁遇到要选1，也就无法选了，也即递归结束条件：n变成了1；
	 * 此时如果递归层次为爱丽丝层，则爱丽丝输，否则赢（可通过递归参数的奇偶实现，设树根N为1层，爱丽丝先选，则爱丽丝选的层为奇数层）
	 * 如果有一种爱丽丝必赢的方案，则该方案中需要保证的是：
	 *     1、轮到鲍勃选的层里面，所有的递归返回值均为true（也即与关系）
	 *     2、爱丽丝层则只要有一个true供爱丽丝选即可（也即或关系）
	 *     
	 * 实际测试：通过29/40个测试用例，这种递归是指数级，稍微大点数就会超时
	 * */
	
	public boolean dg(int N,int deep) {
		if(N==1) {//到达叶子节点
			return deep%2==0?true:false;//1在偶数层则赢
		}else {//非叶子节点则递归所有因子
			int num = (int)Math.sqrt(N);
			boolean result = false;
			if(deep%2==1) {//爱丽丝在奇数层，有一个true即可
				result = false;
				for(int i=1;i<=num;i++) {
					if(N%i==0) {
						result = result||dg(N-i,deep+1);
					}
				}
			}else {//对手层，所有结果都为true，才能返回true;
				result = true;
				for(int i=1;i<=num;i++) {
					if(N%i==0) {
						result = result&&dg(N-i,deep+1);
					}
				}
			}
			return result;
		}
	}
	
	/**
	 * 思路二： 改进方案一，记忆化搜索，把已经运算过的结果记录下来，最多N个
	 * 初始一个N平方根大小的数组，数组初始为代表未初始化的值，比如true用1表示，false用0表示，-1表示未初始化
	 * 递归之前先检索，如果爱丽丝拿到已初始化的值，立即返回数组记录的结果，如果鲍勃拿到，则返回记录的相反数
	 * 实际测试：通过所有测试用例
	 * */
	public int flag[];
	public boolean dg_imp(int N,int deep) {
		if(N==1) {//到达叶子节点
			return deep%2==0?true:false;//1在偶数层则赢
		}else {//非叶子节点则递归所有因子
			int num = (int)Math.sqrt(N);
			boolean result = false;
			if(deep%2==1) {//爱丽丝在奇数层，有一个true即可
				result = false;
				for(int i=1;i<=num;i++) {
					if(N%i==0) {
						if(flag[N-i]<0) {
							flag[N-i] = dg_imp(N-i,deep+1)?1:0;
						}
						result = result||(flag[N-i]==1?true:false);
					}
				}
			}else {//对手层，所有结果都为true，才能返回true;
				result = true;
				for(int i=1;i<=num;i++) {
					if(N%i==0) {
						if(flag[N-i]<0) {
							flag[N-i] = dg_imp(N-i,deep+1)?1:0;
						}
						result = result&&(flag[N-i]==1?true:false);
					}
				}
			}
			return result;
		}
	}
	/**
	 * 思路三：常规意义上的动态规划，一般采取的都是自底向上填表
	 * 本题DP策略：设一个数组f，f[i]表示拿到i这个数的输赢
	 * f[1],f[2]，甚至f[3]等前几个都可以直接推出
	 * 然后需要做的就是顺序填表，填f[i]时，f[1]到f[i-1]一定已知
	 * 且只要存在i的一个因子x，使得f[i-x]为输，那么拿到i的这个人就可以选x，使得下一个人拿到的是i-x，必输
	 * 方式就是遍历i的因子，只要存在就把i设置为true，否则就只能是false
	 * */
	public boolean dp(int N) {
		boolean f[] = new boolean [N+2];//避免N等于1的时候越界
		f[1] = false;f[2] = true;
		for(int i=3;i<=N;i++) {
			for(int j=1;j<=Math.sqrt(i);j++) {
				if(i%j==0&&f[i-j]==false) {//存在可以导致对方输的选择
					f[i] = true;break;
				}
			}
		}
		return f[N];
	}
	
	/**
	 * 思路四：仙解
	 * 拿到奇数的一定输，偶数的一定赢
	 * */
	public boolean xj(int N) {
		return N % 2 == 0;
	}
	
	public boolean divisorGame(int N) {
		flag = new int [N+1];
		for(int i=0;i<flag.length;i++) {
			flag[i] = -1;
		}
        return dg_imp(N,1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC1025_DivisorGame test = new LC1025_DivisorGame();
		System.out.println(test.divisorGame(1000));
	}

}
