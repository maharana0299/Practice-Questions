import java.util.Scanner;

public class LongestPalindromicSubstring {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        int count = lpss(s.toCharArray());
        System.out.println(count);
        sc.close();
    }
    
    static int lpss(char[] s){
        
        boolean[][] dp = new boolean[s.length][s.length];
        int len = 0;
        
        for(int g = 0; g < s.length; g++) {
            
            for(int i = 0, j = g + i; j < s.length; i++, j++) {
                
                if(g == 0){
                    dp[i][j] = true;
                } else if(g == 1) {
                    dp[i][j] = s[i] == s[j];
                } else {
                    if(s[i] == s[j]) {
                        dp[i][j] = dp[i+1][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
                
                if( dp[i][j] && j-i+1 > len ) {
                    len = j-i+1;
                }
            }
        }
        
        return len;
    }

}
