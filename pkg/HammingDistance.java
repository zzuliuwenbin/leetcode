package pkg;

public class HammingDistance {

	public int hammingDistance(int x, int y) {
		int r = x^y,i=31,t=1,s=0;
		while(i-->0) {
			s+= (r&t)>0?1:0;
			t<<=1;
		}
        return s;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HammingDistance test = new HammingDistance();
		System.out.println(test.hammingDistance(3, 1));

	}

}
