package exam;

import java.util.Scanner;

/**
 * 给定一个N*N矩阵，兔子跳过矩阵花的最小时间，踩在某个格格上，耗时只能是它的下方或者右方的格格内填写的时间，也即从下方或者右方跳过
 * 从矩阵最上方进入，最下方出来，不能从侧面出来
 * */
public class TuZiTiaoMiGong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }
    
    public static int N;
    public static int [][] ar;
    public static int result = 1000000000;
    private static void baoli(int sum,int i,int j) {
    	if(i>=TuZiTiaoMiGong.N) {//出来了
    		if(sum<TuZiTiaoMiGong.result) {
    			TuZiTiaoMiGong.result = sum;
    		}
    	}else {
    		if(j+2<TuZiTiaoMiGong.N) {//往右可行
    			if(sum+TuZiTiaoMiGong.ar[i][j+1]<TuZiTiaoMiGong.result) {
    				baoli(sum+TuZiTiaoMiGong.ar[i][j+1],i,j+2);//加上右方值
    			}
    		}
    		if(i+1<TuZiTiaoMiGong.N) {//向下可行，继续向下
    			if(sum+TuZiTiaoMiGong.ar[i+1][j]<TuZiTiaoMiGong.N) {
    				baoli(sum+TuZiTiaoMiGong.ar[i+1][j],i+2,j);
    			}
    		}else {//走到边界上了
    			if(sum<TuZiTiaoMiGong.result) {
    				TuZiTiaoMiGong.result = sum;
        		}
    		}
    	}
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
   /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int getMinimumTimeCost(int n, int[][] area) {
    	TuZiTiaoMiGong.N = n;
    	TuZiTiaoMiGong.ar = area;
    	//动态规划实现,不会
    	
    	//暴力
    	for(int i=0;i<n;i++) {
    		baoli(0,0,i);
    	}
    	return TuZiTiaoMiGong.result;
    }
}
