package exam;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
        String str [] = line.split(" ");
        int arr [] = new int[str.length];
        int num [] = new int[str.length];
        for(int i=0;i<str.length;i++){
        	num[i] = Integer.parseInt(str[i]);
            arr[i] = num[i];
        }
		Arrays.sort(num);
		int count = 0;
		int j = 0;
		for (int i = 0; i < str.length; i++) {
			if(arr[i] == num[j]){
				++count;
				++j;
			}
		}
		System.out.println(str.length-count);
	}
}
 