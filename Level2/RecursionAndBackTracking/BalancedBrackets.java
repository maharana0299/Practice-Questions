
import java.util.*;

public class BalancedBrackets {

	public static void solution(String str, int minRemoval, HashSet<String> ans) {
		
		if(minRemoval == 0) {
		    
		    int mrn = getMin(str);
		    
		    if(mrn == 0)
    		    if(!ans.contains(str)) {
    		        System.out.println(str);
    		        ans.add(str);
    		    }
		    
		    return;
		}
		
		for(int i = 0; i < str.length(); i++) {
		    
		    String left = str.substring(0,i);
		    String right = str.substring(i+1);
		    
		    solution(left + right, minRemoval-1, ans);
		}
	}

	public static int getMin(String str){
	    
	    Stack<Character> st = new Stack<>();
	    
	    for(int i = 0; i < str.length(); i++ ) {
	        
	        char ch = str.charAt(i);
	        
	        if(ch == '(') {
	            st.push(ch);
	        } else if(ch == ')'){
	            
	            if(st.size() == 0) {
	                st.push(ch);
	            } else if(st.peek() == '(') {
	                st.pop();
	            } else if(st.peek() == ')' ) {
	                st.push(ch);
	            }
	        }
	    }
		return st.size();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str, getMin(str),new HashSet<>());
        scn.close();
	}


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }   
		
}
