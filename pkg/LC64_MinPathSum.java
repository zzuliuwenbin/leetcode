package pkg;

/* *
 * ����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 * */
public class LC64_MinPathSum {

	/* *
	 * ˼·����̬�滮
	 * ��sum[i][j]��ʾ�ӵ�i,jλ�õ���Сֵ����ô���ֵһ�����Ը���sum[i-1][j]��sum[i][j-1]�ó�
	 * ���ƹ�ʽ��sum[i][j] = MIN(sum[i-1][j],sum[i][j-1])+grid[i][j]
	 * ��ʼ������һ��ֻ�ܴ����������ߣ���ʼ�ľ����ۼ�ǰ��ĺͣ���һ��ֻ�ܴ���������
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
