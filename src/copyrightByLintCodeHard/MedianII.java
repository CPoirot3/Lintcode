/**
 * 2015Äê7ÔÂ16ÈÕ
 * Poirot
 */
package copyrightByLintCodeHard;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */
public class MedianII {
	public int[] medianII(int[] nums) {
		// write your code here
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			add(list, nums[i]);
			nums[i] = list.get(i / 2);
		}
		return nums;
	}

	public void add(ArrayList<Integer> list, int value) {
		if (list.size() == 0) {
			list.add(value);
			return;
		}
		int begin = 0;
		int end = list.size() - 1;
		while (begin < end) {
			int medium = (begin + end) / 2;
			if (list.get(medium) < value) {
				begin = medium + 1;
			} else if (list.get(medium) > value) {
				end = medium - 1;
			} else {
				list.add(medium, value);
				return;
			}
		}
		if (list.get(begin) > value) {
			list.add(begin, value);
		} else {
			list.add(begin + 1, value);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianII t = new MedianII();
		int[] nums = { 4, 5, 1, 3, 2, 6, 0 };
		int[] res = t.medianII(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
