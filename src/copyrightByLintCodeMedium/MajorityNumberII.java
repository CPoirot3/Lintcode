/**
 * 2015Äê7ÔÂ11ÈÕ
 * CH
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;

/**
 * @author CH
 *
 */
public class MajorityNumberII {
	public int majorityNumber(ArrayList<Integer> nums) {
		// write your code
		int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
		for (int i = 0; i < nums.size(); i++) {
			int n = nums.get(i);
			if (n == candidate1) {
				count1 += 1;
			} else if (n == candidate2) {
				count2 += 1;
			} else if (count1 == 0) {
				candidate1 = n;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = n;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
			// System.out.println(count1 +" " + count2);
		}
		// System.out.println(candidate1 +" "+candidate2);
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) == candidate1) {
				count1++;
			}
			if (nums.get(i) == candidate2) {
				count2++;
			}
		}
		System.out.println(candidate1 + "  " + candidate2);
		if (count1 > nums.size() / 3) {
			return candidate1;
		}
		if (count2 > nums.size() / 3) {
			return candidate2;
		}
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityNumberII t = new MajorityNumberII();
		int[] array = { 0, 0, 1, 1, 2 };
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			nums.add(array[i]);
		}
		System.out.println(t.majorityNumber(nums));
	}

}
