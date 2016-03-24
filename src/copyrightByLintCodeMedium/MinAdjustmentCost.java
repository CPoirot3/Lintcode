/**
 * 2015年7月19日
 * Poirot
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */
// 最小调整代价
public class MinAdjustmentCost {
	public int minAdjustmentCost(ArrayList<Integer> A, int target) {
		// write your code here
		if (A == null || A.size() <= 1) {
			return 0;
		}
		int[][] dp = new int[A.size()][101];
		for (int i = 0; i < 101; i++)
			dp[0][i] = Math.abs(A.get(0) - i);
		for (int i = 1; i < A.size(); i++) {
			for (int j = 0; j < 101; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				int diff = Math.abs(j - A.get(i));
				int upper = Math.min(j + target, 100);
				int lower = Math.max(j - target, 0);
				for (int k = lower; k <= upper; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + diff);
				}
			}
		}
		int ret = Integer.MAX_VALUE;
		for (int i = 0; i < 101; i++)
			ret = Math.min(ret, dp[A.size() - 1][i]);
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 4, 2, 3 };
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			A.add(array[i]);
		}
		MinAdjustmentCost t = new MinAdjustmentCost();
		System.out.println(t.minAdjustmentCost(A, 1));
	}

}
