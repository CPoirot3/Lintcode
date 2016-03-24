/**
 * 2016年2月25日
 * Poirot
 * 下午12:22:40
 * LintCode
 */
package copyrightByLintCodeMedium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Poirot
 *
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
    	if (n != edges.length + 1) {
    		return false;
    	} 
    	HashSet<Integer>[] sets = new HashSet[n + 1]; 
    	for (int i = 0; i < sets.length; i++) {
    		sets[i] = new HashSet<>();
			sets[i].add(i);
		}
    	
    	for (int i = 0; i < edges.length; i++) {
			sets[edges[i][0]].addAll(sets[edges[i][1]]);
			sets[edges[i][1]] = sets[edges[i][0]];
//			sets[edges[i][1]].addAll(sets[edges[i][0]]);
		}  
    	int max = 0;
    	for (int i = 0; i < sets.length; i++) {
    		max = Math.max(sets[i].size(), max);
    		System.out.println(sets[i].size());
//			if (sets[i].size() == n) {
//				
//				return true;
//			}
		} 
    	if (max >= n) {
    		return true;
    	}
    	System.out.println(max);
    	return false;
    }
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("data\\14.in");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		StringBuilder stringBuilder = new StringBuilder();
		String temp = "";
		while ((temp = bufferedReader.readLine()) != null) {
			stringBuilder.append(temp);
		}
		ArrayList<Integer> list = new ArrayList<>(); 
		int begin = 0;
		boolean hasBegin = false;
		for (int i = 0; i < stringBuilder.length(); i++) {
			if (!Character.isDigit(stringBuilder.charAt(i))){
				if (hasBegin) {
					list.add(Integer.parseInt(stringBuilder.substring(begin, i)));
					hasBegin = false;
				}
			} else {
				if (!hasBegin) {
					begin = i;
					hasBegin = true;
				}
			}
		}
		 
        int[][] edges = new int[list.size() / 2][2];
        int n = list.get(0); 
         
        for (int i = 0; i < edges.length; i++) {
			edges[i][0] = list.get(i * 2 + 1);
			edges[i][1] = list.get(i * 2 + 2);
		}
        
        
        GraphValidTree t = new GraphValidTree();
//        System.out.println(t.validTree(n, edges));
        
        int[][] edges2 = {{1,2}, {2,3}, {3, 4}};
        System.out.println(t.validTree(4, edges2));
	}

}
