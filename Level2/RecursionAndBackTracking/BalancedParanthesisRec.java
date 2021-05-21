import java.util.*;

public class BalancedParanthesisRec {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        String a = "";
        for(int  i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '}' || ch == '{' || ch == ']' || ch == '[' || ch == '(' || ch == ')')
                a += ch;
        }
        boolean c = checkBalanced(a,a.length());
        System.out.println(c);
    }
    public static boolean checkBalanced(String exp, int n) {
        
        // base cases
        if(n == 0){
            return true;
        }
        
        if(n == 1)
            return false;
        
        char ele = exp.charAt(0);
        if(ele == ')' || ele == '}' || ele == ']')
            return false;
        
        char ch = findClosing(ele);
        
        int i, count = 0; // finding count
        
        for(i = 1; i < n; i++) {
            if(exp.charAt(i) == ele) 
                count++;
            else if(exp.charAt(i) == ch){
                if(count == 0)
                    break;
                count--;
            }
        }
        
        // if we dont find any closing bracket -> ())
        if(i == n) {
            return false;
        }
        
        if(i == 1) {
            return checkBalanced(exp.substring(i+1),n-2);
        }
        
        return checkBalanced(exp.substring(1,n),i-1);
    }
    
    static char findClosing(char c)
    {
        if (c == '(')
            return ')';
        if (c == '{')
            return '}';
        if (c == '[')
            return ']';
        return Character.MIN_VALUE;
    }
}