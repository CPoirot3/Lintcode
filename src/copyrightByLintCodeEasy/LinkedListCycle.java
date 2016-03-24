/**
 * 
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		// write your code here

		// O(n)
		if (head == null || head.next == null) {
			return false;
		}

		ListNode slowPointer = head.next;
		ListNode fastPointer = head.next.next;

		while ((slowPointer != null && fastPointer != null)) {

			if (slowPointer == fastPointer) {
				return true;
			}
			slowPointer = slowPointer.next;

			if (fastPointer.next != null) {
				fastPointer = fastPointer.next.next; // two step by one time
			} else {
				fastPointer = null;
			}

		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
