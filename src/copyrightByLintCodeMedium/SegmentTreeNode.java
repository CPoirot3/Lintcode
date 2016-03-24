/**
 * 2015Äê7ÔÂ12ÈÕ
 * CH
 */
package copyrightByLintCodeMedium;

/**
 * @author CH
 *
 */
public class SegmentTreeNode {
	public int start, end;
	public SegmentTreeNode left, right;

	public SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
		this.left = this.right = null;
	}
}
