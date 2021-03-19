import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class stacks {

    public static void smallestNumerFollowingPattern(String s) {
        Stack<Integer> st = new Stack<>();
        int p = 1;
        for (int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            
            if (ch == 'd') {
                st.push(p);
                p++;
            } else {
                st.push(p);
                p++;
                while (st.size() > 0) {
                    System.out.print(st.pop());
                }
            }
        }
        st.push(p);
        while (st.size() > 0) {
            System.out.print(st.pop());
        }
    }
    public static boolean checkDoubleBrackets(String s) {
        
        Stack<Character> st = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            
            c = s.charAt(i);
            if (c == ')') {
                if (st.peek() == '(') {
                    return true;
                }else{
                    while(st.peek()!= '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(c);
            }
        }
        return false;
    }
    
    public static int[] findNextGreater(int[] arr){
    
        Stack<Integer> st = new Stack<>();
        // st.push(-1); // for righmost element, it's grearest will be none hence pushing -1
        int [] sol = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            while (st.size() > 0 && st.peek() <= arr[i]) 
                st.pop();
                
            if (st.size() == 0) {
                sol[i] = -1;
            } else{
                sol[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return sol;
    }

    static boolean checkDuplicate(String x) {
        
        Stack<Character> s = new Stack<>();
        x = x.trim();
        char ch = ' ';
        for (int i = 0; i < x.length() ; i++){
            
            ch = x.charAt(i);
            
            try {
                if (ch == '{' || ch == '[' || ch == '(') {
               s.push(ch); 
                } else if (ch == '}' && s.peek() == '{') {
                    s.pop();
                } else if (ch == ']' && s.peek() == '[') {
                    s.pop();
                } else if (ch == ')' && s.peek() == '(') {
                    s.pop();
                }
            } catch(Exception e) {
                return false;
            }
        }
        if (s.empty())
            return true;
        else return false;
    }

    public static int[] stackSpan(int arr[]){
        int [] sol = new int[arr.length];
        Stack<Integer> st = new Stack<>();
      
        for (int i = 0; i < arr.length; i++) {
             while (st.size() > 0 && arr[st.peek()] < arr[i] ) {
                 st.pop();
             } 
             
             if (st.size() == 0 ){
                 sol[i] = i + 1;
             } else {
                 sol[i] = i - st.peek() ;
             }
             st.push(i);
         }
        return sol;
    }

    public static void doWindowSliding(int[] arr, int k) {
        
        int size = arr.length;
        int [] nG = findNextGreater(arr);
        int j = 0;
        
        for (int i = 0; i <= size - k; i++) {
            if (j < i)  j = i;
            while (nG[j] < i + k)
                j = nG[j];
            System.out.println(arr[j]);
        }
    }
}

class AreaOfHistogram {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
        
        int area = getLargestArea(a);
        System.out.println(area);
    }
    
    public static int getLargestArea(int[] arr) {
        int rb[] = nextSmallerOnRigth(arr);
        int lb[] = nextSmallerOnLeft(arr);
        
        // width =  left - rigth - 1
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int width = rb[i] - lb[i] - 1;
            maxArea = Math.max(width*arr[i], maxArea);
        }
        return maxArea;
    }
    
    public static int[] nextSmallerOnRigth(int[] arr) {
        
        Stack<Integer> st = new Stack<>();
        int[] sol = new int[arr.length];
        
        for (int i = arr.length - 1; i >= 0; i--) {
            
            while (st.size() > 0 && arr[st.peek()] >= arr[i] ) {
                st.pop();
            }
            
            if (st.size() == 0) {
                sol[i] = arr.length;
            } else {
                sol[i] = st.peek();
            }
            st.push(i);
        }
        return sol;
    }
    
    public static int[] nextSmallerOnLeft(int[] arr) {
        
        Stack<Integer> st = new Stack<>();
        int[] sol = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            
            while (st.size() > 0 && arr[st.peek()] >= arr[i] ) {
                st.pop();
            }
            
            if (st.size() == 0) {
                sol[i] = -1;
            } else {
                sol[i] = st.peek();
            }
            st.push(i);
        }
        return sol;
    }
}

class InfixEvaluation{
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        evaluateInfix(exp);
    }
    
    public static void evaluateInfix(String exp) {
        
        Stack<Character> op = new Stack<>();
        Stack<Integer> operand = new Stack<>();
        
        char ch;
        for (int i = 0; i < exp.length(); i++) {
            
            ch = exp.charAt(i);
            
            if (ch == '(') {
                op.push(ch);
            } else if (Character.isDigit(ch) ) {
                operand.push(ch - '0'); // char to int
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    
                    char opt = op.pop();
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    
                    int opv = operation(v1, v2, opt);
                    operand.push(opv);
                }
                op.pop();
            } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                
                while (op.size() > 0 && 
                    op.peek() != '(' && 
                    precedence(ch) <= precedence(op.peek())
                ) {
                    char opt = op.pop();
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    
                    int opv = operation(v1, v2, opt);
                    operand.push(opv);
                }
                
                op.push(ch); // wanting higher prio operator to solve first 
            }
        }
        
        while ( op.size() != 0) {
           
            char opt = op.pop();
            int v2 = operand.pop();
            int v1 = operand.pop();
            
            int opv = operation(v1, v2, opt);
            operand.push(opv);
        }
        
        System.out.println(operand.peek() );
    }
    
    public static int precedence(char opt) {
        
        if (opt == '+' || opt == '-' )
            return 1;
        else if (opt == '*')
            return 2;
        else return 2;
    }
    
    public static int operation(int v1, int v2, char op) {
        
        if (op == '+') {
            return v1+v2;
        } else if (op == '-') {
            return v1-v2;
        } else if (op == '*') {
            return v1*v2;
        } else {
            return v1/v2;
        }
    }
}

