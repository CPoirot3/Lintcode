/**
 * 
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class NumTrees {
    public int numTrees(int n) {
        // write your code here
    	if (n == 0 || n == 1) {
			return 1;
		} 
    	int[] res = new int[n+1];
    	res[0] = 1;
    	res[1] = 1; 
    	for (int i = 2; i < res.length; i++) {
			for (int j = 0; j < i; j++) {
				res[i] += res[j]*res[i-j-1];
			}
		}
    	return res[n];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumTrees t = new NumTrees();
		System.out.println(t.numTrees(4));
	}

}
