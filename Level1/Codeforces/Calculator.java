package Codeforces;

import java.util.Stack;

/**
 * Calculator
 */
public class Calculator {


    // post fix 
    public class RecursionSolution {
        
        int back; 
        public int evalRPN(String[] tokens) {
            back = tokens.length;
            return helper(tokens);
        }
        
        public int helper(String[] tokens) {
            
            String str = tokens[--back];
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int second = helper(tokens); int first = helper(tokens);
                
                switch (str) {
                    case "+": 
                        return first + second;
                    case "-":
                        return first - second;
                    case "*":
                        return first * second;
                    default:
                        return first / second; 
                }
            }
            
            // else 
            return Integer.parseInt(str);
        }
        
    }

    // infix
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int result = 0;
        int number = 0;
        int sign = 1;
        
        for(int i = 0; i < s.length(); i++){
        
            char c = s.charAt(i);
            if(Character.isDigit(c)){
            
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                
                result += sign * number;  
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        
        if(number != 0) result += sign * number;
        
        return result;
    }
}