
import java.util.*;

public class KernighansAlgo {

    // calculating rbsm and then subtracting it
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int count = 0;
        while (n != 0) {
            n = n - (n & -n);
            count++;
        }
        System.out.println(count);
        scn.close();
    }

}