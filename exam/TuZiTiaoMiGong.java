package exam;

import java.util.Scanner;

/**
 * ����һ��N*N���������������󻨵���Сʱ�䣬����ĳ������ϣ���ʱֻ���������·������ҷ��ĸ������д��ʱ�䣬Ҳ�����·������ҷ�����
 * �Ӿ������Ϸ����룬���·����������ܴӲ������
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
                throw new IllegalArgumentException("��������");
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
    	if(i>=TuZiTiaoMiGong.N) {//������
    		if(sum<TuZiTiaoMiGong.result) {
    			TuZiTiaoMiGong.result = sum;
    		}
    	}else {
    		if(j+2<TuZiTiaoMiGong.N) {//���ҿ���
    			if(sum+TuZiTiaoMiGong.ar[i][j+1]<TuZiTiaoMiGong.result) {
    				baoli(sum+TuZiTiaoMiGong.ar[i][j+1],i,j+2);//�����ҷ�ֵ
    			}
    		}
    		if(i+1<TuZiTiaoMiGong.N) {//���¿��У���������
    			if(sum+TuZiTiaoMiGong.ar[i+1][j]<TuZiTiaoMiGong.N) {
    				baoli(sum+TuZiTiaoMiGong.ar[i+1][j],i+2,j);
    			}
    		}else {//�ߵ��߽�����
    			if(sum<TuZiTiaoMiGong.result) {
    				TuZiTiaoMiGong.result = sum;
        		}
    		}
    	}
    }

    /** ������������������ʵ����ĿҪ��Ĺ��� **/
   /** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/
    private static int getMinimumTimeCost(int n, int[][] area) {
    	TuZiTiaoMiGong.N = n;
    	TuZiTiaoMiGong.ar = area;
    	//��̬�滮ʵ��,����
    	
    	//����
    	for(int i=0;i<n;i++) {
    		baoli(0,0,i);
    	}
    	return TuZiTiaoMiGong.result;
    }
}
