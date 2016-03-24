/**
 * 
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class UglyNumber {
    public long kthPrimeNumber(int k) {
        // write your code here 
    	long[] data = new long[k + 1];   
        data[0] = 1;  
        int pMul_7 = 0;  
        int pMul_3 = 0;  
        int pMul_5 = 0;  
        int index = 0;  
        while (index < k) {  
            index++;  
            long d = Math.min(Math.min(data[pMul_7] * 7, data[pMul_3] * 3), data[pMul_5] * 5);  
            data[index] = d;  
            while (data[pMul_7] * 7 == d) {  
                pMul_7++;  
            }  
            while (data[pMul_3] * 3 == d) {  
                pMul_3++;  
            }  
            while (data[pMul_5] * 5 == d) {  
                pMul_5++;  
            }  
  
        }   
        return data[k];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumber t = new UglyNumber();
		System.out.println(t.kthPrimeNumber(4));
	} 
}
