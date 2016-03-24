/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	int[][] res = new int[m][n];
    	if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
			return 0;
		}
    	res[m-1][n-1] = 1;
    	for (int i = m-2; i >= 0; i--) {
			res[i][n-1] = obstacleGrid[i][n-1] == 1 ? 0 : res[i+1][n-1];
		} 
    	for (int i = n-2; i >= 0; i--) {
			res[m-1][i] = obstacleGrid[m-1][i] == 1 ? 0 : res[m-1][i+1];
		}
    	for (int i = m-2; i >= 0; i--) {
			for (int j = n-2; j >= 0; j--) {
				res[i][j] = obstacleGrid[i][j] == 1 ? 0 : res[i+1][j] + res[i][j+1];
			}
		}
    	return res[0][0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{0}};
		UniquePathsII t = new UniquePathsII();
		System.out.println(t.uniquePathsWithObstacles(array));
	}

}
