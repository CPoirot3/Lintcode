/**
 * 2015Äê7ÔÂ12ÈÕ
 * CH
 */
package copyrightByLintCodeMedium;

/**
 * @author CH
 *
 */
public class Heapify {
	public void heapify(int[] A) {
		// write your code here
		for (int i = 1; i < A.length; i++) {
			int end = i;
			while (end > 0 && A[end] < A[(end - 1) / 2]) {
				int temp = A[end];
				A[end] = A[(end - 1) / 2];
				A[(end - 1) / 2] = temp;
				end = (end - 1) / 2;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heapify t = new Heapify();
		int[] A = { 45, 39, 32, 11 };
		t.heapify(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

}
