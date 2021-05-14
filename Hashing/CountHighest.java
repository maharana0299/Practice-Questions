import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * CountHighest
 */
public class CountHighest {

    public static void main(String[] args) {
        
        Map<Character,Integer> charM = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            
            char ch = s.charAt(i);
            
            if(charM.containsKey(ch)){
                
                charM.put(ch,1 + charM.get(ch));
            } else {
                
                charM.put(ch,1);
            }
        }
        
        int count = Integer.MIN_VALUE;
        char c = 'A';
        for(char ch : charM.keySet()) {
            
            if(charM.get(ch) > count) {
                count = charM.get(ch);
                c = ch;
            }
        }
        
        System.out.println(c);
    }
}