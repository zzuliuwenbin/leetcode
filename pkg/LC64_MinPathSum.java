package pkg;

/* *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * */
public class LC64_MinPathSum {

	/* *
	 * 思路：动态规划
	 * 设sum[i][j]表示加到i,j位置的最小值，那么这个值一定可以根据sum[i-1][j]和sum[i][j-1]得出
	 * 递推公式：sum[i][j] = MIN(sum[i-1][j],sum[i][j-1])+grid[i][j]
	 * 初始化：第一行只能从左向右行走，初始的就是累加前面的和，第一列只能从上向下走
	 * 
	 * */
	public int minPathSum(int[][] grid) {
		if(grid==null||grid.length==0||grid[0].length==0) {
			return Integer.MAX_VALUE;
		}
		int m = grid.length;
		int n = grid[0].length;
		int sum[][] = new int[m][n];
		sum[0][0] = grid[0][0];
		for(int i=1;i<n;i++) {
			sum[0][i] = sum[0][i-1] + grid[0][i];
		}
		for(int j=1;j<m;j++) {
			sum[j][0] = sum[j-1][0] + grid[j][0];
		}
		for(int j=1;j<m;j++) {
			for(int i=1;i<n;i++) {
				sum[j][i] = Math.min(sum[j][i-1], sum[j-1][i]) + grid[j][i];
			}
		}
        return sum[m-1][n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC64_MinPathSum test = new LC64_MinPathSum();
		System.out.println(test.minPathSum(new int[][] {{1,2,5},{3,2,1}} ));
	}

}
