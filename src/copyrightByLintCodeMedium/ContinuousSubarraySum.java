/**
 * 2015Äê7ÔÂ17ÈÕ
 * Poirot
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */
public class ContinuousSubarraySum {

	public ArrayList<Integer> continuousSubarraySum(int[] A) {
		// Write your code here
		ArrayList<Integer> res = new ArrayList<>();
		if (A == null || A.length == 0)
			return res;
		int begin = 0;
		int maxBegin = 0;
		int maxEnd = 0;
		int sum = A[0];
		int temp = 0;
		for (int i = 0; i <= A.length - 1; i++) {
			temp += A[i];
			if (temp > sum) {
				sum = temp;
				maxBegin = begin;
				maxEnd = i;
			}
			if (temp <= 0) {
				temp = 0;
				begin = i + 1;
			}
		}

		res.add(maxBegin);
		res.add(maxEnd);
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
