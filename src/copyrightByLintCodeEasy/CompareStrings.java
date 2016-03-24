/**
 * 
 */
package copyrightByLintCodeEasy;

//import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Poirot
 *
 */
public class CompareStrings {
    public boolean compareStrings(String A, String B) {
        // write your code here
    	
    	//方法一 O(nlog(n))
//    	if (A == null && B == null) {
//			return true;
//		}
//    	if (A == null || B == null) {
//			return false;
//		}  
//    	char[] charsA = A.toCharArray();
//    	char[] charsB = B.toCharArray();
//    	Arrays.sort(charsA);
//    	Arrays.sort(charsB); 
//    	int i = 0;
//    	int j = 0;
//    	while (i < charsA.length && j < charsB.length) {
//    		System.out.println(i+" " +j);
//    		if (charsA[i] == charsB[j]) {
//    			i++;
//    			j++;
//			}else {
//				i++;
//			}
//    	} 
//    	return j == charsB.length;
    	
    	//方法二 O(n)
    	if (A == null && B == null) {
			return true;
		}
    	if (A == null || B == null) {
			return false;
		}  
    	Map<Character, Integer> mapA = new HashMap<>();
    	for (int i = 0; i < A.length(); i++) {
			mapA.put(A.charAt(i), mapA.containsKey(A.charAt(i)) ? mapA.get(A.charAt(i)) + 1 : 1);
		}
    	for (int i = 0; i < B.length(); i++) {
			if (!mapA.containsKey(B.charAt(i))) {
				return false;
			}else {
				int count = mapA.get(B.charAt(i));
				if (count == 1) {
					mapA.remove(B.charAt(i));
				}else {
					mapA.put(B.charAt(i), count - 1);
				}
			}
		}
    	return true;
    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareStrings t = new CompareStrings();
		System.out.println(t.compareStrings("ABCD","ACD"));
	}

}
