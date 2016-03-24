/**
 * 2016年3月14日
 * Poirot
 * 下午3:17:41
 * LintCode
 */
package copyrightByLintCodeHard;

/**
 * @author Poirot
 *
 */
public class MedianoftwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
    	if (A.length == 0) {
    		return findMedian(B);
    	}
    	if (B.length == 0) {
    		return findMedian(A);
    	}
    	
    	
    }
    public double findMedian(int[] nums) {
    	if (nums.length % 2 == 1) {
    		return nums[nums.length / 2];
    	} else {
			return ((double)nums[nums.length / 2 - 1] + nums[nums.length / 2] ) / 2;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
