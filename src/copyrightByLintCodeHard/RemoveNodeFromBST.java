/**
 * 2015Äê7ÔÂ20ÈÕ
 * Poirot
 */
package copyrightByLintCodeHard;

/**
 * @author Poirot
 *
 */
public class RemoveNodeFromBST {
	public TreeNode removeNode(TreeNode root, int value) {
		// write your code here
		if (root == null) {
			return null;
		}
		TreeNode travel = root;
		TreeNode parent = null;
		boolean isLeft = true;
		while (travel != null && travel.val != value) {
			parent = travel;
			if (travel.val < value) {
				travel = travel.right;
				isLeft = false;
			} else {
				travel = travel.left;
				isLeft = true;
			}
		}
		if (travel == null) {
			return root;
		}
		if (travel.left == null) {
			if (parent == null) {
				return travel.right;
			} else {
				if (isLeft) {
					parent.left = travel.right;
				} else {
					parent.right = travel.right;
				}
				return root;
			}

		} else if (travel.right == null) {
			if (parent == null) {
				return travel.left;
			} else {
				if (isLeft) {
					parent.left = travel.left;
				} else {
					parent.right = travel.left;
				}
				return root;
			}
		} else {
			TreeNode rightNode = travel.right;
			if (rightNode.left == null) {
				rightNode.left = travel.left;
				if (parent == null) {
					return rightNode;
				} else {
					if (isLeft) {
						parent.left = rightNode;
					} else {
						parent.right = rightNode;
					}
					return root;
				}
			}
			TreeNode tempNode = rightNode.left;
			while (tempNode.left != null) {
				tempNode = tempNode.left;
				rightNode = rightNode.left;
			}
			if (tempNode.right == null) {
				rightNode.left = null;
				tempNode.left = travel.left;
				tempNode.right = travel.right;
			} else {
				rightNode.left = tempNode.right;
				tempNode.left = travel.left;
				tempNode.right = travel.right;
			}
			if (parent == null) {
				return tempNode;
			} else {
				if (isLeft) {
					parent.left = tempNode;
				} else {
					parent.right = tempNode;
				}
				return root;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveNodeFromBST t = new RemoveNodeFromBST();
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		root.right = root2;
		root2.right = root3;
		root3.right = root4;
		root4.right = root5;
		TreeNode res = t.removeNode(root, 3);
		while (res != null) {
			System.out.println(res.val);
			res = res.right;
		}
	}

}
