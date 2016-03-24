/**
 * 
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        // write your code here
    	if (S.length() < T.length()) {
			return 0;
		}
//        int[][] dp = new int[S.length()+1][T.length()+1]; 
        ArrayList<Integer> res1 = new ArrayList<>();
//        for (int i = 0; i < S.length()+1; i++) {
////			dp[i][0] = 1;
//			res1.add(1);
//		}
        res1.add(1);
        ArrayList<Integer> res2 = null;
        for (int i = 1; i <= S.length(); i++) {
        	if (res1.size() <= Math.min(i, T.length()) + 1 ) { 
				for (int j = 0; j <= Math.min(i, T.length()) - res1.size(); j++) {
					res1.add(0);
				}
			}
        	res2 = new ArrayList<>();
        	res2.add(1);
			for (int j = 1; j <= i && j<= T.length(); j++) {
//				dp[i][j] = (S.charAt(i-1) == T.charAt(j-1) ? dp[i-1][j-1]+dp[i-1][j]:dp[i-1][j])  ;
				res2.add(S.charAt(i-1) == T.charAt(j-1) ? res1.get(j-1)+res1.get(j) : res1.get(j));
			}
			res1 = res2;
		}
//        return dp[S.length()][T.length()];
        return res1.get(res1.size()-1);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctSubsequences t = new DistinctSubsequences();
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(t.numDistinct(S, T));
	}

}
