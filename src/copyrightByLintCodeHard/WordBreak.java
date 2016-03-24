/**
 * 
 */
package copyrightByLintCodeHard;
 
import java.util.HashSet; 
import java.util.Set;

/**
 * @author Poirot
 *
 */
public final class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
		// write your code here
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int end = 1; end <= s.length(); end++) {
			for (String str : dict) {
				if (str.length() <= end && dp[end - str.length()]) {
					if (s.substring(end - str.length(), end).equals(str)) {
						dp[end] = true;
						break;

					}
				}
			}
		}
		return dp[s.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak t = new WordBreak();
		Set<String> dict = new HashSet<>();
		dict.add("a");
		dict.add("b");
		System.out.println(t.wordBreak("ab", dict));
	}

}
