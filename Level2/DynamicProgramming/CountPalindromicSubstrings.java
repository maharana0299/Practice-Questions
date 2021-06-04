import java.util.Scanner;

public class CountPalindromicSubstrings {
    
    // there can be (n)(n-1)/2 substring possible

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int count = cps(s.toCharArray());
        System.out.println(count);
    }


    private static int cps(char[] s) {
        
        // meaning -> dp[i][j] stors if the s[i..j] is a palindrome or not 
        boolean dp[][] = new boolean[s.length][s.length];

        int pCount = 0;
        // visit diagonal wise 
        for (int gap = 0; gap < s.length; gap++) {
            
            for(int i = 0, j = i + gap; j < s.length; i++,j++) {

                if(gap == 0) {
                    dp[i][j] = true;
                    pCount++; 
                } else if(gap == 1) {
                    if(s[i] == s[j]) {
                        dp[i][j] = true;
                        pCount++;
                    }
                } else {
                    if(s[i] == s[j]) {
                        // if char at i and j are sane then check if s[i+1..j-1] are palindrome or not
                        if(dp[i+1][j-1]) {
                            dp[i][j] = dp[i+1][j-1];
                            pCount++;
                        } 
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return pCount;
    }
}
