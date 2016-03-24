/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class NthtoLastNodeinList {
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
    	if (head == null) {
			return null;
		}
    	ListNode pre = head;
    	ListNode current = head;
    	int i = 0;
    	while (i < n - 1) {
    		current = current.next;
    		i ++;
    	}
    	while (current.next != null) {
    		pre = pre.next;
    		current = current.next;
    	}
    	return pre;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
