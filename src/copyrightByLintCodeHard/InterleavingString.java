/**
 * 
 */
package copyrightByLintCodeHard;

/**
 * @author Poirot
 *
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
    	if (s1 == null || s1 == "") {
			return s3.equals(s2);
		}
    	if (s2 == null || s2 == "") {
			return s3.equals(s1);
		}
    	
    	if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		if (s3.equals(s2 + s1) || s3.equals(s1 + s2)) {
			return true;
		}

		boolean[][] dpMatrix = new boolean[s1.length() + 1][s2.length() + 1];

		dpMatrix[0][0] = true;

		for (int i = 1; i < dpMatrix[0].length; i++) {
			dpMatrix[0][i] = dpMatrix[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
		}

		for (int i = 1; i < dpMatrix.length; i++) {
			dpMatrix[i][0] = dpMatrix[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
		}

		for (int i = 1; i < dpMatrix.length; i++) {
			for (int j = 1; j < dpMatrix[0].length; j++) {
				dpMatrix[i][j] = (dpMatrix[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)))
						|| (dpMatrix[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
			}
		}
		return dpMatrix[s1.length()][s2.length()];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString t = new InterleavingString();
		String s1 = "asdfjopufaaf;lasnopfodifa;djfal;sfjdsf";
		String s2 = "adlkjfoqweijzdkj;ljfeowfjl;djfnd";
		String s3 = "asdfjopufaaf;lasnopfod adlkjfoqweijzdkj;ljfeowfjl;djfn eifa;djfal;sfj dsf";
		System.out.println(t.isInterleave(s1, s2, s3));
	}

}
