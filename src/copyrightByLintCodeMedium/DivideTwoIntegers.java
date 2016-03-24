/**
 * 2015年9月13日
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
//        // Write your code here
//        if (divisor == 1) // Trival case 1
//            return dividend;
//
//        // Use negative integers to avoid integer overflow
//        if (dividend > 0)
//            return -divide(-dividend, divisor);
//        if (divisor > 0)
//            return -divide(dividend, -divisor);
//
//        if (dividend > divisor) // Trivial case 2
//            return 0;
//
//        if ((dividend == Integer.MIN_VALUE) && (divisor == -1)) // Overflow case
//            return Integer.MAX_VALUE;
//
//        // Find the highest mult = (divisor * 2^shifts) which is <= dividend
//        // by shifting mult to the left without causing an overflow.
//        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations.
//        int min_divisor = Integer.MIN_VALUE >> 1;
//        int mult = divisor; // = divisor * 2^shifts
//        int shifts = 0;
//        while ((mult >= min_divisor) && (mult > dividend)) {
//            mult <<= 1;
//            ++shifts;
//        }
//
//        // Compute the result by shifting mult to the right.
//        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the outer loop.
//        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the inner loop
//        // (in total, not per outer iteration).
//        int result = 0;
//        int power = 1 << shifts; // = 2^shifts
//        while (dividend <= divisor) {
//            shifts = 0;
//            while (mult < dividend) {
//                mult >>= 1;
//                ++shifts;
//            }
//            dividend -= mult;
//            power >>= shifts;
//            result |= power; // Adds power to result
//        }
//
//        return result;
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
		long ans=0;
	    long n=Math.abs((long)dividend);
	    long d=Math.abs((long)divisor);
	    while(n>=d){
	    	long a=d;
	    	long m=1;
	        while((a<<1) < n){a<<=1;m<<=1;}
	        ans+=m;
	        n-=a;
	    }
	    if((dividend<0&&divisor>=0)||(dividend>=0&&divisor<0))
	        return (int)-ans;
	    return (int)ans;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
