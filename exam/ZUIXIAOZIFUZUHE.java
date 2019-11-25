package exam;

import java.util.Scanner;

public class ZUIXIAOZIFUZUHE {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int len = line.length();
        int num[] = new int[10];
        boolean flag[] = new boolean[line.length()];
        char ch = 0;
        for(int i=0;i<len;i++) {
        	flag[i] = true;
        }
        //统计字符数量
        for(int i=0;i<line.length();i++) {
        	ch = line.charAt(i);
        	num[ch-'0']++;
        }
        //开始剔除
        for(int i=0;i<line.length();i++) {
        	ch = line.charAt(i);
        	if(num[ch-'0']>1) {//大于1找找前面有没有更小的了
        		boolean f = false;
        		for(int j=ch-'0'-1;j>=0;j--) {
        			if(num[j]>0) {
        				f = true;
        			}
        		}
        		if(f) {//有更小的，则不用这个
        			num[ch-'0']--;
        			flag[i] = false;
        		}else {//只能用这个了
        			num[ch-'0'] = 0;//以后不再用了
        		}
        	}else if(num[ch-'0']==0){//0的直接跳过
        		flag[i] = false;
        	}//只有一个只能默认放这了
        }
        String result = "";
        for(int i=0;i<len;i++) {
        	if(flag[i]){
        		result = result+line.charAt(i);
        	}
        }
        //z记录第一个非零的位置
        int z = 0;
        for(int i=0;i<result.length();i++) {
        	if(result.charAt(i)=='0'){
        		z++;
        	}else {
        		break;
        	}
        }
        System.out.println(result.substring(z));
        scanner.close();
    }
}
