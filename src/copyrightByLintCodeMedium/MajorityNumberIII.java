/**
 * 2015年7月11日
 * CH
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;

/**
 * @author CH
 *
 */
public class MajorityNumberIII {
	public int majorityNumber(ArrayList<Integer> nums, int k) {
		// write your code
		int[] count = new int[k];
		int[] candidate = new int[k];
		for (int j = 0; j < candidate.length; j++) {
			candidate[j] = nums.get(0);
		}
		for (int i = 1; i < nums.size(); i++) {
			int n = nums.get(i);
			boolean mark = false;
			for (int j = 0; j < candidate.length; j++) {
				if (n == candidate[j]) {
					count[j]++;
					mark = true;
					break;
				}
			}
			if (!mark) {
				boolean a = false;
				for (int j = 0; j < candidate.length; j++) {
					if (count[j] == 0) {
						candidate[j] = n;
						count[j] = 1;
						a = true;
						break;
					}
				}
				if (!a) {
					// 如果没有计算是0的
					for (int j = 0; j < candidate.length; j++) {
						count[j] = count[j] - 1;
					}
				}
			}
		}

		for (int j = 0; j < candidate.length; j++) {
			count[j] = 0;
		}
		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < candidate.length; j++) {
				if (nums.get(i) == candidate[j]) {
					count[j]++;
					break;
				}
			}
		}

		// for (int m = 0; m < candidate.length; m++) {
		// System.out.print(candidate[m]+" ");
		// }
		// System.out.println();
		for (int i = 0; i < candidate.length; i++) {

			if (count[i] > nums.size() / k) {
				return candidate[i];
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityNumberIII t = new MajorityNumberIII();
		int[] array = { 7, 1, 7, 7, 61, 61, 61, 10, 10, 10, 61 };
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			nums.add(array[i]);
		}
		System.out.println(t.majorityNumber(nums, 3));
	}

}
