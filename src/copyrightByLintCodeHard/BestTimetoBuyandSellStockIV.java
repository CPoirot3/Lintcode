/**
 * 
 */
package copyrightByLintCodeHard;

/**
 * @author Poirot
 *
 */
public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        // write your code here
    	if (prices.length <= 1) {
			return 0;
		}
    	if (k >= prices.length / 2) {
			int max = 0;
			int begin = 0;
			while (begin < prices.length -1) {
				if (prices[begin] < prices[begin+1]) {
					max += (prices[begin+1] - prices[begin]);
				}
				begin++;
			}
			return max;
		} 

        int[][] t = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < prices.length; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][prices.length - 1]; 
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {4,4,6,1,1,4,2,5};
		BestTimetoBuyandSellStockIV t = new BestTimetoBuyandSellStockIV();
		System.out.println(t.maxProfit(2, prices));
		int[] prices2 = {1,2,4,2,5,7,2,4,9,0};
		System.out.println(t.maxProfit(4, prices2));
	}

}
