/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
    	
    	//一次交易
    	
        // write your code here
    	if (prices.length < 2) {
			return 0;
		}
        int tempMax = 0;
        int max = 0;
        int beginIndex = 0;
        int maxIndex = 0;
        //int minThanBeginIndex = 0;
        for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[maxIndex]) {
				maxIndex = i;
				tempMax = prices[i] - prices[beginIndex];
			}else if (prices[i] < prices[beginIndex] ) {
				beginIndex = i;
				maxIndex = i;
				max = Math.max(tempMax, max);
				tempMax = 0;
			}
		}
        max = Math.max(tempMax, max);
        return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
