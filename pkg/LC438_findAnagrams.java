package pkg;
import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���ַ���s��һ���ǿ��ַ���p���ҵ�p��������p����ĸ��λ�ʵ��Ӵ���������Щ�Ӵ�����ʼ������
 * �����ַ���ֻ����Сд��ĸ����ȫ��ͬ���ַ���Ҳ����λ�Ρ�
 * 
 * ˼·�������¼�¸������ַ����ж��ٸ����ַ���һ���ַ�һ���ַ��Ļ�����������жϣ��������̿ɽ��н϶��Ż�
 * */
public class LC438_findAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
		int num = p.length();//��¼��ǰƥ����������Ż�����
		int set[] = new int[26],copy[] = new int[26];
		List<Integer> result = new ArrayList<Integer>(); 
		
		//δʹ�õ��ַ���-1����
		for(int i=0;i<26;i++) {
			set[i] = -1;copy[i] = -1;
		}
		//������p�к��е��ַ�����ͳ��
		for(int i=0;i<p.length();i++) {
			set[p.charAt(i)-'a'] = set[p.charAt(i)-'a']==-1?1:set[p.charAt(i)-'a'] + 1;
		}
		//ͬ����������
		for(int i=0;i<26;i++) {
			copy[i] = set[i];
		}
		int left=0;//��ʼ����
		//�Ի������ڽ���ƥ��
		for(int i=0;i<s.length();i++) {
			if(set[s.charAt(i)-'a']>=1) {//�п�ƥ��
				set[s.charAt(i)-'a']--;//ƥ��ɹ�һ��
				num--;//������һ
				if(num==0) {//�ɹ�ƥ�䵽
					result.add(left);//��¼���
					set[s.charAt(left)-'a']++;//��ʼ����ǰ��һ���ַ���ȥ���Ѿ�ռ�õ�����
					left++;num++;
				}
			}else {//δƥ��ɹ�
				if(set[s.charAt(i)-'a']==-1) {//δʹ������ַ����������һ���ַ��������¿�ʼ
					left = i+1;
					num = p.length();
					for(int j=0;j<26;j++) {
						set[j] = copy[j];
					}
				}else {//ʹ��������ַ�����û������ô�࣬�����ǰ��left��ֱ������һ���͵�ǰ�ַ�һ�����ַ����޳�
					do {
						//ȥ���Ѿ�ռ�õ���������ʼ����ǰ��һ���ַ�
						set[s.charAt(left)-'a']++;
						left++;num++;
					}while(s.charAt(left-1)!=s.charAt(i));
					set[s.charAt(i)-'a']--;num--;//��i��Ҫ���룬��Ҫռ��һ������
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
