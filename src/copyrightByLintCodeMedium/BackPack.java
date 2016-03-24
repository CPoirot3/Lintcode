/**
 * 
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class BackPack {
	
	// First Time
//    public int backPack(int m, int[] A) {
//        // write your code here
//    	int[][] res = new int[A.length][m+1];
//    	for (int i = 0; i < res[0].length; i++) {
//			if (A[A.length-1] > i) {
//				res[A.length-1][i] = 0; 
//			}else {
//				res[A.length-1][i] = A[A.length-1];
//			}
//		}
//    	for (int i = A.length-2; i >= 0; i--) {
//			for (int j = 0; j < res[0].length; j++) {
//				if (A[i] > j) {
//					res[i][j] = res[i+1][j];
//				}else {
//					res[i][j] = Math.max(res[i+1][j], res[i+1][j-A[i]] + A[i]);
//				}
//			}
//		}
//    	int result = 0;
//    	for (int i = 0; i < res.length; i++) {
//			for (int j = 0; j < res[0].length; j++) {
//				System.out.print(res[i][j] + " ");
//				if (res[i][j] <= m && res[i][j] > result) {
//					result = res[i][j];
//				}
//			}
//			System.out.println();
//		}
//    	return result;
//    	
//    }
    
	// Second Round O(N^2), O(N^2)
//    public int backPack(int m, int[] A) {
//    	int[][] dp = new int[A.length][m+1];
//        for (int j = 0; j <= m; j++) {
//            if (A[0] > j) {
//                dp[0][j] = 0;
//            } else {
//                dp[0][j] = A[0];
//            }
//        }
//        int res = 0;
//        for (int i = 1; i < A.length; i++) {
//            for (int j = 0; j <= m; j++) {
//                if (A[i] > j) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i - 1][j - A[i]] + A[i]);
//                }
//                res = Math.max(res, dp[i][j]);
//            }
//            System.out.println();
//        }
//        return res;
//    }
	
	// Second Round with modification O(N^2), O(N)
	public int backPack(int m, int[] A) {
		int[] dpA = new int[m + 1];
		int[] dpB = new int[m + 1];
		for (int j = 0; j <= m; j++) {
			if (A[0] > j) {
				dpA[j] = 0;
			} else {
				dpA[j] = A[0];
			}
		}
		int res = 0;
		for (int i = 1; i < A.length; i++) {
			int[] first = dpA;
			dpA = dpB;
			dpB = first;
			for (int j = 0; j <= m; j++) {
				if (A[i] > j) {
					dpA[j] = dpB[j];
				} else {
					dpA[j] = Math.max(dpB[j], dpB[j - A[i]] + A[i]);
				}
				res = Math.max(res, dpA[j]);
			}
			// System.out.println();
		}
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackPack t = new BackPack();
		int[] A = {3, 4, 8, 5}; 
		System.out.println(t.backPack(10, A));
	}

}
