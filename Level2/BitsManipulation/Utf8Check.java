import java.util.Scanner;

/**
 * Utf8Check
 */
public class Utf8Check {

    /**
     * max size of an UTF can be 4
     * If its size is 1, then it starts with 0
     * It its size is 2, then it statrs with 110
     * For size 3, 1110 etc.
     * For size n, n 1's followd by a 0. Followed by n-1 bits starting with 10 
     * @param arr
     * @return
     */

    public static boolean solution(int[] arr) {
        

        int rem = 0;
        
        for(int b : arr) {
            
            if(rem == 0) {

                // checking for UTF of size 1
                if((b>>7) == 0b0) {
                    rem = 0;
                } else if((b>>5)== 0b110){  // checking for UTF of size 2
                    rem = 1;
                } else if((b>>4)== 0b1110){  // checking for UTF of size 3
                    rem = 2;
                } else if((b>>3) == 0b11110){ // checking for UTF of size 4
                    // remaining bits are n-1, ie 3
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