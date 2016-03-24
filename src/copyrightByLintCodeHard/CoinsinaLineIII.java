/**
 * 
 */
package copyrightByLintCodeHard;

/**
 * @author Poirot
 *
 */
public class CoinsinaLineIII {
    public boolean firstWillWin(int[] values) {
        // write your code here
    	int[][] segmentTotal = new int[values.length][values.length];
    	for (int i = 0; i < segmentTotal.length; i++) {
    		int temp = 0;
			for (int j = i; j < segmentTotal.length; j++) {
				temp += values[j];
				segmentTotal[i][j] = temp;
				
			}
		}
    	int[][] res = new int[values.length][values.length];
    	for (int i = 0; i < res.length; i++) {
			res[i][i] = values[i];
		}
    	for (int length = 1; length < res.length; length++) {
    		
    		for (int i = 0; i < res.length-length; i++) {
    			int j = i+length;
    			res[i][j] = Math.max(values[i] + segmentTotal[i][j] - res[i+1][j], values[j] + segmentTotal[i][j]- res[i][j-1]);
			} 
		}
    	return res[0][values.length-1] > segmentTotal[0][values.length-1] - res[0][values.length-1]; 
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {1,20,4};
		CoinsinaLineIII t = new CoinsinaLineIII();
		System.out.println(t.firstWillWin(values));
	}

}
