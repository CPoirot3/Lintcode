/**
 * 
 */
package copyrightByLintCodeEasy;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */
public class MinSubArray {
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
    	if (nums == null || nums.size() == 0)
			return 0;
		int sum = nums.get(0);
		int temp = 0;
		for (int i = 0; i < nums.size(); i++) {
			temp += nums.get(i);
			if (temp < sum)
				sum = temp;
			if (temp >= 0) {
				temp = 0;
			}
		}
		return sum;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinSubArray t = new MinSubArray();
		int[] array = { -2, 100, -3, 4, -1, 2, 1, -5, 3 };
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			nums.add(array[i]);
		}
		System.out.println(t.minSubArray(nums));
	}

}
