import java.util.Scanner;

public class JosephusProblem {
    
    public static int solution(int n, int k){

        if(n == 1)
            return 0;
        int relativeIndex = solution(n-1,k);
    
        int oIndex = (relativeIndex + k) % n;
        return oIndex;
    }
    public static void main(String[] args){
    
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  
        int k = scn.nextInt();
        System.out.println(solution(n,k));
        scn.close();
    }
}
