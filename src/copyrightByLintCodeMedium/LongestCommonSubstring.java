/**
 * 2015Äê7ÔÂ18ÈÕ
 * Poirot
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class LongestCommonSubstring {
	public int longestCommonSubstring(String A, String B) {
		// write your code here
		if (A == null || B == null || A.length() == 0 || B.length() == 0) {
			return 0;
		}
		int[][] res = new int[A.length() + 1][B.length() + 1];
		for (int i = 0; i < res.length; i++) {
			res[i][0] = 0;
		}
		for (int i = 0; i < res[0].length; i++) {
			res[0][i] = 0;
		}
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) != B.charAt(j - 1)) {
					res[i][j] = Math.max(res[i][j - 1], res[i - 1][j]);
				} else {
					int count = 1;
					int m = i - 2;
					int n = j - 2;
					while (m >= 0 && n >= 0) {
						if (A.charAt(m) == B.charAt(n)) {
							count++;
							m--;
							n--;
						} else {
							break;
						}
					}
					res[i][j] = Math.max(Math.max(res[i][j - 1], res[i - 1][j]), Math.max(res[i - 1][j - 1], count));
				}
			}
		}
		// for (int i = 0; i < res.length; i++) {
		// for (int j = 0; j < res[0].length; j++) {
		// System.out.print(res[i][j] + " ");
		// }
		// System.out.println();
		// }
		return res[A.length()][B.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubstring t = new LongestCommonSubstring();
		String A = "abcd";// "www.lintcode.com code";
		String B = "abcdd";// "www.ninechapter.com code";
		System.out.println(t.longestCommonSubstring(A, B));
	}

}
