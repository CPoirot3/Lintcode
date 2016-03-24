/**
 * 
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class NextPermutation {
    public int[] nextPermutation(int[] nums) {
        // write your code here
    	int[] result = new int[nums.length];
		if (nums.length== 0) {
			return nums;
		}
		int end = nums.length - 1;
		while (end > 0 && nums[end] <= nums[end - 1]) {
			end--;
		}
//		System.out.println(end); 
		if (end == 0) {
			for (int i = nums.length - 1; i >= 0; i--) {
				result[nums.length-1-i] = nums[i];
			} 
		}else {
			end -- ;
			int value = nums[end];
			int begin = end + 1;
			while (begin < nums.length && nums[begin] > value){ 
				begin++;
			}
			nums[end] = nums[begin-1];
			nums[begin-1] = value; 
			for (int i = 0; i <= end; i++) {
				result[i] = nums[i];
			}
			for (int i = nums.length -1; i > end; i--) {
				result[end + nums.length -i] = nums[i];
			}
		}
		return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation t = new NextPermutation();
		int[] nums = {1,3,2,3};
		int[] res = t.nextPermutation(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
