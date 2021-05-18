
import java.util.*;

public class PalindrommicPartition {

	public static void solution(String str, String asf) {
		
		if(str.length() == 0) {
		    System.out.println(asf);
		    return;
		}
		
		for(int i = 0; i < str.length(); i++ ){
		    
		    String pre = str.substring(0,i+1);
		    String ros = str.substring(i+1);
		    if(isPalin(pre)) {
		        solution(ros,asf + "(" + pre + ") ");
		    }
 		}
		
	}
	
	public static boolean isPalin(String str) {
	   
	   int l = 0;
	   int r = str.length()-1;
	   
	   while(l < r) {
	       
	       if(str.charAt(l) != str.charAt(r) ) {
	           return false;
	       }
	       l++;
	       r--;
	   }
	   
	   return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "");
        scn.close();
	}

    protected class Solution{

        public List<List<String>> partition(String s) {
        
            List<List<String>> ls = new LinkedList<>();
            
            List<String> ans = new ArrayList<>();
            
            char[] chs = s.toCharArray();
        
            solution(0,ans,ls,chs);
            
            return ls;
        }

        private void solution(int pos, List<String> ans, List<List<String>> ls, char[] chs) {
        
            if(pos == chs.length) {

                List<String> ra = new ArrayList<>(ans);
                ls.add(ra);
                return;
            }
        
            
            for(int i = pos; i < chs.length; i++) {
                
                String pre = new String(chs, pos, i+1);
                
                if(isPalin(pre)) {
                    ans.add(pre);
                    solution(i+1, ans, ls, chs);
                    ans.remove(ans.size()-1);
                }
            }
        }
    }
}

