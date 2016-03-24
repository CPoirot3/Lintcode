/**
 * 2015Äê7ÔÂ17ÈÕ
 * Poirot
 */
package copyrightByLintCodeHard;

import java.util.Stack;

/**
 * @author Poirot
 *
 */
public class MaxTree {
	public TreeNode maxTree(int[] A) {
		// write your code here
		if (A.length == 0)
			return null;

		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(new TreeNode(A[0]));
		for (int i = 1; i < A.length; i++) {
			if (A[i] <= nodeStack.peek().val) {
				TreeNode node = new TreeNode(A[i]);
				nodeStack.push(node);
			} else {
				TreeNode n1 = nodeStack.pop();
				while (!nodeStack.isEmpty() && nodeStack.peek().val < A[i]) {
					TreeNode n2 = nodeStack.pop();
					n2.right = n1;
					n1 = n2;
				}
				TreeNode node = new TreeNode(A[i]);
				node.left = n1;
				nodeStack.push(node);
			}
		}
		TreeNode root = nodeStack.pop();
		while (!nodeStack.isEmpty()) {
			nodeStack.peek().right = root;
			root = nodeStack.pop();
		}

		return root;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
