/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class Count1inBinary {
    public int countOnes(int num) {
        // write your code here
    	if (num == 0) {
			return 0;
		}
    	if (num == 1) {
			return 1;
		}
    	int n = num;
    	int res = 0;
    	while (n > 0) {
    		if (n % 2 == 1) {
				res ++;
			}
    		n /= 2;
    	}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
