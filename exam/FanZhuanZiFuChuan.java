package exam;

import java.util.Scanner;

/**
 * 输入一行字符串，括号内的字符进行翻转，示例输入((ab)cd)，输出dcab
 * 格式不符合则输出空串
 * */
public class FanZhuanZiFuChuan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();   
        char s[] = new char[line.length()+1];//运算栈
        char t[] = new char[line.length()+1];//临时栈
        int i=0,j=0;
        int num = line.length();
        while(i<num) {//判断是否符合格式，遇到'('加一，遇到')'减一，减一的时候如果不够减则格式错误
        	if(line.charAt(i)=='(') {
        		j++;
        	}
        	if(line.charAt(i)==')') {
        		if(j>0) {
        			j--;
        		}else {//格式不符合
        			System.out.println("");
        			return;
        		}
        	}
        	i++;
        }
        if(j!=0) {//最后“栈”不空则也是格式不符合
        	System.out.println("");
        	return;
        }
        i=0;j=0;//i表示原先字符串访问到的位置，j表示新字符串生成的位置
        int m=0,n=0,k=0;//m,n,k用来周转字符
        while(i<num) {
        	if(line.charAt(i)!=')') {//不需要翻转的时候直接进栈，'('也进栈了
        		s[j++] = line.charAt(i);
        	}else {//需要翻转
        		m = j; n = 0;
        		while(true) {
        			m--;//指向栈顶元素
        			if(s[m]!='(') {//翻转开始点
        				t[n++] = s[m];//翻转
        			}else {
        				break;
        			}
        		}
        		k=0;
        		while(k<n) {//放回s中
        			s[m++] = t[k++];//s中的'('在这里覆盖掉了
        		}
        		j--;//去掉了一个'('，j回退一个
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
