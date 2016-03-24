/**
 * 2015Äê7ÔÂ12ÈÕ
 * CH
 */
package copyrightByLintCodeMedium;

/**
 * @author CH
 *
 */
public class SortLetters {
	public void sortLetters(char[] chars) {
		// write your code here
		int endIndexOfLowCase = -1;
		for (int i = 0; i < chars.length; i++) {
			if (Character.isLowerCase(chars[i])) {
				endIndexOfLowCase++;
				char temp = chars[i];
				chars[i] = chars[endIndexOfLowCase];
				chars[endIndexOfLowCase] = temp;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortLetters t = new SortLetters();
		String s = "abAcD";
		char[] chars = s.toCharArray();
		t.sortLetters(chars);
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i] + " ");
		}
	}

}
