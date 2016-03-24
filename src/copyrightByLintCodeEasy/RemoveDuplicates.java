/**
 * 2015年7月19日
 * Poirot
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		// write your code here
		if (nums.length <= 1) {
			return nums.length;
		}
		// 当前的后界
		int restEnd = 0;
		int index = restEnd + 1;
		while (index < nums.length) {

			while (index < nums.length && nums[index] == nums[index - 1]) {
				index++;
			}
			if (index < nums.length) {
				nums[restEnd + 1] = nums[index];
				restEnd++;
				index++;
			}
		}
		return restEnd + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicates t = new RemoveDuplicates();
		int[] nums = { -10, 0, 1, 2, 3 };
		int length = t.removeDuplicates(nums);
		for (int i = 0; i < length; i++) {
			System.out.println(nums[i]);
		}
	}

}
