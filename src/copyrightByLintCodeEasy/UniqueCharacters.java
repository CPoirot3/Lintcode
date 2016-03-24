/**
 * 
 */
package copyrightByLintCodeEasy;

import java.util.BitSet;

/**
 * @author Poirot
 *
 */
public class UniqueCharacters {
    public boolean isUnique(String str) {
        // write your code here
    	BitSet bitSet = new BitSet(128);
    	for (int i = 0; i < str.length(); i++) {
			if (bitSet.get(str.charAt(i))) {
				return false;
			}
			bitSet.set(str.charAt(i));
		}
    	return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
