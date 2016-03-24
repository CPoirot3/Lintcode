/**
 * 
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class HouseRobber {
    public long houseRobber(int[] A) {
        // write your code here
    	if (A.length == 0) {
			return 0;
		} 
    	if (A.length == 1) {
			return A[0];
		}
    	if (A.length == 2) {
    		return Math.max(A[0], A[1]);
		}
    	long a = A[0];
    	long b = A[1];
    	long res = Math.max(a, b);
    	for (int i = 2; i < A.length; i++) {
			long temp = A[i] + a;
			res = Math.max(temp, res);
			a = b;
			b = res;
		}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber t = new HouseRobber();
		int[] A = {828,125,740,724,983,321,773,678,841,842,875,377,674,144,340,467,625,916,463,922,255,662,692,123,778,766,254,559,480,483,904,60,305,966,872,935,626,691,832,998,508,657,215,162,858,179,869,674,452,158,520,138,847,452,764,995,600,568,92,496,533,404,186,345,304,420,181,73,547,281,374,376,454,438,553,929,140,298,451,674,91,531,685,862,446,262,477,573,627,624,814,103,294,388};
		System.out.println(t.houseRobber(A));
	}

}
