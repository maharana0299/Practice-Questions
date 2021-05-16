import java.util.Scanner;

/**
 * AbbUsingBT
 */
public class AbbUsingBT {

    public static void solution(String str, String asf,int count, int pos){
        
        if (pos == str.length()) {
            if(count == 0)
            System.out.println(asf);
            else System.out.println(asf + count);
            return;
        }
        String toPass = asf;
        // case of 0
        if(count != 0)
            toPass += count + "";            
        solution(str, toPass+str.charAt(pos), 0, pos+1);
        //case of 1
        solution(str, asf, count + 1, pos + 1);
    }
    
	public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0,0);
        scn.close();
    }
}