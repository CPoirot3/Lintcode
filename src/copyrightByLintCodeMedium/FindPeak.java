/**
 * 2015Äê7ÔÂ12ÈÕ
 * CH
 */
package copyrightByLintCodeMedium;

/**
 * @author CH
 *
 */
public class FindPeak {
	public int findPeak(int[] A) {
		// write your code here
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
