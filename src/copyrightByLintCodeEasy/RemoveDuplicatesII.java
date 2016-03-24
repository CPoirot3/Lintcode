/**
 * 2015年7月19日
 * Poirot
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class RemoveDuplicatesII {
	public int removeDuplicates(int[] nums) {
		// write your code here
		if (nums.length <= 1) {
			return nums.length;
		}
		// 当前的后界
		int restEnd = 0;
		int index = restEnd + 1;
		int count = 1;
		while (index < nums.length) {
			// if (nums[index] == nums[index-1] && count < 2) {
			// count ++;
			// index ++;
			// restEnd ++;
			// } else {
			//
			// }
			while (index < nums.length && nums[index] == nums[index - 1] && count >= 2) {
				count++;
				index++;
			}

			if (index < nums.length) {
				if (nums[index] == nums[index - 1]) {
					count++;
				} else {
					count = 1;
				}
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
		RemoveDuplicatesII t = new RemoveDuplicatesII();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int length = t.removeDuplicates(nums);
		for (int i = 0; i < length; i++) {
			System.out.println(nums[i]);
		}
	}

}
