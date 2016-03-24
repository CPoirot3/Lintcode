/**
 * 2015年7月18日
 * Poirot
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */

// 排序矩阵中的从小到大第k个数
public class KthSmallestInMatrix {
	public class Point {
		int row;
		int col;
		int val;

		Point(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}

	public class MinHeap {
		ArrayList<Point> list;

		public MinHeap() {
			// TODO Auto-generated constructor stub
			list = new ArrayList<>();
		}

		public void add(Point p) {
			list.add(p);
			int end = list.size() - 1;
			while (end > 0 && list.get(end).val < list.get((end - 1) / 2).val) {
				Point temp = list.get(end);
				list.set(end, list.get((end - 1) / 2));
				list.set((end - 1) / 2, temp);
				end = (end - 1) / 2;
			}
		}

		public Point removeMin() {
			if (list.size() == 0) {
				return null;
			} else {
				Point res = list.remove(0);
				if (list.size() <= 1) {
					return res;
				}
				Point temp = list.remove(list.size() - 1);
				list.add(0, temp);
				int begin = 0;
				while (begin * 2 + 1 < list.size()) {
					if (begin * 2 + 2 < list.size()) {
						if (list.get(begin).val < list.get(begin * 2 + 1).val
								&& list.get(begin).val < list.get(begin * 2 + 2).val) {
							break;
						}
						if (list.get(begin * 2 + 1).val < list.get(begin * 2 + 2).val) {
							Point tempPoint = list.get(begin);
							list.set(begin, list.get(begin * 2 + 1));
							list.set(begin * 2 + 1, tempPoint);
							begin = begin * 2 + 1;
						} else {
							Point tempPoint = list.get(begin);
							list.set(begin, list.get(begin * 2 + 2));
							list.set(begin * 2 + 2, tempPoint);
							begin = begin * 2 + 2;
						}
					} else {
						if (list.get(begin).val < list.get(begin * 2 + 1).val) {
							break;
						}
						Point tempPoint = list.get(begin);
						list.set(begin, list.get(begin * 2 + 1));
						list.set(begin * 2 + 1, tempPoint);
						begin = begin * 2 + 1;
					}
				}
				return res;
			}
		}
	}

	public int kthSmallest(int[][] matrix, int k) {
		// write your code here
		if (matrix.length == 1) {
			return matrix[0][k - 1];
		}
		if (matrix[0].length == 1) {
			return matrix[k - 1][0];
		}

		boolean[][] matrix1 = new boolean[matrix.length][matrix[0].length];
		MinHeap minHeap = new MinHeap();
		minHeap.add(new Point(0, 0, matrix[0][0]));
		matrix1[0][0] = true;
		for (int i = 0; i < k - 1; i++) {
			Point min = minHeap.removeMin();
			// System.out.println(minHeap.list.size());
			// for (int j = 0; j < minHeap.list.size(); j++) {
			// System.out.print(minHeap.list.get(j).val+ " ");
			// }
			// System.out.println();
			// System.out.println("i "+ i + " "+min.val +" "
			// +minHeap.list.size());
			if (min.row + 1 < matrix.length && matrix1[min.row + 1][min.col] != true) {
				Point addOne = new Point(min.row + 1, min.col, matrix[min.row + 1][min.col]);
				minHeap.add(addOne);
				matrix1[min.row + 1][min.col] = true;
			}
			if (min.col + 1 < matrix[0].length && matrix1[min.row][min.col + 1] != true) {
				Point addOne = new Point(min.row, min.col + 1, matrix[min.row][min.col + 1]);
				minHeap.add(addOne);
				matrix1[min.row][min.col + 1] = true;
			}
		}
		return minHeap.removeMin().val;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2 }, { 3, 1122 } };// {{1 ,5 ,7},{3 ,7 ,8},{4 ,8
													// ,9}};
		KthSmallestInMatrix t = new KthSmallestInMatrix();
		System.out.println(t.kthSmallest(matrix, 4));
	}

}
