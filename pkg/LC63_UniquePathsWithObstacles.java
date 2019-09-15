package pkg;

/**
 * һ��m*n�ķ�����������ϰ�������Ͻ��ߵ����½��ж������߷���ֻ�����һ��������ߣ������ϰ���ĵط�������
 * */
public class LC63_UniquePathsWithObstacles {
	
	/**
	 * ˼·����̬�滮��map[i][j] = map[i-1][j] + map[i][j-1];�����ϰ�������⴦����һ�л��һ�������ϰ��������Ϊ0������Ϊ1
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
					map[i][j] = 0;//����Ϊ����ú����ۼ�ʱ��Ҫ�ж�
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
