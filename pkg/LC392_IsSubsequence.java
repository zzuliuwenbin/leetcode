package pkg;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * */
public class LC392_IsSubsequence {

	public boolean isSubsequence(String s, String t) {
		int j=0;
		for(int i=0;i<t.length();i++) {
			if(j>=s.length()) {
				break;
			}
			if(t.charAt(i)==s.charAt(j)) {
				j++;
			}
		}
		if(j>=s.length()) {
			return true;
		}{
			return false;
		}
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
