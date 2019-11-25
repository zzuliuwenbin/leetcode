package exam;

import java.util.HashMap;
import java.util.Scanner;
public class WangYiYouDao_1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();
        String str [] = scanner.nextLine().split(" ");
        HashMap<String,Integer> map = new HashMap<String,Integer>((int)(str.length*1.2));
        int t=0;
        for(int i=0;i<str.length;i++) {
        	if(map.containsKey(str[i])) {
        		t = map.get(str[i]);
        		map.put(str[i], t+1);
        	}else {
        		map.put(str[i], 1);
        	}
        }
        String line;
        for(int i=0;i<m;i++) {
        	line = scanner.nextLine();
        	if(map.containsKey(line)) {
        		System.out.println(map.get(line));
        	}else {
        		System.out.println(0);
        	}
        	
        }
	}
}
