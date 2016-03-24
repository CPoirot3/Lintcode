/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class SingleInstance {
    static boolean mark = false;
    static SingleInstance instance;
    public static SingleInstance getInstance() {
        // write your code here
        if (mark) {
			return instance;
		}else {
			instance = new SingleInstance();
			mark = true;
			return instance;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
