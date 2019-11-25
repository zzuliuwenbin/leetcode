package exam;

import java.util.Scanner;
public class WangYi_3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine());//数据组数
		for(int i=0;i<t;i++) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			scanner.nextLine();
			int h[] = new int[n+1];
			h[n] = -1;
			int j = 0;
			while (j<n) {        
	        	h [j++]= scanner.nextInt();
	        }
			scanner.nextLine();
			int flag = 1;
			j = 0;
			while(j<n) {
				if(h[j+1]<=h[j]) {
					j++;
				}else {
					if(flag==1) {
						j = j+k;
						flag = 0;
					}else {
						break;
					}
				}
			}
			if(j>=n) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
		
	}
}