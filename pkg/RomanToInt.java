package pkg;

/**
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * */
public class RomanToInt {
	
	public int romanToInt(String s) {
        int res = 0;
        int len = s.length();
        int i = 0;
        while(i<len) {
        	switch(s.charAt(i)) {
	        	case 'M': res += 1000;break;
	        	case 'D': res += 500;break;
	        	case 'C': 
	        		if(i+1<len) {
	        			if(s.charAt(i+1)=='M') {
	        				res += 900; i++;
	        			}else if(s.charAt(i+1)=='D'){
	        				res += 400; i++;
	        			}else {
	        				res += 100;
	        			}
	        		}else {//后续没有数字
	        			res += 100;
	        		}
	        		break;
	        	case 'L': res += 50;break;
	        	case 'X': 
	        		if(i+1<len) {
	        			if(s.charAt(i+1)=='C') {
	        				res += 90; i++;
	        			}else if(s.charAt(i+1)=='L'){
	        				res += 40; i++;
	        			}else {
	        				res += 10;
	        			}
	        		}else {//后续没有数字
	        			res += 10;
	        		}
	        		break;
	        	case 'V': res += 5;break;
	        	case 'I':
	        		if(i+1<len) {
	        			if(s.charAt(i+1)=='X') {
	        				res += 9; i++;
	        			}else if(s.charAt(i+1)=='V'){
	        				res += 4; i++;
	        			}else {
	        				res += 1;
	        			}
	        		}else {//后续没有数字
	        			res += 1;
	        		}
	        		break;
        	}
        	i++;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomanToInt test = new RomanToInt();
		System.out.println(test.romanToInt("MCMXCIV"));
	}

}
