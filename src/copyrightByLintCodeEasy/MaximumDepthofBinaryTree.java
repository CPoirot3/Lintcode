/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class MaximumDepthofBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
    	if (root == null) {
			return 0 ;
		} 
    	if (root.left == null && root.right == null) {
			return 1;
		}
    	if (root.left == null) {
    		return 1 + maxDepth(root.right);
		} else if (root.right == null) {
			return 1 + maxDepth(root.left);
		} else {
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
