package pkg;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * */
public class LC5_LongestPalindrome {

	/**
	 * 思路一：暴力遍历，从任意一个i开始，向两端检测，找到最大值就更新
	 * */
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) { return ""; }
		int len = s.length();
		int m = 0,n = 0;//最大回文字符位置
		int max = 0;//当前回文最大长度
		for(int i=0;i<len;i++) {
			int j = 0;
			while(true) {//奇数对称
				if(i-j>=0&&i+j<len&&s.charAt(i-j)==s.charAt(i+j)) {
					j++;
				}else {
					if(2*j-1>max) {
						max = 2*j-1;
						m = i-j+1;
						n = i+j-1;
					}
					break;
				}
			}
			if(i<len-1&&s.charAt(i)==s.charAt(i+1)) {//可能的偶数对称
				j = 0;
				while(true) {
					if(i-j>=0&&i+1+j<len&&s.charAt(i-j)==s.charAt(i+1+j)) {
						j++;
					}else {
						if(2*j>max) {
							max = 2*j;
							m = i-j+1;
							n = i+j;
						}
						break;
					}
				}
			}
		}
		return s.substring(m, n+1);
    }
	
	/**
	 * 思路二，DP算法
	 * 定义：dp[i][j] = s[i,j]是否回文
	 * 递推公式：dp[i][j] = dp[i+1][j-1]&&s[i+1] == s[j-1];
	 * 初始值：dp[i][i] = true，dp[i][i+1] = s[i] == s[i+1];
	 * */
	public String longestPalindrome_dp(String s) {
		if (s == null || s.length() < 1) { return ""; }
		int m=0,n=0;//最大回文开始结束位置
		int len = s.length();
		boolean dp[][] = new boolean [len][len];
		for(int i=0;i<len-1;i++) {	//初始值
			dp[i][i] = true;
			dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
			if(dp[i][i+1]) {
				m = i;n = i+1;
			}
		}
		dp[len-1][len-1] = true;	
		
		//i,j依赖的是i,j的左下角元素，对角线和次对角线已经填好了，则每次填一个斜线即可
		for(int j=2;j<len;j++) {
			for(int i=0;i<len-j;i++) {
				dp[i][j+i] = dp[i+1][j+i-1]&&s.charAt(i) == s.charAt(j+i);
				if(dp[i][j+i]&&j>n-m) {//更新最大值
					m = i;n = j+i;
				}
			}
		}
		return s.substring(m, n+1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC5_LongestPalindrome test = new LC5_LongestPalindrome();
		System.out.println(test.longestPalindrome_dp("babad"));
		System.out.println(test.longestPalindrome_dp("cbbd"));
		System.out.println(test.longestPalindrome_dp(""));
	}

}
