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
        //ͳ���ַ�����
        for(int i=0;i<line.length();i++) {
        	ch = line.charAt(i);
        	num[ch-'0']++;
        }
        //��ʼ�޳�
        for(int i=0;i<line.length();i++) {
        	ch = line.charAt(i);
        	if(num[ch-'0']>1) {//����1����ǰ����û�и�С����
        		boolean f = false;
        		for(int j=ch-'0'-1;j>=0;j--) {
        			if(num[j]>0) {
        				f = true;
        			}
        		}
        		if(f) {//�и�С�ģ��������
        			num[ch-'0']--;
        			flag[i] = false;
        		}else {//ֻ���������
        			num[ch-'0'] = 0;//�Ժ�������
        		}
        	}else if(num[ch-'0']==0){//0��ֱ������
        		flag[i] = false;
        	}//ֻ��һ��ֻ��Ĭ�Ϸ�����
        }
        String result = "";
        for(int i=0;i<len;i++) {
        	if(flag[i]){
        		result = result+line.charAt(i);
        	}
        }
        //z��¼��һ�������λ��
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
