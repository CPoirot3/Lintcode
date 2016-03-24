/**
 * 2015Äê7ÔÂ14ÈÕ
 * CH
 */
package copyrightByLintCodeMedium;

/**
 * @author CH
 *
 */
public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String A, String B) {
		// write your code here
		if (A == null || B == null || A.length() == 0 || B.length() == 0) {
			return 0;
		}
		int[][] res = new int[A.length() + 1][B.length() + 1];
		for (int i = 0; i < res.length; i++) {
			res[i][0] = 0;
		}
		for (int j = 0; j < res[0].length; j++) {
			res[0][j] = 0;
		}
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				res[i][j] = (A.charAt(i - 1) == B.charAt(j - 1) ? res[i - 1][j - 1] + 1
						: Math.max(res[i][j - 1], res[i - 1][j]));
			}
		}
		return res[A.length()][B.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubsequence t = new LongestCommonSubsequence();
		System.out.println(t.longestCommonSubsequence("ABCD", "EACB"));
	}

}
