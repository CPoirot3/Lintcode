/**
 * 2016年2月24日
 * Poirot
 * 下午10:36:21
 * LintCode
 */
package copyrightByLintCodeHard;
 

/**
 * @author Poirot
 *
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        // write your code here
    	if (nums.length < 2) {
    		return 0;
    	}
    	
        int[][] bucket = new int[nums.length + 1][2];
        boolean[] hasNum = new boolean[nums.length + 1];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
        	 if (nums[i] < min) {
        		 min = nums[i];
        	 } 
        	 if (nums[i] > max) {
        		 max = nums[i];
        	 }
        }
        if (max == min) {
        	return 0;
        }
//        System.out.println(max + " " + min);
        for (int i = 0; i < nums.length; i++) {
        	int index = (int) (((long)nums[i] - min) *  (bucket.length - 1) / (max - min));
//        	System.out.println(index);
        	bucket[index][0] = hasNum[index] ? Math.min(nums[i], bucket[index][0]) : nums[i];
        	bucket[index][1] = hasNum[index] ? Math.max(nums[i], bucket[index][1]) : nums[i];
        	hasNum[index] = true;
        }
          
        int res = 0;
        int lastMax = bucket[0][1];
        for (int i = 1; i < hasNum.length; i++) {
			if (hasNum[i]) {
				res = Math.max(res, bucket[i][0] - lastMax);
				lastMax = bucket[i][1];  
			}
		}
        return res;
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
//		int[] nums = {100,3,2,1};
		MaximumGap t = new MaximumGap();
		System.out.println(t.maximumGap(nums));
	}

}
