/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class BestTimetoBuyandSellStockII {
	//任意次交易
    public int maxProfit(int[] prices) {
        // write your code here
    	if (prices.length <= 1) {
			return 0;
		}
    	int begin = 0;
    	int res = 0;
    	while (begin < prices.length - 1) {
    		if (prices[begin] < prices[begin+1]) {
				res += prices[begin+1] - prices[begin];
			}
    		begin ++;
    	}
		return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
