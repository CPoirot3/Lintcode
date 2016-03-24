/**
 * 2015Äê7ÔÂ12ÈÕ
 * CH
 */
package copyrightByLintCodeMedium;

/**
 * @author CH
 *
 */
public class ModifySegmentTree {
	public class SegmentTreeNode {
		public int start, end, max;
		public SegmentTreeNode left, right;

		public SegmentTreeNode(int start, int end, int max) {
			this.start = start;
			this.end = end;
			this.max = max;
			this.left = this.right = null;
		}
	}

	public void modify(SegmentTreeNode root, int index, int value) {
		// write your code here
		if (index < root.start || index > root.end) {
			return;
		}
		if (root.start == root.end) {
			root.max = value;
			return;
		}
		int medium = (root.start + root.end) / 2;

		if (index <= medium) {
			modify(root.left, index, value);
			root.max = Math.max(root.left.max, root.right.max);
		} else {
			modify(root.right, index, value);
			root.max = Math.max(root.left.max, root.right.max);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
