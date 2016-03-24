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
public class ContinuousSubarraySumII {
	public class Point {
		int beginIndex;
		int endIndex;
		int sum;

		public Point(int beginIndex, int endIndex, int sum) {
			this.beginIndex = beginIndex;
			this.endIndex = endIndex;
			this.sum = sum;
		}
	}

	public Point minSubArrayInSection(int[] nums, int beginIndex, int endIndex) {
		if (nums == null || nums.length == 0 || beginIndex > endIndex)
			return new Point(-1, -1, -1);
		int begin = 0;
		int minBegin = 0;
		int minEnd = 0;
		int sum = nums[beginIndex];
		int temp = 0;
		for (int i = beginIndex; i <= endIndex; i++) {
			temp += nums[i];
			if (temp < sum) {
				sum = temp;
				minBegin = begin;
				minEnd = i;
			}
			if (temp >= 0) {
				temp = 0;
				begin = i + 1;
			}
		}
		return new Point(minBegin, minEnd, sum);
	}

	public Point maxSubArrayInSection(int[] nums, int beginIndex, int endIndex) {
		if (nums == null || nums.length == 0 || beginIndex > endIndex)
			return new Point(-1, -1, -1);
		int begin = 0;
		int maxBegin = 0;
		int maxEnd = 0;
		int sum = nums[beginIndex];
		int temp = 0;
		for (int i = beginIndex; i <= endIndex; i++) {
			temp += nums[i];
			if (temp > sum) {
				sum = temp;
				maxBegin = begin;
				maxEnd = i;
			}
			if (temp <= 0) {
				temp = 0;
				begin = i + 1;
			}
		}
		return new Point(maxBegin, maxEnd, sum);
	}

	public ArrayList<Integer> continuousSubarraySumII(int[] A) {
		// Write your code here
		ArrayList<Integer> res = new ArrayList<>();
		if (A == null || A.length == 0)
			return res;
		if (A.length == 1) {
			res.add(0);
			res.add(0);
			return res;
		}
		Point tMax = maxSubArrayInSection(A, 0, A.length - 1);

		Point tMin = minSubArrayInSection(A, 0, A.length - 1);

		if (tMin.beginIndex == 0 && tMin.endIndex == A.length - 1) {
			res.add(tMax.beginIndex);
			res.add(tMax.endIndex);
			return res;
		}
		int count = 0;
		for (int i = tMin.endIndex + 1; i < A.length; i++) {
			count += A[i];
		}
		for (int j = 0; j < tMin.beginIndex; j++) {
			count += A[j];
		}
		if (count > tMax.sum) {
			System.out.println("count " + count + " sum " + tMax.sum);
			res.add(tMin.endIndex < A.length - 1 ? tMin.endIndex + 1 : 0);
			res.add(tMin.beginIndex > 0 ? tMin.beginIndex - 1 : A.length - 1);
		} else {
			res.add(tMax.beginIndex);
			res.add(tMax.endIndex);
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContinuousSubarraySumII t = new ContinuousSubarraySumII();
		int[] A = { -101, -33, -44, -55, -67, -78, -101, -33, -44, -55, -67, -78, -100, -200, -1000, -22, -100, -200,
				-1000, -22 };// 10,-5,-9,7,7,3000,-100,-200,-10000,100000,2,-100,3,100,-2,-10000,500,7,7,7,-499,500,2000,7,7,7,3000,-100,-200,-10000,100000};//3,
								// 1, -100, -3, 4};
		// System.out.println(A.length);
		System.out.println(t.continuousSubarraySumII(A));
	}

}
