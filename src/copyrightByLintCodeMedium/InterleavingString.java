/**
 * 
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
    	if (s1 == null) {
    		return s2 == s3;
    	}
    	if (s2 == null) {
    		return s1 == s3;
    	}
    	if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
    	
    	
    	
        return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "";
		String s2 = "";
		String s3 = "";
		InterleavingString t = new InterleavingString();
		System.out.println(t.isInterleave(s1, s2, s3));
		
	}

}
