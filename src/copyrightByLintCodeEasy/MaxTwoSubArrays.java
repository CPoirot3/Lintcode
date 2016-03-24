/**
 * 
 */
package copyrightByLintCodeEasy;

import java.util.ArrayList; 

/**
 * @author Poirot
 *
 */
public class MaxTwoSubArrays {
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
    	if (nums == null || nums.size() == 0)
			return 0;
    	if (nums.size() == 1) {
			return nums.get(0) + nums.get(1);
		}
    	int res = Integer.MIN_VALUE;
//    	boolean mark = false;
		for (int i = 0; i < nums.size()-1; i++) {
			int tempRes = maxSubArrayInSection(nums, 0,  i) + maxSubArrayInSection(nums, i+1, nums.size()-1);
//			System.out.println(tempRes);
			if (tempRes > res) {
				res = tempRes;
			}
//			mark = true;
		}
//		if (!mark) {
//			res = 0;
//			for (int i = 0; i < nums.size()-1; i++) {
//				res+= nums.get(i);
//			}
//			if (nums.get(nums.size()-1) > 0) {
//				res+= nums.get(nums.size()-1);
//			}
//			return res;
//		}
		return res;
    }
    public int maxSubArrayInSection(ArrayList<Integer> nums, int beginIndex , int endIndex) {
    	if (nums == null || nums.size() == 0 || beginIndex > endIndex)
			return 0;
		int sum = nums.get(beginIndex);
//		int begin = beginIndex;
//		int end = beginIndex;
		int temp = 0;
		for (int i = beginIndex; i <= endIndex; i++) {
			temp += nums.get(i);
			if (temp > sum) {
				sum = temp;
//				end = i;
			}
			if (temp <= 0) {
				temp = 0;
//				begin = i+1;
			}
		}
//		System.out.println(begin + " " + end);
		return sum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxTwoSubArrays t = new MaxTwoSubArrays();
		int[] array = { -1,0,1};//-2, 100, -3, 4, -1, 2, 1, -5, 3 };
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			nums.add(array[i]);
		}
		System.out.println(t.maxTwoSubArrays(nums));
	}

}
