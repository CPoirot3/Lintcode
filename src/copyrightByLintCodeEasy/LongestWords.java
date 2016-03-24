/**
 * 
 */
package copyrightByLintCodeEasy;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */
public class LongestWords {
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
    	ArrayList<String> result = new ArrayList<>();
    	if (dictionary.length == 0) {
			return result;
		}
    	int currentMaxLength = dictionary[0].length();
    	result.add(dictionary[0]);
    	for (int i = 1; i < dictionary.length; i++) {
			if (dictionary[i].length() > currentMaxLength) {
				currentMaxLength = dictionary[i].length();
				result.clear();
				result.add(dictionary[i]);
			}else if (dictionary[i].length() == currentMaxLength) {
				result.add(dictionary[i]);
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
