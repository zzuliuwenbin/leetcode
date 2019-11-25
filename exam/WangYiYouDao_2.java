package exam;

import java.util.Scanner;
public class WangYiYouDao_2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine());//数据组数
		for(int i=0;i<t;i++) {
			long A = scanner.nextInt();
			long B = scanner.nextInt();
			long p = scanner.nextInt();
			long q = scanner.nextInt();
			scanner.nextLine();
			int n = 0;
			while(A<B) {
				if(A+p>=B) {
					A = A + p;
				}else {
					p = p*q;
				}
				n++;
			}
			System.out.println(n);
		}
	}
}