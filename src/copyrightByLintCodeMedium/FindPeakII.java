/**
 * 2015Äê7ÔÂ16ÈÕ
 * Poirot
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot
 *
 */
public class FindPeakII {
	public List<Integer> findPeakII(int[][] A) {
		// write your code here
		List<Integer> res = new ArrayList<>();
		if (A.length <= 2 || A[0].length <= 2) {
			return res;
		}
		int i = 1;
		int j = 1;
		while (true) {
			if (A[i][j] > A[i + 1][j] && A[i][j] > A[i - 1][j] && A[i][j] > A[i][j + 1] && A[i][j] > A[i][j - 1]) {
				res.add(i);
				res.add(j);
				return res;
			}
			if (i + 1 < A.length - 1 && A[i][j] < A[i + 1][j]) {
				i = i + 1;
				continue;
			}
			if (i - 1 > 0 && A[i][j] < A[i - 1][j]) {
				i = i - 1;
				continue;
			}
			if (j + 1 < A[0].length - 1 && A[i][j] < A[i][j + 1]) {
				j = j + 1;
				continue;
			}
			if (j - 1 > 0 && A[i][j] < A[i][j - 1]) {
				j = j - 1;
				continue;
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeakII t = new FindPeakII();
		// int[][] A = {{1 ,2 ,3 ,4
		// ,5},{16,41,23,22,6},{15,17,24,21,7},{14,18,19,20,8},{13,12,11,10,9}};
		int[][] A = { { 1, 3, 2 }, { 4, 6, 5 }, { 7, 9, 8 }, { 13, 15, 14 }, { 10, 12, 11 } };
		System.out.println(t.findPeakII(A));
	}

}
