/**
 * 
 */
package copyrightByLintCodeEasy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot
 *
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
    	
    	// superlendid
    	if (triangle.size() == 0) {
    		return 0;
    	}
    	List<Integer> tempList = new ArrayList<>(); 
    	tempList.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
        	List<Integer> temp = new ArrayList<Integer>(); 
    		for (int j = 0; j < triangle.get(i).size(); j++) {
    			if (i-1>=0 && j==0) {
    				temp.add(tempList.get(j)+triangle.get(i).get(j));
    			}else if (i-1>=0 && j==triangle.get(i).size()-1) {
    				temp.add(tempList.get(j-1)+triangle.get(i).get(j));
    			}else {
    				temp.add(Math.min(tempList.get(j-1), tempList.get(j))+triangle.get(i).get(j));
    			}
    		}
    		tempList = temp;
    	} 
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < tempList.size(); i++) {
    		if (tempList.get(i) < result) {
    			result = tempList.get(i);
    		}
    	}
        return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
