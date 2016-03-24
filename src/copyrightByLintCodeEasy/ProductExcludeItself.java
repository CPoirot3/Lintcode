/**
 * 
 */
package copyrightByLintCodeEasy;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */
public class ProductExcludeItself {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
    	ArrayList<Long> result = new ArrayList<>();
    	long a = 1;
    	int countZeros = 0;
    	for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == 0) {
				countZeros ++;
			}else {
				a *= A.get(i);
			}
		}
    	for (int i = 0; i < A.size(); i++) {
			if (countZeros > 1) {
				result.add((long)0);
			}else if (countZeros == 1) {
				result.add(A.get(i) == 0 ? a:0);
			}else {
				result.add(a/A.get(i));
			}
		}
    	return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
