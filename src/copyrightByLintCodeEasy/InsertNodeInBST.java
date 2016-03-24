/**
 * 2015年7月20日
 * Poirot
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class InsertNodeInBST {
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		// write your code here

		// 方法一 递归
		// if (root == null) {
		// return node;
		// } else if (root.val < node.val && root.right == null) {
		// root.right = node;
		// return root;
		// } else if (root.val > node.val && root.left == null) {
		// root.left = node;
		// return root;
		// } else {
		// if (root.val < node.val) {
		// root.right = insertNode(root.right, node);
		// return root;
		// } else {
		// root.left = insertNode(root.left, node);
		// return root;
		// }
		// }

		// 方法二
		if (root == null) {
			return node;
		} else if (root.val < node.val && root.right == null) {
			root.right = node;
			return root;
		} else if (root.val > node.val && root.left == null) {
			root.left = node;
			return root;
		} else {
			TreeNode parent = null;
			TreeNode travel = root;
			while (travel != null) {
				parent = travel;
				if (node.val < travel.val) {
					travel = travel.left;
				} else {
					travel = travel.right;
				}
			}
			if (node.val < parent.val) {
				parent.left = node;
			} else {
				parent.right = node;
			}
			return root;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
