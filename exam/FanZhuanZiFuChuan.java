package exam;

import java.util.Scanner;

/**
 * ����һ���ַ����������ڵ��ַ����з�ת��ʾ������((ab)cd)�����dcab
 * ��ʽ������������մ�
 * */
public class FanZhuanZiFuChuan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();   
        char s[] = new char[line.length()+1];//����ջ
        char t[] = new char[line.length()+1];//��ʱջ
        int i=0,j=0;
        int num = line.length();
        while(i<num) {//�ж��Ƿ���ϸ�ʽ������'('��һ������')'��һ����һ��ʱ��������������ʽ����
        	if(line.charAt(i)=='(') {
        		j++;
        	}
        	if(line.charAt(i)==')') {
        		if(j>0) {
        			j--;
        		}else {//��ʽ������
        			System.out.println("");
        			return;
        		}
        	}
        	i++;
        }
        if(j!=0) {//���ջ��������Ҳ�Ǹ�ʽ������
        	System.out.println("");
        	return;
        }
        i=0;j=0;//i��ʾԭ���ַ������ʵ���λ�ã�j��ʾ���ַ������ɵ�λ��
        int m=0,n=0,k=0;//m,n,k������ת�ַ�
        while(i<num) {
        	if(line.charAt(i)!=')') {//����Ҫ��ת��ʱ��ֱ�ӽ�ջ��'('Ҳ��ջ��
        		s[j++] = line.charAt(i);
        	}else {//��Ҫ��ת
        		m = j; n = 0;
        		while(true) {
        			m--;//ָ��ջ��Ԫ��
        			if(s[m]!='(') {//��ת��ʼ��
        				t[n++] = s[m];//��ת
        			}else {
        				break;
        			}
        		}
        		k=0;
        		while(k<n) {//�Ż�s��
        			s[m++] = t[k++];//s�е�'('�����︲�ǵ���
        		}
        		j--;//ȥ����һ��'('��j����һ��
        	}
        	i++;
        }
        k=j;
        while(k<=num) {
        	s[k++] = 0;
        }
        String out = new String(s);
        System.out.println(out);
        return;
	}

}
