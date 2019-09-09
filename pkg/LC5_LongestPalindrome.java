package pkg;


/**
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
 * */
public class LC5_LongestPalindrome {

	/**
	 * ˼·һ������������������һ��i��ʼ�������˼�⣬�ҵ����ֵ�͸���
	 * */
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) { return ""; }
		int len = s.length();
		int m = 0,n = 0;//�������ַ�λ��
		int max = 0;//��ǰ������󳤶�
		for(int i=0;i<len;i++) {
			int j = 0;
			while(true) {//�����Գ�
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
			if(i<len-1&&s.charAt(i)==s.charAt(i+1)) {//���ܵ�ż���Գ�
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
	 * ˼·����DP�㷨
	 * ���壺dp[i][j] = s[i,j]�Ƿ����
	 * ���ƹ�ʽ��dp[i][j] = dp[i+1][j-1]&&s[i+1] == s[j-1];
	 * ��ʼֵ��dp[i][i] = true��dp[i][i+1] = s[i] == s[i+1];
	 * */
	public String longestPalindrome_dp(String s) {
		if (s == null || s.length() < 1) { return ""; }
		int m=0,n=0;//�����Ŀ�ʼ����λ��
		int len = s.length();
		boolean dp[][] = new boolean [len][len];
		for(int i=0;i<len-1;i++) {	//��ʼֵ
			dp[i][i] = true;
			dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
			if(dp[i][i+1]) {
				m = i;n = i+1;
			}
		}
		dp[len-1][len-1] = true;	
		
		//i,j��������i,j�����½�Ԫ�أ��Խ��ߺʹζԽ����Ѿ�����ˣ���ÿ����һ��б�߼���
		for(int j=2;j<len;j++) {
			for(int i=0;i<len-j;i++) {
				dp[i][j+i] = dp[i+1][j+i-1]&&s.charAt(i) == s.charAt(j+i);
				if(dp[i][j+i]&&j>n-m) {//�������ֵ
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
