
import java.util.*;

/**
 * TODO 
 * https://leetcode.com/problems/verbal-arithmetic-puzzle/discuss/463953/Java-Fast-Backtracking-Clean-Code-O(n!)-~-300ms
 */
public class Crypthermic {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
    scn.close();
  }

  
  public static void solution(String unique, int idx, 
							  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, 
							  String s1, String s2, String s3) {
	
	if(idx == unique.length()) {
	    
	    int n1 = 0; 
	    int n2 = 0;
	    int n3 = 0;
	    
	    for(char ch : s1.toCharArray()) {
	        n1 = n1 * 10 + charIntMap.get(ch);
	    }
	    
	    for(char ch : s2.toCharArray()) {
	        n2 = n2*10 + charIntMap.get(ch);
	    }
	    
	    for(char ch : s3.toCharArray()) {
	        n3 = n3 * 10 + charIntMap.get(ch);
	    }
	    
	    if(n1+n2 == n3) {
	        
	        for(char ch = 'a'; ch <= 'z'; ch++) {
	            if(charIntMap.containsKey(ch)) {
	                System.out.print(ch + "-" + charIntMap.get(ch) + " ");
	            }
	        }
	        
	        System.out.println();
	    } 
	    
	    return ;
	}
	char ch = unique.charAt(idx);
	
	for(int i = 0; i < usedNumbers.length; i++) {
	    if(!usedNumbers[i]) {
	        usedNumbers[i] = true;
	        charIntMap.put(ch,i);
	        solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3);
	        usedNumbers[i] = false;
	        charIntMap.put(ch,-1);
	    }
	}
  }

}
