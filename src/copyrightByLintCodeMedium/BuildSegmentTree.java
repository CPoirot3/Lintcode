/**
 * 2015Äê7ÔÂ12ÈÕ
 * CH
 */
package copyrightByLintCodeMedium;

/**
 * @author CH
 *
 */
public class BuildSegmentTree {
	public SegmentTreeNode build(int start, int end) {
		// write your code here
		if (start == end) {
			return new SegmentTreeNode(start, end);
		}
		if (start > end) {
			return null;
		}
		int medium = (start + end) / 2;
		SegmentTreeNode node = new SegmentTreeNode(start, end);
		node.left = build(start, medium);
		node.right = build(medium + 1, end);
		return node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
