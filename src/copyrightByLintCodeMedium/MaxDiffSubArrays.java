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
public class MaxDiffSubArrays {

	public int maxDiffSubArrays(ArrayList<Integer> nums) {
		// write your code
		if (nums == null || nums.size() == 0)
			return 0;
		if (nums.size() == 1) {
			return nums.get(0) + nums.get(1);
		}
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size() - 1; i++) {
			int tempRes = Math
					.abs(maxSubArrayInSection(nums, 0, i) - minSubArrayInSection(nums, i + 1, nums.size() - 1));

			if (tempRes > res) {
				res = tempRes;
			}
			tempRes = Math.abs(minSubArrayInSection(nums, 0, i) - maxSubArrayInSection(nums, i + 1, nums.size() - 1));

			if (tempRes > res) {
				res = tempRes;
			}
		}
		return res;
	}

	public int maxSubArrayInSection(ArrayList<Integer> nums, int beginIndex, int endIndex) {
		if (nums == null || nums.size() == 0 || beginIndex > endIndex)
			return 0;
		int sum = nums.get(beginIndex);
		int temp = 0;
		for (int i = beginIndex; i <= endIndex; i++) {
			temp += nums.get(i);
			if (temp > sum) {
				sum = temp;
			}
			if (temp <= 0) {
				temp = 0;
			}
		}
		return sum;
	}

	public int minSubArrayInSection(ArrayList<Integer> nums, int beginIndex, int endIndex) {
		if (nums == null || nums.size() == 0 || beginIndex > endIndex)
			return 0;
		int sum = nums.get(beginIndex);
		int temp = 0;
		for (int i = beginIndex; i <= endIndex; i++) {
			temp += nums.get(i);
			if (temp < sum) {
				sum = temp;
			}
			if (temp >= 0) {
				temp = 0;
			}
		}
		return sum;
	}

	// public class Point {
	// int beginIndex;
	// int endIndex;
	// int sum;
	//
	// public Point(int beginIndex, int endIndex, int sum) {
	// // TODO Auto-generated constructor stub
	// this.beginIndex = beginIndex;
	// this.endIndex = endIndex;
	// this.sum = sum;
	// }
	// }
	//
	// public int maxDiffSubArrays(ArrayList<Integer> nums) {
	// // write your code
	// if (nums == null || nums.size() == 0)
	// return 0;
	// if (nums.size() == 1) {
	// return nums.get(0) + nums.get(1);
	// }
	//
	// Point maxSection = maxSubArrayInSection(nums, 0, nums.size() - 1);
	// int begin = maxSection.beginIndex;
	// int end = maxSection.endIndex;
	//
	// // System.out.println(begin + " " + end + " " + maxSection.sum);
	// if (begin > 0 && end < nums.size() - 1) {
	// Point left = minSubArrayInSection(nums, 0, begin - 1);
	// Point right = minSubArrayInSection(nums, end + 1, nums.size() - 1);
	// int resCandidate = Math.max(Math.abs(maxSection.sum - left.sum),
	// Math.abs(maxSection.sum - right.sum));
	//
	// Point minSection = minSubArrayInSection(nums, 0, nums.size() - 1);
	// begin = minSection.beginIndex;
	// end = minSection.endIndex;
	// if (begin > 0 && end < nums.size() - 1) {
	// left = maxSubArrayInSection(nums, 0, begin - 1);
	// right = maxSubArrayInSection(nums, end + 1, nums.size() - 1);
	// int resCandidate2 = Math.max(Math.abs(minSection.sum - left.sum),
	// Math.abs(minSection.sum - right.sum));
	// return Math.max(resCandidate, resCandidate2);
	// } else if (begin > 0) {
	// return Math.abs(minSection.sum - maxSubArrayInSection(nums, 0, begin -
	// 1).sum);
	// } else if (end < nums.size() - 1) {
	// return Math.abs(minSection.sum - maxSubArrayInSection(nums, end + 1,
	// nums.size() - 1).sum);
	// } else {
	// return Math.abs(minSection.sum);
	// }
	// } else if (begin > 0) {
	// return Math.abs(maxSection.sum - minSubArrayInSection(nums, 0, begin -
	// 1).sum);
	// } else if (end < nums.size() - 1) {
	// return Math.abs(maxSection.sum - minSubArrayInSection(nums, end + 1,
	// nums.size() - 1).sum);
	// } else {
	// return Math.abs(maxSection.sum);
	// }
	// }
	//
	// public Point maxSubArrayInSection(ArrayList<Integer> nums, int
	// beginIndex, int endIndex) {
	// if (nums == null || nums.size() == 0 || beginIndex > endIndex)
	// return new Point(-1, -1, -1);
	// int begin = 0;
	// int maxBegin = 0;
	// int maxEnd = 0;
	// int sum = nums.get(beginIndex);
	// int temp = 0;
	// for (int i = beginIndex; i <= endIndex; i++) {
	// temp += nums.get(i);
	// if (temp > sum) {
	// sum = temp;
	// maxBegin = begin;
	// maxEnd = i;
	// }
	// if (temp <= 0) {
	// temp = 0;
	// begin = i + 1;
	// }
	// }
	// return new Point(maxBegin, maxEnd, sum);
	// }
	//
	// public Point minSubArrayInSection(ArrayList<Integer> nums, int
	// beginIndex, int endIndex) {
	// if (nums == null || nums.size() == 0 || beginIndex > endIndex)
	// return new Point(-1, -1, -1);
	// int begin = 0;
	// int minBegin = 0;
	// int minEnd = 0;
	// int sum = nums.get(beginIndex);
	// int temp = 0;
	// for (int i = beginIndex; i <= endIndex; i++) {
	// temp += nums.get(i);
	// if (temp < sum) {
	// sum = temp;
	// minBegin = begin;
	// minEnd = i;
	// }
	// if (temp >= 0) {
	// temp = 0;
	// begin = i + 1;
	// }
	// }
	// return new Point(minBegin, minEnd, sum);
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDiffSubArrays t = new MaxDiffSubArrays();
		ArrayList<Integer> nums = new ArrayList<>();
		int[] array = { 1, -100, 10, -100, 1 };// 1, 2, -3, 1 };
		for (int i = 0; i < array.length; i++) {
			nums.add(array[i]);
		}
		System.out.println(t.maxDiffSubArrays(nums));
	}

}
