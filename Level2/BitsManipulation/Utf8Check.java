import java.util.Scanner;

/**
 * Utf8Check
 */
public class Utf8Check {

    public static boolean solution(int[] arr) {
        

        int rem = 0;
        
        for(int b : arr) {
            
            if(rem == 0) {
                if((b>>7) == 0b0) {
                    rem = 0;
                } else if((b>>5)== 0b110){
                    rem = 1;
                } else if((b>>4)== 0b1110){
                    rem = 2;
                } else if((b>>3) == 0b11110){
                    rem = 3;
                } else {
                    return false;
                }
            }else{
                
                if((b>>6) == 0b10){
                    rem--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}