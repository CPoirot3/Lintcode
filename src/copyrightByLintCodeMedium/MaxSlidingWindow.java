/**
 * 2015Äê7ÔÂ17ÈÕ
 * Poirot
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author Poirot
 *
 */
public class MaxSlidingWindow {
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		// write your code here

		ArrayList<Integer> res = new ArrayList<>();
		if (nums.length == 0) {
			return res;
		}
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();

		for (int i = 0; i < k; i++) {
			treeMap.put(nums[i], treeMap.containsKey(nums[i]) ? treeMap.get(nums[i]) + 1 : 1);
		}

		res.add(treeMap.descendingKeySet().first());
		// System.out.println(treeMap);
		int begin = 0;
		int end = k - 1;
		while (end + 1 < nums.length) {
			if (treeMap.get(nums[begin]) == 1) {
				treeMap.remove(nums[begin]);
			} else {
				treeMap.put(nums[begin], treeMap.get(nums[begin]) - 1);
			}
			treeMap.put(nums[end + 1], treeMap.containsKey(nums[end + 1]) ? treeMap.get(nums[end + 1]) + 1 : 1);
			begin++;
			end++;
			res.add(treeMap.descendingKeySet().first());
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSlidingWindow t = new MaxSlidingWindow();
		int[] nums = { 1, 2, 7, 7, 2, 10, 3, 4, 5 };
		System.out.println(t.maxSlidingWindow(nums, 2));
	}

}
