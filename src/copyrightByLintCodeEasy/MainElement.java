/**
 * 
 */
package copyrightByLintCodeEasy;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */
public class MainElement {
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int main = nums.get(0);
        int count = 1;
        for (int i = 1; i < nums.size(); i++){
            if (count == 0) {
                main = nums.get(i) ; 
                count += 1;
                continue;
            }
            if (nums.get(i) == main) {
                count += 1;
            }else {
                count -- ;
            }
        }
        return main;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainElement t = new MainElement();
		ArrayList<Integer> nums = new ArrayList<>();
		int[] a = {2,1,1,2,1,2,1,2,1};
		for (int i = 0; i < a.length; i++) {
			nums.add(a[i]);
		}
		System.out.println(t.majorityNumber(nums));
	}

}
