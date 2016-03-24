/**
 * 
 */
package copyrightByLintCodeHard;

/**
 * @author Poirot
 *
 */
public class LongestIncreasingContinuousSubsequenceII {
	int[] x = {0, 1, 0, -1};
    int[] y = {-1, 0, 1, 0};
    static int count = 0;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if(A == null || A.length == 0 || A[0].length == 0)
            return 0;
        int[][] dp = new int[A.length][A[0].length];
        int num = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                num = Math.max(num, search(A, dp, i, j));
            }
        }
        return num;
     }
     
     private int search(int[][] A, int[][] dp, int i, int j) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        int ans = 1;
        for(int k = 0; k < 4; k++) {
            int i1 = i + x[k];
            int j1 = j + y[k];
            count ++;
            if(i1 >=0 && i1 < A.length && j1 >= 0 && j1 < A[0].length && A[i][j] > A[i1][j1]) {
                ans = Math.max(ans, search(A, dp, i1, j1) + 1);
                
            }
        }
        dp[i][j] = ans;
        return ans;
     }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingContinuousSubsequenceII t = new LongestIncreasingContinuousSubsequenceII();
		int[][] A = {{1,2,3,4,5,6},{14,15,16,17,18,8},{12,13,11,10,9,7}};
		System.out.println(t.longestIncreasingContinuousSubsequenceII(A));
		System.out.println(count);
	}

}
