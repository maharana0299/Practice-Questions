import java.util.*;

public class WordKselection1 {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        
        Map<Character,Integer> freq = new HashMap<>();
            
        StringBuilder distinct = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(freq.containsKey(ch))
                continue;
            else {
                freq.put(ch,1);
                distinct.append(ch);
            }
        }
        
        printforK(0,distinct.toString(),0,k,"");
    }
    
    public static void printforK(int i, String str, int ssf, int ts, String asf) {
        
        if(i == str.length()){
            if(ssf == ts) {
                System.out.println(asf);    
            }
            return;
        }
        char ch = str.charAt(i);
        printforK(i+1,str,ssf+1,ts,asf + ch);
        printforK(i+1,str,ssf,ts,asf);
    }
}
