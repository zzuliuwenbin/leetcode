package pkg;

/**
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ����ֵ���ĸ��ӳ����绰������ͬ��
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC17_letterCombinations {
	public List<String> result = new ArrayList<String>();
	public HashMap<Character,String> map = new HashMap<Character,String>();
	public String input;
	public void dg(String str,int index) {
		if(index>=input.length()) {
			result.add(str);
		}else {
			String s = map.get(input.charAt(index));
			for(int i=0;i<s.length();i++) {
				dg(str+s.charAt(i),index+1);
			}
		}
		
	}
	
	public List<String> letterCombinations(String digits) {
		map.put('2',"abc");map.put('3',"def");map.put('4',"ghi");
		map.put('5',"jkl");map.put('6',"mno");map.put('7',"pqrs");
		map.put('8',"tuv");map.put('9',"wxyz");
		if(digits==null||digits.length()==0) {
			return result;
		}
		input = digits;
        dg("",0);
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LC17_letterCombinations test = new LC17_letterCombinations();
		System.out.println(test.letterCombinations(""));

	}

}
