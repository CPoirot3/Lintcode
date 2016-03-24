package copyrightByLintCodeHard;

import java.util.Arrays; 

/**
 * @author Poirot 2015年7月9日
 */
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if(s1==null || s2 == null) 
			return false;
		if(s1.length()!=s2.length())
			return false;
        if(s1.equals(s2)) 
        	return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!Arrays.equals(c1, c2))
        	return false;
        for(int i=1; i<s1.length(); i++)
        {
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) 
            		&& isScramble(s1.substring(i), s2.substring(i))) 
            	return true;
            if(isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) 
            		&& isScramble(s1.substring(i), s2.substring(0, s2.length()-i))) 
            	return true;
        }
        return false;
    }
//	public boolean isScramble(String s1, String s2) {
//		if (s1 == null && s2 == null) {
//			return true;
//		}
//		
//		if (s1.equals(s2)) {
//			return true;
//		}
//		boolean[][] dp = new boolean[s1.length()][s2.length()];
//		for (int i = 0; i < dp.length; i++) {
//			dp[i][i] = s1.charAt(i) == s2.charAt(i);
//		}
//		for (int i = 1; i < dp.length; i++) { 
//			for (int j = 0; i+j < dp.length; j++) {
//				String a = s1.substring(j, j+i+1);
//				String b = s2.substring(j, j+i+1);
//				for (int k = 0; k < a.length(); k++) {
//					
//				}
//				if (a.equals(b)) {
//					dp[j][i+j] = true;
//					continue;
//				}
//				for (int j2 = j; j2 <= j+i-1; j2++) {
//					if (dp[j][j2] && dp[j2+1][j+i]) {
//						dp[j][i+j] = true;
//						break;
//					}  
//				}
//			}
//		}
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
//		return dp[0][s1.length()-1];
//	}
//	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString t = new ScrambleString();
		System.out.println(t.isScramble("abab", "bbaa"));
	}

}
