import java.util.Scanner;

public class Tem {
 
    static int count = 0;
    public static void main(String args[] ){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ts(n, 1, 2,0);
        System.out.println(count);
    }

    public static void ts(int tar,int num, int ts, int cs) {

        if(tar == 0) {
            if(cs == ts) {
                count++;
            }
        }
        if(tar < 0){
            return;
        }
        
        ts(tar-num,num+1,ts,cs+1);
        if(tar > num)
        ts(tar,num+1,ts,cs);
    }
}
