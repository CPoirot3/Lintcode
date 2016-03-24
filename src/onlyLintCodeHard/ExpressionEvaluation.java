/**
 * 2015Äê9ÔÂ11ÈÕ
 * Poirot
 */
package onlyLintCodeHard;

import java.util.Stack;

/**
 * @author Poirot
 *
 */
public class ExpressionEvaluation {
	public int evaluateExpression(String[] expression) {
		// write your code here
		if (expression.length == 0) {
			return 0;
		}
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < expression.length; i++) {
			stack.push(expression[i]);
		}

		while (stack.size() > 1) {
			boolean mark = false;
			Stack<String> tempStack = new Stack<>();
			while (!stack.isEmpty()) {
				tempStack.push(stack.pop());
				if (tempStack.peek().equals("(")) {
					mark = true;
					break;
				}
			}
			// System.out.println(tempStack.toString());
			if (mark) {
				// System.out.println(tempStack.toString());
				Stack<String> computeStack = new Stack<>();
				tempStack.pop();
				String tempString = tempStack.pop();
				while (!tempString.equals(")")) {
					if (tempString.equals("*") || tempString.equals("/")) {
						int tempA = Integer.parseInt(computeStack.pop());
						int tempB = Integer.parseInt(tempStack.pop());
						if (tempString.equals("*")) {
							computeStack.push(String.valueOf(tempA * tempB));
						} else {
							computeStack.push(String.valueOf(tempA / tempB));
						}
					} else {
						computeStack.push(tempString);
					}
					tempString = tempStack.pop();
				}
				// System.out.println(computeStack.toString());
				Stack<String> computeStack2 = new Stack<>();
				while (!computeStack.isEmpty()) {
					computeStack2.push(computeStack.pop());
				}

				while (computeStack2.size() > 1) {
					int tempA = Integer.parseInt(computeStack2.pop());
					tempString = computeStack2.pop();
					int tempB = Integer.parseInt(computeStack2.pop());
					if (tempString.equals("+")) {
						computeStack2.push(String.valueOf(tempA + tempB));
					} else {
						computeStack2.push(String.valueOf(tempA - tempB));
					}
				}
				if (!computeStack2.isEmpty()) {
					stack.push(computeStack2.pop());
				}

				while (!tempStack.isEmpty()) {
					stack.push(tempStack.pop());
				}
				// System.out.println(stack.toString());
			} else {
				// System.out.println(tempStack.toString());
				Stack<String> computeStack = new Stack<>();

				while (!tempStack.isEmpty()) {
					String tempString = tempStack.pop();
					if (tempString.equals("*") || tempString.equals("/")) {
						int tempA = Integer.parseInt(computeStack.pop());
						int tempB = Integer.parseInt(tempStack.pop());
						if (tempString.equals("*")) {
							computeStack.push(String.valueOf(tempA * tempB));
						} else {
							computeStack.push(String.valueOf(tempA / tempB));
						}
					} else {
						computeStack.push(tempString);
					}
				}
				Stack<String> computeStack2 = new Stack<>();
				while (!computeStack.isEmpty()) {
					computeStack2.push(computeStack.pop());
				}
				// System.out.println(computeStack2.toString());
				while (computeStack2.size() > 1) {
					int tempA = Integer.parseInt(computeStack2.pop());
					String tempString = computeStack2.pop();
					int tempB = Integer.parseInt(computeStack2.pop());
					if (tempString.equals("+")) {
						computeStack2.push(String.valueOf(tempA + tempB));
					} else {
						computeStack2.push(String.valueOf(tempA - tempB));
					}
				}
				return Integer.parseInt(computeStack2.pop());
			}
		}
		if (!stack.isEmpty()) {
			return Integer.parseInt(stack.pop());
		} else {
			return 0;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionEvaluation t = new ExpressionEvaluation();
		// String[] expression = {"2", "*", "6", "-", "(",
		// "23", "+", "7", ")", "/",
		// "(", "1", "+", "2", ")"};
		String[] expression = { "2", "*", "6", "-", "(", "23", "+", "7", ")", "/", "(", "1", "+", "2", ")" };
		// String[] expression = {"1", "+", "99"};
		System.out.println(t.evaluateExpression(expression));
	}

}
