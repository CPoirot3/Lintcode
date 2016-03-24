/**
 * 2015Äê7ÔÂ16ÈÕ
 * Poirot
 */
package copyrightByLintCodeMedium;

import java.util.Stack;

/**
 * @author Poirot
 *
 */
public class ImplementQueueUseStack {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public ImplementQueueUseStack() {
		// do initialization if necessary
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void push(int element) {
		// write your code here
		stack1.push(element);
	}

	public int pop() {
		// write your code here
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int result = stack2.pop();
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return result;
	}

	public int top() {
		// write your code here
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int result = stack2.peek();
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
