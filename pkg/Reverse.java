package pkg;
/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * */
public class Reverse {
	
	public int reverse(int x) {
		String str;
		if(x>0) {
			str = new StringBuilder(String.valueOf(x)).reverse().toString();
		}else {
			str = new StringBuilder(String.valueOf(x).substring(1)).reverse().toString();
			str = "-".concat(str);
		}
		int res=0;
		try {
			res = Integer.parseInt(str);
		}catch(Exception e) {
			res = 0;
		}
        return res;
    }
	
	/*public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) 
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) 
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse test = new Reverse();
		System.out.println(test.reverse(-120));
		
		
	}

}
