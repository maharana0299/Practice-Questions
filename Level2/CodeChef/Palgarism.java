import java.util.Scanner;



public class Palgarism {
    
    /**
     * N M K
     * l1 l2 .... lk
     * @param args
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-->0) {

            int N = sc.nextInt();
            int M = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[N+M+1];

            // StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= k; i++) {

                int att = sc.nextInt(); // which user has attempted
                arr[att] += 1;
            }

            String sb = "";
            int len = 0;
            for(int i = 1; i <= N; i++) {

                if(arr[i] > 1){
                    len++;
                    sb += i;
                    sb += " "; 
                }
            }

            if(len == 0){
                System.out.println(0);
            } else {
                System.out.println(len + " " + sb);
            }
        }

        sc.close();
    }
}
