/**
 * 
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poirot
 *
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        // write your code here
    	return forCall(1, n);
    }
    
    public List<TreeNode> forCall(int begin , int end) {
    	if (begin > end) {
			List<TreeNode> res = new ArrayList<>();
			res.add(null);
			return res;
		}
    	List<TreeNode> res = new ArrayList<>();
    	for (int rootIndex = begin; rootIndex <= end; rootIndex++) {
    		List<TreeNode> leftTree = forCall(begin, rootIndex-1);
    		List<TreeNode> rightTree = forCall(rootIndex+1, end);
    		for (int i = 0; i < leftTree.size(); i++) {
				for (int j = 0; j < rightTree.size(); j++) {
					TreeNode rootNode = new TreeNode(rootIndex);
					rootNode.left = leftTree.get(i);
					rootNode.right = rightTree.get(j);
					res.add(rootNode);
				}
			}
		}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
