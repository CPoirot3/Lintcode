/**
 * 2016年3月5日
 * Poirot
 * 下午2:06:53
 * LintCode
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;

/**
 * @author Poirot
 *
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        // Write your code here
        String[] strs = path.split("/");
        if (strs.length <= 0) {
        	return "/";
        } 
        ArrayList<String> res = new ArrayList<>();
         
        for (int i = 0; i < strs.length; i++) {
        	if (strs[i].length() == 0 || strs[i].equals(".")) {
        		continue;
        	}
			if (strs[i].equals("..")) {
				if (res.size() > 0) { 
					res.remove(res.size() - 1);
				}
			} else {
				res.add(strs[i]); 
			}
		}
        if (res.size() == 0) {
			return "/";
		}
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
			sb.append("/").append(res.get(i));
		} 
        return sb.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath t = new SimplifyPath();
		System.out.println(t.simplifyPath("/home/"));
		System.out.println(t.simplifyPath("/a/./b/../../c/"));
	}

}
