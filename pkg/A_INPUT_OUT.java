package pkg;

import java.util.Scanner;
//public class Main {
public class A_INPUT_OUT {
    private static Scanner in;

	public static void main(String[] args) {
        in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case              
        	int a = in.nextInt();
        	int b = in.nextInt();
            System.out.println(a + b);
        }
        
        
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
    }
	
}
