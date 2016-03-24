/**
 * 2015��7��12��
 * CH
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;

/**
 * @author CH
 *
 */
public class IntervalMinNumber {
	public class SegmentTreeNode {
		public int start, end, min;
		public SegmentTreeNode left, right;

		public SegmentTreeNode(int start, int end, int min) {
			this.start = start;
			this.end = end;
			this.min = min;
			this.left = this.right = null;
		}
	}

	public SegmentTreeNode build(int[] A, int start, int end) {
		// write your code here
		if (start == end) {
			return new SegmentTreeNode(start, end, A[start]);
		}
		if (start > end) {
			return null;
		}
		int medium = (start + end) / 2;
		SegmentTreeNode node = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
		node.left = build(A, start, medium);
		node.right = build(A, medium + 1, end);
		node.min = Math.min(node.left.min, node.right.min);
		return node;
	}

	public int query(SegmentTreeNode root, int start, int end) {
		// write your code here
		if (start <= root.start && end >= root.end) {
			return root.min;
		}
		int medium = (root.start + root.end) / 2;
		if (end <= medium) {
			return query(root.left, start, end);
		} else if (start > medium) {
			return query(root.right, start, end);
		} else {
			return Math.min(query(root.left, start, medium), query(root.right, medium + 1, end));
		}
	}

	public ArrayList<Integer> intervalMinNumber(int[] A, ArrayList<Interval> queries) {
		// write your code here
		ArrayList<Integer> res = new ArrayList<>();
		SegmentTreeNode root = build(A, 0, A.length - 1);
		for (int i = 0; i < queries.size(); i++) {
			res.add(query(root, queries.get(i).start, queries.get(i).end));
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntervalMinNumber t = new IntervalMinNumber();
		int[] A = { 1, 2, 7, 8, 5 };
		ArrayList<Interval> queries = new ArrayList<>();
		Interval q1 = new Interval(1, 2);
		Interval q2 = new Interval(0, 4);
		Interval q3 = new Interval(2, 4);
		queries.add(q1);
		queries.add(q2);
		queries.add(q3);
		ArrayList<Integer> res = t.intervalMinNumber(A, queries);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}

}
