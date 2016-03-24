/**
 * 2015Äê7ÔÂ16ÈÕ
 * Poirot
 */
package copyrightByLintCodeMedium;

import java.util.Arrays;

/**
 * @author Poirot
 *
 */
public class SmallestDifference {
	public int smallestDifference(int[] A, int[] B) {
		// write your code here
		int[] longArray = A.length > B.length ? A : B;
		int[] shortArray = A.length > B.length ? B : A;
		Arrays.sort(longArray);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < shortArray.length; i++) {
			int a = min(longArray, shortArray[i]);
			if (a == 0) {
				return 0;
			} else if (a < min) {
				min = a;
			}
		}
		return min;
	}

	public int min(int[] array, int val) {
		int begin = 0;
		int end = array.length - 1;
		while (begin < end - 1) {
			int medium = (begin + end) / 2;
			if (array[medium] < val) {
				begin = medium;
			} else if (array[medium] > val) {
				end = medium;
			} else {
				return 0;
			}
		}
		return Math.min(Math.abs(val - array[begin]), Math.abs(array[end] - val));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestDifference t = new SmallestDifference();
		int[] A = { 3, 4, 6, 7 };
		int[] B = { 2, 3, 8, 9 };
		System.out.println(t.smallestDifference(A, B));
	}

}
