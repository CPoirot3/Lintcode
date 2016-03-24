/**
 * 2015年7月21日
 * Poirot
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class MaximalSquare {
	public int maxSquare(int[][] matrix) {
		// write your code here
		// O(n^2) 空间 O(n)
		/*
		 * int[] resPre = new int[matrix[0].length]; int max =
		 * Integer.MIN_VALUE; for (int i = 0; i < resPre.length; i++) {
		 * resPre[i] = matrix[0][i]; if (resPre[i] > max) { max = resPre[i]; } }
		 * 
		 * int[] resCur = new int[matrix[0].length]; for (int i = 1; i <
		 * matrix.length; i++) { resCur[0] = matrix[i][0]; if (resCur[0] > max)
		 * { max = resCur[0]; } for (int j = 1; j < matrix[0].length; j++) { if
		 * (matrix[i][j] == 0) { resCur[j] = 0; } else { resCur[j] =
		 * Math.min(Math.min(resPre[j-1], resCur[j - 1]), resPre[j]) + 1; if
		 * (resCur[j] > max) { max = resCur[j]; } } } int[] temp = resPre;
		 * resPre = resCur; resCur = temp; } return max*max;
		 */
		int[] resCur = new int[matrix[0].length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < resCur.length; i++) {
			resCur[i] = matrix[0][i];
			if (resCur[i] > max) {
				max = resCur[i];
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			int curPre = matrix[i][0];
			if (curPre > max) {
				max = curPre;
			}
			int curCur = 0;
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					curCur = 0;
					resCur[j - 1] = curPre;
					curPre = curCur;
				} else {
					curCur = Math.min(Math.min(resCur[j - 1], resCur[j]), curPre) + 1;
					if (curCur > max) {
						max = curCur;
					}
					resCur[j - 1] = curPre;
					curPre = curCur;
				}
			}
			resCur[resCur.length - 1] = curCur;
		}
		return max * max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalSquare t = new MaximalSquare();
		int[][] matrix = { { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 } };
		System.out.println(t.maxSquare(matrix));
	}

}
