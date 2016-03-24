/**
 * 
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class MaxPathSum {
	private int MAX= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // write your code here
    	maxPathSumCore(root);
        return MAX;
    } 
    
    int maxPathSumCore(TreeNode node) {
        if(null == node) 
        	return 0;
        int a = maxPathSumCore(node.left);
        int b = maxPathSumCore(node.right);
        if((a+b+node.val) > MAX) MAX = (a+b+node.val);
        if((a+node.val) > MAX) MAX = (a+node.val);
        if((b+node.val) > MAX) MAX = (b+node.val);
        if(node.val > MAX) MAX = node.val;

        int maxViaThisNode = ((a + node.val) > node.val ? (a + node.val) : node.val);
        return (maxViaThisNode > (b + node.val) ? maxViaThisNode : (b + node.val));
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
