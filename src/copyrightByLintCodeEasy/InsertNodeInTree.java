/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class InsertNodeInTree { 
	public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        //方法一 递归
//    	if (root == null) {
//			return node;
//		}
//    	if (root.val > node.val) {
//    		if (root.left == null) {
//    			root.left = node; 
//			} else {
//				root.left = insertNode(root.left, node);
//			} 
//			return root;
//		}else {
//			if (root.right == null) {
//				root.right = node;
//			}else {
//				root.right = insertNode(root.right, node);
//			}
//			return root;
//		}
    	
    	//方法二
 
    	TreeNode copy = root;
    	while (copy != null){
    		if (copy.val > node.val) {
        		if (copy.left == null) {
        			copy.left = node; 
        			return root;
    			} else {
    				copy = copy.left;
    			}  
    		}else {
    			if (copy.right == null) {
    				copy.right = node;
    				return root;
    			}else {
    				copy = copy.right;
    			} 
    		}
    	}
    	return node;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
