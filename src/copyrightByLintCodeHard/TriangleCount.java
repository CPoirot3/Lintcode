/**
 * 2015Äê7ÔÂ16ÈÕ
 * Poirot
 */
package copyrightByLintCodeHard;

import java.util.Arrays;

/**
 * @author Poirot
 *
 */
public class TriangleCount {
	public int triangleCount(int S[]) {
		// write your code here
		Arrays.sort(S);
		int res = 0;
		for (int end1 = S.length - 1; end1 >= 2; end1--) {
			for (int end2 = end1 - 1; end2 >= 1; end2--) {
				int min = S[end1] - S[end2];
				int begin = 0;
				int end = end2 - 1;
				while (begin < end - 1) {
					int medium = (begin + end) / 2;
					if (S[medium] > min) {
						end = medium - 1;
					} else {
						begin = medium;
					}
				}
				if (S[begin] > min) {
					res += end2 - begin;
					System.out.println(res);
				} else if (S[end] > min) {
					res += end2 - end;
				} else {
					res += end2 - end - 1;
				}
			}
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TriangleCount t = new TriangleCount();
		int[] S = { 4, 4, 4, 4 };
		System.out.println(t.triangleCount(S));
	}

}
