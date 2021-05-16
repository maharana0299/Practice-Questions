package DynamicProgramming;

import java.util.Scanner;


public class CountEncodings{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int count = countEncodings(str);
        System.out.println(count);
        sc.close();

    }

    private static int countEncodings(String str) {

        int way = 1;
       
        for (int i = 1; i < str.length(); i++) {
            
            int num = Integer.parseInt(str.substring(i-1, i+1) );
            if (num  > 10 && num <= 26)
                way += 1;
            else if (num > 26 && str.charAt(i) == '0')
                return 0;

        }
        return way;
    }

    public static int countDp(String str) {

        int dp[] = new int[str.length()+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i < str.length(); i++) {
            
            dp[i] = dp[i-1];

            if (str.charAt(i) == '0' && (str.charAt(i-1)-'0' > 2)){
                dp[i] = 0;
            } else if (str.charAt(i-1) - '0' == 1){
                dp[i] += 1;
            }
        }
        return 0;
    }
}