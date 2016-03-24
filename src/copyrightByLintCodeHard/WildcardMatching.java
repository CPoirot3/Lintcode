package copyrightByLintCodeHard;

/**
 * @author Poirot 2015年7月9日
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
//        int sIndex = 0, pIndex = 0, matchIndex = 0, starIndex = -1;            
//        while (sIndex < s.length()){
//            // advancing both pointers
//            if (pIndex < p.length()  && (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex))){
//                sIndex++;
//                pIndex++;
//            }
//            // * found, only advancing p pointer
//            else if (pIndex < p.length() && p.charAt(pIndex) == '*'){
//                starIndex = pIndex;
//                matchIndex = sIndex;
//                pIndex++;
//            }
//           // last p pointer was *, advancing string pointer
//            else if (starIndex != -1){//此时*增加一个匹配字条 ： matchIndex++;
//                pIndex = starIndex + 1;
//                matchIndex++;
//                sIndex = matchIndex;
//            }
//           //current p pointer is not star, last patter pointer was not *
//          //characters do not match
//            else return false;
//        } 
//        //check for remaining characters in p 剩余的都是*的情况
//        while (pIndex < p.length() && p.charAt(pIndex) == '*')
//            pIndex++; 
//        return pIndex == p.length();
		if (s.length() > p.length() && !p.contains("*")) {
			return false;
		}
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[0][0] = true;
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = false;
		}
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = dp[0][i-1] && p.charAt(i-1) == '*';
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s.charAt(i-1) == p.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					if (p.charAt(j-1) == '.') {
						dp[i][j] = dp[i-1][j-1];
					} else if (p.charAt(j-1) == '*') {
						for (int j2 = i; j2 >= 0; j2--) {
							if (dp[j2][j-1]) {
								dp[i][j] = true;
								break;
							}
						}
					} 
				}
			}
		}
		return dp[s.length()][p.length()];
	} 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching t = new WildcardMatching();
//		String s = "aaa";
//		String p = "aaa";
		System.out.println(t.isMatch("aa", "a*"));
	}

}
