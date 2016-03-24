/**
 * 2015Äê7ÔÂ12ÈÕ
 * CH
 */
package copyrightByLintCodeMedium;

/**
 * @author CH
 *
 */
public class QuerySegmentTree {
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

	public int query(SegmentTreeNode root, int start, int end) {
		// write your code here
		if (start <= root.start && end >= root.end) {
			return root.max;
		}
		int medium = (root.start + root.end) / 2;
		if (end <= medium) {
			return query(root.left, start, end);
		} else if (start > medium) {
			return query(root.right, start, end);
		} else {
			return Math.max(query(root.left, start, medium), query(root.right, medium + 1, end));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
