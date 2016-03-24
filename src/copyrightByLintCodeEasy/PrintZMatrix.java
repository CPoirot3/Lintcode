/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class PrintZMatrix {
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
    	int[] res = new int[matrix.length*matrix[0].length];
    	int m = matrix.length;
    	int n = matrix[0].length;
    	boolean direction = true;
    	int i = 0;
    	int j = 0;
    	int k = 0;
    	while (i <= m-1 && j <= n-1){ 
    		res[k] = matrix[i][j];
    		k++;
    		if (direction) {
				if (i == 0 && j < n-1) {
					j++;
					direction = !direction;
				}else if (j == n-1){
					i++;
					direction = !direction;
				}else {
					i--;
					j++;
				}
			}else {
				if (j == 0 && i < m-1) {
					i++;
					direction = !direction;
				}else if (i == m-1) {
					j++;
					direction = !direction;
				}else {
					i++;
					j--;
				}
			}
    	}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintZMatrix t = new PrintZMatrix();
		int[][] matrix = {{1, 2,  3,  4 },{5, 6,  7,  8},{9,10, 11, 12}};
		int[] res = t.printZMatrix(matrix);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
