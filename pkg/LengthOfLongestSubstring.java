package pkg;

import java.util.HashSet;


public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if(s.length()<=1) {
			return s.length();
		}
		int t1 = 0;//当前开始计数位置，如果有重复的，从此处开始移除hash中的字符，直到遇到相同的值
		int len = 0;
		int tag = 0;
		char ch = 0;
		HashSet<Character> sub = new HashSet<Character>();
		sub.add(s.charAt(0));
		for(int i=1;i<s.length();i++) {
			if(sub.contains(s.charAt(i))) {	//最长子串中包含该字符
				tag = 1;
				if(i-t1>len) {				//更新最长子串长度
					len = i-t1;
				}
				//从t1到该字符的串都移除，等于的不移除，移除还得再添加进来
				ch = s.charAt(i);
				while(s.charAt(t1)!=ch) {
					sub.remove(s.charAt(t1));
					t1++;
				}
				t1++;//跳过相等的这个字符，从下一个开始计数
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
