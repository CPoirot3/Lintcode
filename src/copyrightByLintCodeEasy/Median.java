/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class Median {
	public int median(int[] nums) { 
		return findKthLargest(nums, nums.length/2 + 1);
    } 
	public int findKthLargest(int[] nums, int k) {
		k = nums.length - k + 1;
//		System.out.println(k);
		return findKthLargestDigui(nums, 0, nums.length-1, k);		
	}
	public int findKthLargestDigui(int[] nums, int p, int r, int i){
		if (p == r) {
			return nums[p];
		}
		int q = partition(nums, p, r); 
		int k = q - p + 1;
		if (i == k) {
			return nums[q];
		}else if (i < k) {
			return findKthLargestDigui(nums, p, q-1, i);
		}else {
//			System.out.println("hello");
			return findKthLargestDigui(nums, q+1, r, i-k);
		}
	}
	public int partition(int[] nums, int begin, int end){
		int x = nums[end];
		int i = begin-1;
		for (int j = begin; j < end; j++) {
			if (nums[j] <= x) {
				i ++;
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
			}
		}
		int temp = nums[end];
		nums[end] = nums[i+1];
		nums[i+1] = temp;
		return i+1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Median t = new Median();
		int[] nums = {4, 5, 1, 2, 3};
//		int[] nums = {7, 9, 4, 5};
		System.out.println(t.median(nums));
	}

}
