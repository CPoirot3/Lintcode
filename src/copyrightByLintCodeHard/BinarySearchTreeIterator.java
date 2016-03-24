/**
 * 
 */
package copyrightByLintCodeHard;

import java.util.LinkedList;

/**
 * @author Poirot
 *
 */
public class BinarySearchTreeIterator {
	LinkedList<TreeNode> queue = new LinkedList<>();
	public BinarySearchTreeIterator(TreeNode root) {
        // write your code here
		TreeNode node = root;
		while (node != null) {
			queue.addFirst(node);
			node = node.left;
		}
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
    	return !queue.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
    	TreeNode res = queue.removeFirst();
    	TreeNode tempNode = res.right;
    	while (tempNode != null) {
    		queue.addFirst(tempNode);
    		tempNode = tempNode.left;
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
