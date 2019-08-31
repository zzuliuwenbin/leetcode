package pkg;

/**
 * 给定一个数组，它的第i个元素是一支给定股票第i天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 
 * 思路：遍历的过程找不断更新最低价格，除了更新最低价操作，其它的遍历都尝试卖出，比较卖出的价格是否大于最大值
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
