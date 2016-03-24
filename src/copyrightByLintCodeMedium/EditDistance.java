/**
 * 
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        // write your code here 
    	if (word1.length() == 0) {
			return word2.length();
		}
    	if (word2 == null || word2.length() == 0) {
			return word1.length();
		}
    	if (word1.equals(word2)) {
			return 0;
		}
//    	int[][] res = new int[word1.length()+1][word2.length()+1];
//    	for (int i = 0; i < res.length; i++) {
//			res[i][0] = i;
//		}
//    	for (int i = 0; i < res[0].length; i++) {
//			res[0][i] = i;
//		}
    	int[] resPrevious = new int[word2.length()+1];
    	for (int i = 0; i < resPrevious.length; i++) {
			resPrevious[i] = i;
		}
    	int[] resCurrent = new int[word2.length()+1];
    	for (int i = 1; i <= word1.length(); i++) {
//    		int[] resCurrent = new int[word2.length()+1];
    		resCurrent[0] = i;
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					resCurrent[j] = resPrevious[j-1];// Math.min(res[i-1][j-1],Math.min(res[i][j-1], res[i-1][j]));
				} else {
					resCurrent[j] = Math.min(resPrevious[j-1] ,Math.min(resCurrent[j-1], resPrevious[j])) + 1;
				}
			}
			resPrevious = resCurrent;
		}
    	return resPrevious[word2.length()];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance t = new EditDistance();
		String word1 = "ab";
		String word2 = "a";
		System.out.println(t.minDistance(word1, word2));
	}

}
