/**
 * 
 */
package copyrightByLintCodeHard;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList; 

/**
 * @author Poirot
 *
 */
public class MedianSlidingWindow {
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
    	
    	int odd = k % 2 == 0 ? k-1 : k; 
    	ArrayList<Integer> res = new ArrayList<>();
    	if (nums.length == 0) {
			return res;
		}
    	int[] tempArray = new int[k];
    	for (int i = 0; i < k; i++) {
			tempArray[i] = nums[i];
		}
    	Arrays.sort(tempArray); 
    	LinkedList<Integer> window = new LinkedList<Integer>();
    	for (int i = 0; i < tempArray.length; i++) {
			window.add(tempArray[i]);
		}
    	res.add(window.get(odd/2));
    	int begin = 0;
    	int end = begin+k-1;
    	while(end+1 < nums.length){
    		window.removeFirstOccurrence(nums[begin]);
    		int index = 0;
    		Iterator<Integer> itr = window.iterator();
    		while(itr.hasNext() && nums[end+1] > itr.next()){
    			index++;
    		}
    		window.add(index, nums[end+1]);
    		begin++;
    		end++;  
        	res.add(window.get(odd/2));
    	}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianSlidingWindow t = new MedianSlidingWindow();
		int[] nums = {1,2,7,7,2,10,3,4,5};
		int k = 2;
		ArrayList<Integer> res = t.medianSlidingWindow(nums, k);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i)+" ");
		}
	}

}
