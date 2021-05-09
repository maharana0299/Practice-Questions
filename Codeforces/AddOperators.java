import java.util.LinkedList;
import java.util.List;

/**
 * AddOperators
 */
public class AddOperators {

    void dfs(List<String> ret, char[] path, int len, long left, long cur, char[] digits, int pos, int target) {
        
        if (pos == digits.length) {

            if (left + cur == target) ret.add(new String(path, 0, len));
                return;
        }

        long n = 0;
        
        int j = len + 1;

        for (int i = pos; i < digits.length; i++) {

            n = n * 10 + digits[i] - '0';
            
            path[j++] = digits[i];
            
            path[len] = '+';
            dfs(ret, path, j, left + cur, n, digits, i + 1, target);
            
            path[len] = '-';
            dfs(ret, path, j, left + cur, -n, digits, i + 1, target);
            
            path[len] = '*';
            dfs(ret, path, j, left, cur * n, digits, i + 1, target);
            
            if (digits[pos] == '0') break; 
            
        }
    }
    
    public List<String> addOperators(String num, int target) {
        
        List<String> ret = new LinkedList<>();

        if (num.length() == 0) return ret;

        char[] path = new char[num.length() * 2 - 1];
        char[] digits = num.toCharArray();
        long n = 0;

        for (int i = 0; i < digits.length; i++) {
           
            n = n * 10 + digits[i] - '0';
            
            path[i] = digits[i];
            dfs(ret, path, i + 1, 0, n, digits, i + 1, target);
            
            if (n == 0) break;
        }
        return ret;
    }

    
}

class Solution {
    public List<String> addOperators(String num, int target) {
        
        List<String> ans = new LinkedList<>();

        if(num.length() > 0) {

            char digits[] = num.toCharArray();
            char path[] = new char[digits.length + digits.length-1];

            // Iterate for ever substing 
            long number = 0;
            
            for(int i = 0; i < digits.length; i++) {

                number = number * 10 + digits[i] - '0';

                int pathIndex = i;
                path[pathIndex] = digits[i];
                pathIndex = pathIndex + 1;

                dfs(ans, path, pathIndex, 0, number, digits, i+1, target);

                if(number == 0)
                    break;
            }
        }

        return ans;
    }

    private void dfs(List<String> ans, char[] path, int pathIndex, long lastNumber, long currentNumber, char[] digits, int digitIndex,
            int target) {
        
        if(digitIndex == digits.length) {
            if(currentNumber + lastNumber == target) {
                ans.add(new String(path,0,pathIndex));
            }
        }
        
        long number = 0;
        int j = pathIndex+1;

        for(int dI = digitIndex; dI < digits.length; dI++) {

            number = number * 10 + digits[dI] - '0';
            path[j++] = digits[dI];

            path[pathIndex] = '+';
            dfs(ans, path, j, lastNumber + currentNumber, number, digits, dI + 1, target);
            
            path[pathIndex] = '-';
            dfs(ans, path, j, lastNumber + currentNumber, -number, digits, dI + 1, target);

            path[pathIndex] = '*';
            dfs(ans, path, j, lastNumber, currentNumber * number, digits, dI + 1, target);

            if(number == 0)
                break;
        }
    }
}