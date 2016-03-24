/**
 * 
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class BackPackII {
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
    	int[][] res = new int[A.length][m+1];
    	for (int i = 0; i < res[0].length; i++) {
			if (A[A.length-1] > i) {
				res[A.length-1][i] = 0; 
			}else {
				res[A.length-1][i] = V[A.length-1];
			}
		}
    	for (int i = A.length-2; i >= 0; i--) {
			for (int j = 0; j < res[0].length; j++) {
				if (A[i] > j) {
					res[i][j] = res[i+1][j];
				}else {
					res[i][j] = Math.max(res[i+1][j], res[i+1][j-A[i]] + V[i]);
				}
			}
		}
    	 
    	return res[0][m];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackPackII t = new BackPackII();
		int[] A = {2, 3, 5, 7};
		int[] V = {1, 5, 2, 4};
		System.out.println(t.backPackII(10, A, V));
	}

}
