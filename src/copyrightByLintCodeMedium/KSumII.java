/**
 * 
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Poirot
 *
 */
public class KSumII {
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        // write your code here 
    	Arrays.sort(A);
    	for (int i = 0; i <= A.length-k; i++) {
    		ArrayList<Integer> temp = new ArrayList<>();
			temp.add(A[i]);
			Digui(A,temp,i+1,k-1, target-A[i]);
		} 
    	return result;
    }  
	
	public void Digui(int[] nums, ArrayList<Integer> temp,int begin,int k, int n){
		if (k == 0 && n == 0) {
			result.add(temp);
			return;
		}else if (begin >= nums.length || n < 0) {
			return;
		}
		if (k == 0 && n > 0) {
			return;
		}else{
			for (int i = begin; i <= nums.length-k; i++) {
				ArrayList<Integer> temp1 = new ArrayList<>();
				temp1.addAll(temp);
				temp1.add(nums[i]);
				Digui(nums, temp1, i+1, k-1, n-nums[i]);
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KSumII t = new KSumII();
		int[] A = {1,2,3,4};
		ArrayList<ArrayList<Integer>> result = t.kSumII(A, 2, 5);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
