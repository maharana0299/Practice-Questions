import java.util.Scanner;

/**
 * PrintEncodings
 */
public class PrintEncodings {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.charAt(0) == '0') {
            System.out.println("Invalid input. A string starting with 0 will not be passed.");
            sc.close();
            return ;
        }
       
        // System.out.println(ch);
        printEncodings(s,"");

        sc.close();
    }

    public static void printEncodings(String str, String ans) {
        
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        if(str.charAt(0) != '0') {

            int num = str.charAt(0) - '0' ;
            char c = (char)('a' + num-1);
            printEncodings(str.substring(1), ans + c);

            if(str.length() > 1) {

                int f  = Integer.parseInt(str.substring(0, 2));
                
                if(f > 9 && f < 27) {
                    char ch =(char) ('a' + f-1);
                    printEncodings(str.substring(2), ans + ch);
                }
            }
        }
    }
}