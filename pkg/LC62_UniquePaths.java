package pkg;

public class LC62_UniquePaths {
	
	/**
	 * 思路 动态规划，初始化边界为1，其它值取决于左侧和上侧两个值的和map[i][j] = map[i-1][j] + map[i][j-1];
	 * */
	public int uniquePaths(int m, int n) {
		if(m==0||n==0) return 0;
		int map[][] = new int[m][n];
		for(int i=0;i<n;i++) map[0][i] = 1;
		for(int j=0;j<m;j++) map[j][0] = 1;
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				map[i][j] = map[i-1][j] + map[i][j-1];
			}
		}
        return map[m-1][n-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC62_UniquePaths test = new LC62_UniquePaths();
		System.out.println(test.uniquePaths(3, 2));
		System.out.println(test.uniquePaths(7, 3));
	}

}
