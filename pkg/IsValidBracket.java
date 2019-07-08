package pkg;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * */
public class IsValidBracket {
	
	public boolean isValid(String s) {
		if(s.length()==0) {
			return true;
		}
		
		char stack[] = new char[s.length()];
		int k = 0;
		for(int i=0;i<s.length();i++) {
			if(k==0) {//栈空,直接进栈
				stack[k++]=s.charAt(i);
				continue;
			}
			if(isMacth(stack[k-1],s.charAt(i))) {
				k--;
			}else {
				if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}') {
					return false;
				}else {
					stack[k++]=s.charAt(i);
				}
			}
		}
		if(k==0) {
			return true;
		}else {
	        return false;
		}
    }
	
	public boolean isMacth(char a,char b) {
		switch(a) {
			case '(':if(b == ')') return true;break;
			case '[':if(b == ']') return true;break;
			case '{':if(b == '}') return true;break;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsValidBracket test = new IsValidBracket();
		System.out.println(test.isValid("(}"));
		

	}

}
