/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        // write your code here
    	if (n <= 0) {
			return 0;
		}
    	if (n == 1) {
			return 1;
		}
    	if (n == 2) {
			return 2;
		}
    	int[] res = new int[n+1];
    	res[0] = 0;
    	res[1] = 1;
    	res[2] = 2;
    	
    	for (int i = 3; i < res.length; i++) {
			res[i] = res[i-1] + res[i-2];
		}
    	return res[n];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
