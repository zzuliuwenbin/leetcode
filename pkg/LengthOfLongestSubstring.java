package pkg;

import java.util.HashSet;


public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if(s.length()<=1) {
			return s.length();
		}
		int t1 = 0;//��ǰ��ʼ����λ�ã�������ظ��ģ��Ӵ˴���ʼ�Ƴ�hash�е��ַ���ֱ��������ͬ��ֵ
		int len = 0;
		int tag = 0;
		char ch = 0;
		HashSet<Character> sub = new HashSet<Character>();
		sub.add(s.charAt(0));
		for(int i=1;i<s.length();i++) {
			if(sub.contains(s.charAt(i))) {	//��Ӵ��а������ַ�
				tag = 1;
				if(i-t1>len) {				//������Ӵ�����
					len = i-t1;
				}
				//��t1�����ַ��Ĵ����Ƴ������ڵĲ��Ƴ����Ƴ���������ӽ���
				ch = s.charAt(i);
				while(s.charAt(t1)!=ch) {
					sub.remove(s.charAt(t1));
					t1++;
				}
				t1++;//������ȵ�����ַ�������һ����ʼ����
			}else {
				sub.add(s.charAt(i));
			}
		}
		if(tag == 0) {
			len = s.length();
		}
		if(sub.size()>len) {
			len = sub.size();
		}
		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthOfLongestSubstring test = new LengthOfLongestSubstring();
		System.out.println(test.lengthOfLongestSubstring("aab"));
	}

}
