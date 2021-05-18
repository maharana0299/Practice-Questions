import java.util.*;

public class PatternMatching {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		
		
		if(pattern.length() == 0) {
		    if(str.length() == 0) {
		        
		        Set<Character> set = new HashSet<>();	        
		        for(int i = 0; i < op.length(); i++) {
		            char k = op.charAt(i);
		            
		            if(!set.contains(k)){
		                System.out.print(k + " -> " + map.get(k) + ", ");
		                set.add(k);
		            }
		        }
		        
		        System.out.println(".");
		    }
		    
		    return;
		}
		
		// check for each level in pattern
		char ch = pattern.charAt(0);
		String rop = pattern.substring(1);
		
		if(map.containsKey(ch)) {
		    
		    String p = map.get(ch);
		    
		    if(str.length() >= p.length()) {
		        
		        String pre = str.substring(0,p.length());
		        String ros= str.substring(p.length());
		        
		        if(pre.equals(p)) {
		            solution(ros,rop,map,op);
		        }
		    }
		} else { 
		    
		    // for every possible 
		    for(int i = 0; i < str.length(); i++) {
		        
		        String prefix = str.substring(0,i+1);
		        String ros = str.substring(i+1);
		        
		        map.put(ch,prefix);
		        solution(ros,rop,map,op);
		        map.remove(ch);
		    }
		}
		
	}
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
        scn.close();
	}
}