/**
 * 
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;  
/**
 * @author Poirot
 *
 */
public class PreviousPermuation {
	public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		ArrayList<Integer> result = new ArrayList<>();
		if (nums == null || nums.size() == 0) {
			return result;
		}
		int end = nums.size() - 1;
		while (end > 0 && nums.get(end) >= nums.get(end - 1)) {
			end--;
		}
//		System.out.println(end); 
		if (end == 0) {
			for (int i = nums.size() - 1; i >= 0; i--) {
				result.add(nums.get(i));
			} 
		}else {
			end -- ;
			int begin = end + 1;
			int value = nums.get(end); 
			while (begin < nums.size() && nums.get(begin) < value){ 
				begin++;
			}
			nums.set(end, nums.get(begin-1));
			nums.set(begin-1, value); 
			for (int i = 0; i <= end; i++) {
				result.add(nums.get(i));
			}
			for (int i = nums.size() -1; i > end; i--) {
				result.add(nums.get(i));
			}
		}
		return result;
	}

	// public boolean isSorted(ArrayList<Integer> nums){
	// for (int i = 0; i < nums.size()-1; i++) {
	// if (nums.get(i) > nums.get(i+1)) {
	// return false;
	// }
	// }
	// return true;
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreviousPermuation t = new PreviousPermuation();
		ArrayList<Integer> nums = new ArrayList<>();
		int[] array = {1,2,3,4};
		for (int i = 0; i < array.length; i++) {
			nums.add(array[i]);
		}
		ArrayList<Integer> res = t.previousPermuation(nums);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " "); 
		}
	}

}
