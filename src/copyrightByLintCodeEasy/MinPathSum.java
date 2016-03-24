/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        // write your code here
    	int m = grid.length;
    	int n = grid[0].length;
    	int[][] res = new int[m][n];
    	for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				res[i][j] = grid[i][j];
			} 
		}
    	res[m-1][n-1] = grid[m-1][n-1];
    	for (int i = m - 2 ;i >=0 ; i--) {
			res[i][n-1] += res[i+1][n-1];
		} 
    	for (int i = n - 2; i >= 0; i--) {
			res[m-1][i] += res[m-1][i+1];
		}
    	for (int i = m-2; i >= 0; i--) {
			for (int j = n-2; j >= 0; j--) {
				res[i][j] += Math.min(res[i+1][j], res[i][j+1]);
			}
		}
    	for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j]+ " ");
			}
			System.out.println();
		}
    	return res[0][0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinPathSum t = new MinPathSum();
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(t.minPathSum(grid));
	}

}
