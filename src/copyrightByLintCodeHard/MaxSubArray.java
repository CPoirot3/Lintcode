/**
 * 2015��7��18��
 * Poirot
 */
package copyrightByLintCodeHard;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */
public class MaxSubArray {
	public int maxSubArray(ArrayList<Integer> nums, int k) {
		// write your code
		int[][] res = new int[nums.size() + 1][k + 1];
		for (int i = 0; i < res.length; i++) {
			res[i][0] = 0;
		}
		for (int i = 0; i < res[0].length; i++) {
			res[0][i] = 0;
		}
		int tempTotal = 0;
		for (int i = 0; i < nums.size() && i < k; i++) {
			tempTotal += nums.get(i);
			res[i + 1][i + 1] = tempTotal;
		}
		for (int i = 1; i < res.length; i++) {
			for (int j = 1; j < res[0].length; j++) {
				if (i <= j) {
					continue;
				} else {
					int max = res[i - 1][j - 1] + nums.get(i - 1);
					int count = nums.get(i - 1);
					for (int l = i - 2; l >= j - 1; l--) {
						count += nums.get(l);
						if (res[l][j - 1] + count > max) {
							max = res[l][j - 1] + count;
						}
					}
					res[i][j] = Math.max(max, res[i - 1][j]);
				}

			}
		}
		return res[nums.size()][k];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSubArray t = new MaxSubArray();
		int[] array = { 5, 4 };// 1,2,3};//-1,4,-2,3,-2,3};
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			nums.add(array[i]);
		}
		System.out.println(t.maxSubArray(nums, 2));
	}

}
