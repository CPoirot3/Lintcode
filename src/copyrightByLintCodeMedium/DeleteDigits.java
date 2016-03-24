/**
 * 
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class DeleteDigits {
    public String deleteDigits(String A, int k) {
        // write your code here 
    	if (k == 0) {
			return A;
		}
    	if (A == null || A.length() == 0) {
			return "";
		}
    	if (A.length() == k) {
			return "";
		}
    	char minChar = A.charAt(0);
    	int minIndex = 0;
    	for (int i = 0; i <= k; i++) {
			if (A.charAt(i) < minChar) {
				minChar = A.charAt(i);
				minIndex = i;
			}
		} 
//    	System.out.println(A.substring(minIndex+1) + " " +(k - minIndex));
    	String result = minChar + deleteDigits(A.substring(minIndex+1), k - minIndex);
    	while (result.charAt(0) == '0'){
    		result = result.substring(1);
    	}
    	return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteDigits t = new DeleteDigits();
		System.out.println(t.deleteDigits("178542", 4));
	}

}
