package pkg;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串s和一个非空字符串p，找到p中所有是p的字母异位词的子串，返回这些子串的起始索引。
 * 给定字符串只包含小写字母，完全相同的字符串也算异位次。
 * 
 * 思路：数组记录下给定的字符串有多少各类字符，一个字符一个字符的滑动窗格进行判断，滑动过程可进行较多优化
 * */
public class LC438_findAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
		int num = p.length();//记录当前匹配的数量，优化滑动
		int set[] = new int[26],copy[] = new int[26];
		List<Integer> result = new ArrayList<Integer>(); 
		
		//未使用的字符用-1区分
		for(int i=0;i<26;i++) {
			set[i] = -1;copy[i] = -1;
		}
		//给定的p中含有的字符数量统计
		for(int i=0;i<p.length();i++) {
			set[p.charAt(i)-'a'] = set[p.charAt(i)-'a']==-1?1:set[p.charAt(i)-'a'] + 1;
		}
		//同步备份数组
		for(int i=0;i<26;i++) {
			copy[i] = set[i];
		}
		int left=0;//起始索引
		//以滑动窗口进行匹配
		for(int i=0;i<s.length();i++) {
			if(set[s.charAt(i)-'a']>=1) {//尚可匹配
				set[s.charAt(i)-'a']--;//匹配成功一个
				num--;//总数减一
				if(num==0) {//成功匹配到
					result.add(left);//记录结果
					set[s.charAt(left)-'a']++;//起始索引前移一个字符，去除已经占用的数量
					left++;num++;
				}
			}else {//未匹配成功
				if(set[s.charAt(i)-'a']==-1) {//未使用这个字符，则需从下一个字符串处重新开始
					left = i+1;
					num = p.length();
					for(int j=0;j<26;j++) {
						set[j] = copy[j];
					}
				}else {//使用了这个字符，但没有用这么多，则可以前移left，直到遇到一个和当前字符一样的字符，剔除
					do {
						//去除已经占用的数量，起始索引前移一个字符
						set[s.charAt(left)-'a']++;
						left++;num++;
					}while(s.charAt(left-1)!=s.charAt(i));
					set[s.charAt(i)-'a']--;num--;//第i个要编入，需要占用一个数量
				}
			}
		}
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC438_findAnagrams test = new LC438_findAnagrams();
		System.out.println(test.findAnagrams("ab", "abc"));
	}

}
