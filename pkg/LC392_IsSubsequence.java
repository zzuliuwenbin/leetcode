package pkg;

/**
 * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
 * �������Ϊ s �� t �н�����Ӣ��Сд��ĸ���ַ��� t ���ܻ�ܳ������� ~= 500,000������ s �Ǹ����ַ��������� <=100����
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
