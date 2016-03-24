/**
 * 2016年2月26日
 * Poirot
 * 下午10:11:25
 * LintCode
 */
package copyrightByLintCodeHard;

/**
 * @author Poirot
 *
 */
public class BinaryRepresentation {
	public String binaryRepresentation(String string) {
        // write your code here
    	int indexOfPoint = 0;
    	while (indexOfPoint < string.length() && string.charAt(indexOfPoint) != '.') {
    		indexOfPoint++;
    	}
    	if (indexOfPoint >= string.length()) {
    		int a = Integer.valueOf(string); 
    		return binaryOfInteger(a);
    	}
    	
    	Double a = Double.valueOf(string);
    	double b = a; 
    	String pre = binaryOfInteger((int)b); 
    	double fraction = a - ((int)b); 
    	if (fraction == 0) {
    		return pre;
    	}
    	
    	
//    	System.out.println(fraction);
    	String fracString =  string.substring(indexOfPoint + 1);
//    	System.out.println(fracString);
    	String resString  = multiply(fracString, "4294967296");
    	 
    	double temp = Double.valueOf(resString) / Math.pow(10, fracString.length()); 
//    	System.out.println(temp);
     	if (temp - ((long)temp) != 0) {
    		return "ERROR";
    	} 
    	long value = (long)temp;
    	int add = 0;
    	while (value % 2 == 0) {
    		add++;
    		value /= 2;
    	}
    	StringBuilder res = new StringBuilder(pre);
    	String fractionString = binaryOfInteger(value);
    	res.append(".");
    	add = 32 - add - fractionString.length();
    	while (add > 0) {
    		res.append("0");
    		add--;
    	}
    	return res.append(fractionString).toString(); 
    	
    }
    
    public String binaryOfInteger(long a) {	 
    	StringBuilder sb = new StringBuilder();
    	if (a == 0) {
    		return "0";
    	}
    	while (a > 0) {
    		sb.append(String.valueOf(a % 2));
    		a /= 2;
    	}
    	return sb.reverse().toString();
    }
    
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryRepresentation t = new BinaryRepresentation();
		System.out.println(t.binaryRepresentation("3.72"));
		System.out.println(t.binaryRepresentation("3.125"));
		System.out.println(t.binaryRepresentation("28187281.128121212121"));
		System.out.println(t.binaryRepresentation("0.128121212121"));
	}

}
