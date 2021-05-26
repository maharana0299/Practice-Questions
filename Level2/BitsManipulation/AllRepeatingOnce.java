import java.util.Scanner;

public class AllRepeatingOnce {
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
          arr[i] = scn.nextInt();
        }
        
        int m = 0;
        
        for(int i : arr){
            m = m ^ i;
        }
        
        System.out.println(m);
      }
}
