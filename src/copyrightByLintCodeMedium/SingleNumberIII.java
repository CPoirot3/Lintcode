/**
 * 2015Äê7ÔÂ14ÈÕ
 * CH
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CH
 *
 */
public class SingleNumberIII {
	public List<Integer> singleNumberIII(int[] A) {
		// write your code here
		List<Integer> res = new ArrayList<>();
		int a = A[0];
		for (int i = 1; i < A.length; i++) {
			a ^= A[i];
		}
		// System.out.println(a);
		int power = 0;
		int temp = a;
		while (temp % 2 == 0) {
			temp /= 2;
			power++;
		}
		temp = 1 << power;
		// System.out.println("temp " +temp);
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for (int j = 0; j < A.length; j++) {
			if ((A[j] & temp) == 0) {
				list1.add(A[j]);
			} else {
				list2.add(A[j]);
			}
		}
		// System.out.println(list1.size());
		// System.out.println(list2.size());
		temp = a;
		for (int j = 0; j < list1.size(); j++) {
			temp ^= list1.get(j);
		}
		res.add(temp);
		temp = a;
		for (int j = 0; j < list2.size(); j++) {
			temp ^= list2.get(j);
		}
		res.add(temp);
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumberIII t = new SingleNumberIII();
		int[] A = { 1, 2, 3, 4, 2, 3, 4, 5, 5, 6, 9, 9, 0, 0 };
		List<Integer> res = t.singleNumberIII(A);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}

}
