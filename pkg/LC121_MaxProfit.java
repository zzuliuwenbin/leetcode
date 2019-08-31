package pkg;

/**
 * ����һ�����飬���ĵ�i��Ԫ����һ֧������Ʊ��i��ļ۸�
 * ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������
 * ע���㲻���������Ʊǰ������Ʊ��
 * 
 * ˼·�������Ĺ����Ҳ��ϸ�����ͼ۸񣬳��˸�����ͼ۲����������ı����������������Ƚ������ļ۸��Ƿ�������ֵ
 * */
public class LC121_MaxProfit {
	public int maxProfit(int[] prices) {
		int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;   
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC121_MaxProfit test = new LC121_MaxProfit();
		System.out.println(test.maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.println(test.maxProfit(new int[] {7,6,4,3,1}));
	}

}
