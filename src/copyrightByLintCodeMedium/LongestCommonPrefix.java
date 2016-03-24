/**
 * 2015Äê7ÔÂ16ÈÕ
 * Poirot
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		// write your code here
		if (strs.length == 0) {
			return "";
		}
		int minLength = strs[0].length();
		String minString = strs[0];
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < minLength) {
				minLength = strs[i].length();
				minString = strs[i];
			}
		}
		if (minLength == 0) {
			return "";
		}
		int maxCandidateLength = minLength;
		int minCandidateLength = 0;
		while (minCandidateLength < maxCandidateLength - 1) {
			int medium = (maxCandidateLength + minCandidateLength) / 2;
			if (isCommonPrefix(strs, minString.substring(0, medium))) {
				minCandidateLength = medium;
			} else {
				maxCandidateLength = medium - 1;
			}
		}
		if (isCommonPrefix(strs, minString.substring(0, maxCandidateLength))) {
			return minString.substring(0, maxCandidateLength);
		} else {
			return minString.substring(0, minCandidateLength);
		}
	}

	public boolean isCommonPrefix(String[] strs, String s) {
		for (int i = 0; i < strs.length; i++) {
			if (!strs[i].startsWith(s)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "ABCDEFG", "ABCEFG", "ABCEFA" };
		LongestCommonPrefix t = new LongestCommonPrefix();
		System.out.println(t.longestCommonPrefix(strs));
	}

}