class PostFixEvaluation{

    private static final int POSTFIX = 1, PREFIX = 2;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine().trim();
        evaluateInfix(exp);
    }
    
    public static void evaluateInfix(String exp) {
        
        Stack<Character> op = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        char ch;

        for (int i = 0; i < exp.length(); i++) {
            
            ch = exp.charAt(i);
            
            if (ch == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    precessConversion(prefix,postfix,op); 
                }
                op.pop();
            } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                
                while (op.size() > 0 && 
                    op.peek() != '(' && 
                    precedence(ch) <= precedence(op.peek())
                ) {
                    precessConversion(prefix,postfix,op); 
                }
                
                op.push(ch); // wanting higher prio operator to solve first 
            } else {
                postfix.push(ch + ""); // char to int
                prefix.push(ch + "");
            } 
        }
        
        while ( op.size() != 0) {
            precessConversion(prefix,postfix,op); 
        }
        
        System.out.println(postfix.peek() );
        System.out.println(prefix.peek() );
    }
    
    public static void precessConversion(Stack<String> prefix, Stack<String> postfix, Stack<Character> op) {
       
        char opt = op.pop();
        String v2 = postfix.pop();
        String v1 = postfix.pop();
        
        postfix.push(v1 + v2 + opt);
       
        v2 = prefix.pop();
        v1 = prefix.pop();
        prefix.push(opt + v1 + v2);
    }
    
    public static int precedence(char opt) {
        
        if (opt == '+' || opt == '-' )
            return 1;
        else if (opt == '*')
            return 2;
        else return 2;
    }
}


class PostfixEvaluation{
  

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        evaluatePostfix(exp);
    }
    
    public static void evaluatePostfix(String exp) {
        
        Stack<Integer> st = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> infix = new Stack<>();
        
        for (int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);
            
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' ) {
                process(st,prefix,infix,ch);
            } else if (Character.isDigit(ch) ) {
                st.push(ch-'0');
                prefix.push("" + ch);
                infix.push(ch + "");
            }
        }
        System.out.println(st.peek());
        System.out.println(infix.peek());
        System.out.println(prefix.peek());
    
    }
    
    public static void process(Stack<Integer> st,Stack<String> pre,Stack<String> infix, char ch ) {
        
        int b = st.pop();
        int a = st.pop();
        if (ch == '+') {
            st.push( a + b );
        } else if (ch == '-') {
            st.push(a - b);
        } else if (ch == '*') {
            st.push(a * b);
        } else if (ch == '/'){
           st.push(a / b);
        }
        String b1 = pre.pop();
        String a1 = pre.pop();
        pre.push(ch + a1  +b1);
        
        b1 = infix.pop();
        a1 = infix.pop();
        infix.push('(' + a1 + ch + b1 + ')');
    }
}

class PrefixEvalution{
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        evaluatePostfix(exp);
    }
    
    public static void evaluatePostfix(String exp) {
        
        Stack<Integer> st = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> infix = new Stack<>();
        
        for (int i = exp.length() - 1; i >= 0; i--){
            char ch = exp.charAt(i);
            
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' ) {
                process(st,prefix,infix,ch);
            } else if (Character.isDigit(ch) ) {
                st.push(ch-'0');
                prefix.push("" + ch);
                infix.push(ch + "");
            }
        }
        System.out.println(st.peek());
        System.out.println(infix.peek());
        System.out.println(prefix.peek());
    
    }
    
    public static void process(Stack<Integer> st,Stack<String> pre,Stack<String> infix, char ch ) {
        
        int a = st.pop();
        int b = st.pop();
        if (ch == '+') {
            st.push( a + b );
        } else if (ch == '-') {
            st.push(a - b);
        } else if (ch == '*') {
            st.push(a * b);
        } else if (ch == '/'){
           st.push(a / b);
        }
        String a1 = pre.pop();
        String b1 = pre.pop();
        pre.push(a1  +b1 + ch);
        
        a1 = infix.pop();
        b1 = infix.pop();
        infix.push('(' + a1 + ch + b1 + ')');
    }
}

class MinStackImpelemntation {

  public static class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
      data = new Stack<>();
    }

    int size() {
      return data.size();
    }

    void push(int val) {
        if (data.size() == 0) {
            data.push(val);
            min = val;
        } else if (val >= min) {
            data.push(val);
        } else {
            data.push(val + val - min);
            min = val;
        }
    }

    int pop() {
        if (data.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        } else {
            if (data.peek() >= min ) {
                return data.pop();
            } else {
                int r = min;
                min = 2 * min - data.pop();
                return r;
            }
        }
    }

    int top() {
        if (data.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }  else if (data.peek() >= min) {
            return data.peek();
        }   else {
            return min;
        }
     
    }

    int min() {
      return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}
