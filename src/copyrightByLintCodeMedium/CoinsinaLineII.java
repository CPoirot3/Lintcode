/**
 * 
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class CoinsinaLineII {
    public boolean firstWillWin(int[] values) {
        // write your code here
    	if (values.length <= 1) {
			return true;
		}
    	for (int i = 0; i < values.length/2; i++) {
			int temp = values[i];
			values[i] = values[values.length - i - 1];
			values[values.length - i - 1] = temp;
		}
    	
    	
    	int[] tempTotal = new int[values.length];
    	int temp = 0;
    	for (int i = 0; i < values.length; i++) {
    		temp += values[i];
			tempTotal[i] = temp;
		}
//    	
//    	for (int i = 0; i < values.length; i++) {
//			System.out.print(values[i] + " ");
//		}
//    	System.out.println();
//    	for (int i = 0; i < values.length; i++) {
//			System.out.print(tempTotal[i] + " ");
//		}
//    	System.out.println();
    	int[] dp = new int[values.length]; 
    	dp[0] = values[0];
    	dp[1] = values[0] + values[1];
    	for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(tempTotal[i] - dp[i-1], tempTotal[i] - dp[i-2]);
		}
    	return dp[dp.length-1] > (tempTotal[tempTotal.length-1] - dp[dp.length-1]);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinsinaLineII t = new CoinsinaLineII();
		int[] values = {1,2,2};
		System.out.println(t.firstWillWin(values));
		int[] values2 = {1,2,4};
		System.out.println(t.firstWillWin(values2));
	}

}
