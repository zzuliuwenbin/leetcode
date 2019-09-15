package pkg;

/**
 * 一个m*n的方格，里面存在障碍物，从左上角走到右下角有多少种走法（只能向右或者向下走），有障碍物的地方不能走
 * */
public class LC63_UniquePathsWithObstacles {
	
	/**
	 * 思路：动态规划，map[i][j] = map[i-1][j] + map[i][j-1];，有障碍物的特殊处理，第一行或第一列遇到障碍物后，设置为0，其它为1
	 * */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0][0]==1) return 0;
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int map[][] = new int[m][n];
		
		int i=1;
		while(i<n&&obstacleGrid[0][i]==0) map[0][i++] = 1;
		int j=0;
		while(j<m&&obstacleGrid[j][0]==0) map[j++][0] = 1;
		
		for(i=1;i<m;i++) {
			for(j=1;j<n;j++) {
				if(obstacleGrid[i][j]==1) {
					map[i][j] = 0;//设置为零免得后面累加时需要判断
				}else {
					map[i][j] = map[i-1][j] + map[i][j-1];
				}
			}
		}
		return map[m-1][n-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC63_UniquePathsWithObstacles test = new LC63_UniquePathsWithObstacles();
		System.out.println(test.uniquePathsWithObstacles(new int[][] {{0,0,0},{0,1,0},{0,0,0}}));
	}

}
