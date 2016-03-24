/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
//不同的路径
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // write your code here 
    	int[][] res = new int[m][n];
    	for (int i = 0; i < res.length; i++) {
			res[i][n-1] = 1;
		} 
    	for (int i = 0; i < res[0].length; i++) {
			res[m-1][i] = 1;
		}
    	for (int i = m-2; i >= 0; i--) {
			for (int j = n-2; j >= 0; j--) {
				res[i][j] = res[i+1][j] + res[i][j+1];
			}
		}
    	return res[0][0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
