/**
 * 2015Äê7ÔÂ21ÈÕ
 * Poirot
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class LongestIncreasingContinuousSubsequence {
	public int longestIncreasingContinuousSubsequence(int[] A) {
		// Write your code here
		if (A.length <= 1) {
			return A.length;
		}
		int increase = 1;
		int decrease = 1;
		int max = Math.max(increase, decrease);
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1]) {
				increase++;
				max = Math.max(increase, max);
				decrease = 1;
			} else {
				decrease++;
				increase = 1;
				max = Math.max(max, decrease);
			}
			// max = Math.max(increase, decrease);
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingContinuousSubsequence t = new LongestIncreasingContinuousSubsequence();
		int[] A = { 5, 1, 2, 3, 4 };
		System.out.println(t.longestIncreasingContinuousSubsequence(A));
	}

}
