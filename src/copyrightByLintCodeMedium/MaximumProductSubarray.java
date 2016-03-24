/**
 * 2015年7月21日
 * Poirot
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class MaximumProductSubarray {
	// DP solution
	// public int maxProduct(int[] nums) {
	// // write your code here
	// if (nums == null || nums.length == 0) {
	// return 0;
	// }
	// int res = nums[0];
	// int max_temp = nums[0];
	// int min_temp = nums[0];
	//
	// for (int i = 1; i < nums.length; i++) {
	// int a = nums[i] * max_temp;
	// int b = nums[i] * min_temp;
	// max_temp = Math.max(Math.max(a, b), nums[i]);
	// min_temp = Math.min(Math.min(a, b), nums[i]);
	// res = Math.max(res, max_temp);
	// }
	// return res;
	// }

	// my idea (lintcode 上显示更快)
	public int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE;
		int begin = 0;
		boolean hasZero = false;
		while (begin < nums.length) {
			while (begin < nums.length && nums[begin] == 0) {
				hasZero = true;
				begin++;
			}
			int end = begin;
			while (end < nums.length && nums[end] != 0) {
				end++;
			}
			int productInSection = maxProduct2(nums, begin, end - 1);
			if (productInSection > max) {
				max = productInSection;
			}
			begin = end;
		}
		if (max < 0 && hasZero) {
			return 0;
		} else {
			return max;
		}
	}

	public int maxProduct2(int[] nums, int begin, int end) {
		if (begin > end) {
			return 0;
		}
		if (begin == end) {
			return nums[begin];
		}
		int total = 1;
		int numberOfNegative = 0;
		for (int i = begin; i <= end; i++) {
			if (nums[i] < 0) {
				numberOfNegative++;
			}
			total *= nums[i];
		}
		if (numberOfNegative % 2 == 0) {
			return total;
		} else if (numberOfNegative == 1) {
			int firstNegative = 1;
			int temp = 1;
			for (int j = begin; j <= end; j++) {
				if (nums[j] < 0) {
					firstNegative = nums[j];
					break;
				}
				temp *= nums[j];
			}
			int secondPart = total / temp / firstNegative;
			return Math.max(temp, secondPart);
		} else {
			int lastNegative = 1;
			int temp = 1;
			for (int j = end; j >= begin; j--) {
				if (nums[j] < 0) {
					lastNegative = nums[j];
					break;
				}
				temp *= nums[j];
			}
			int firstPart = total / temp / lastNegative;

			int firstNegative = 1;
			temp = 1;
			for (int j = begin; j <= end; j++) {
				if (nums[j] < 0) {
					firstNegative = nums[j];
					break;
				}
				temp *= nums[j];
			}
			int secondPart = total / temp / firstNegative;
			return Math.max(firstPart, secondPart);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductSubarray t = new MaximumProductSubarray();
		int[] nums = { 2, 3, -2, 4 };
		System.out.println(t.maxProduct(nums));
	}

}
