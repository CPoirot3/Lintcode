/**
 * 2016年2月24日
 * Poirot
 * 下午10:23:39
 * LintCode
 */
package copyrightByLintCodeEasy;

/**
 * @author Poirot
 *
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        // write your code here
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode res = head;
    	head = head.next;
    	res.next = null;
    	
    	while (head != null) {
    		ListNode temp = head;
    		head = head.next;
    		temp.next = null;
    		
    		// insert
    		if (temp.val <= res.val) {
    			temp.next = res;
    			res = temp;
    			continue;
    		}
    		ListNode cur = res.next;
    		ListNode pre = res;
    		while (cur != null && temp.val > cur.val) {
    			pre = pre.next;
    			cur = cur.next;
    		}
    		pre.next = temp;
    		temp.next = cur;
    	}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
