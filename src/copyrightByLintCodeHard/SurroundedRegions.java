/**
 * 2016年3月5日
 * Poirot
 * 上午10:12:24
 * LintCode
 */
package copyrightByLintCodeHard;
 
/**
 * @author Poirot
 *
 */
public class SurroundedRegions {
	/**
	 * @param board
	 *            a 2D board containing 'X' and 'O'
	 * @return void
	 */
 
	int[] x = {-1, 1, 0, 0};
	int[] y = {0, 0, -1, 1};
	public void surroundedRegions(char[][] board) {
		// Write your code here
		if (board.length <= 2) {
			return;
		}
		
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				breadthFirst(board, i, 0);
			}
			if (board[i][board[0].length - 1] == 'O') {
				breadthFirst(board, i, board[0].length - 1);
			} 
		}
		
		for (int j = 0; j < board[0].length; j++) {
			if (board[0][j] == 'O') {
				breadthFirst(board, 0, j);
			}
			if (board[board.length - 1][j] == 'O') {
				breadthFirst(board, board.length - 1, j);
			} 
		} 
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'Z') {
					board[i][j] = 'O';
				}
			}
		}
	}

	public void breadthFirst(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
			return;
		}  
		board[i][j] = 'Z'; 
 
		for (int k = 0; k < x.length; k++) { 
			if (i + x[k] >= 0 && i + x[k] < board.length 
					&& j + y[k] >= 0 && j + y[k] < board[0].length) {
				if (board[i + x[k]][j + y[k]] == 'O') {
					breadthFirst(board,i + x[k], j + y[k]);
				}
			}
		}  
	} 
 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurroundedRegions t = new SurroundedRegions();
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
		t.surroundedRegions(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
