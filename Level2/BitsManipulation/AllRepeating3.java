import java.util.*;

public class AllRepeating3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
        scn.close();
    }

    /**
     * another apporact is of complexity o(32n) there we can count all 1's in bit
     * position and if it is multiple of 3n then make it zero and rest make it 1
     * (exculding wich were already zero)
     */

    // not working well for negative numbers
    public static void solution(int[] arr) {

        int tn = Integer.MAX_VALUE, tn1 = 0, tn2 = 0;

        for (int i = 0; i < arr.length; i++) {

            int cwn = tn & arr[i];
            int cwn1 = tn1 & arr[i];
            int cwn2 = tn2 & arr[i];

            tn = tn & (~cwn); // swithcing off
            tn1 = tn1 | cwn; // on

            tn1 = tn1 & (~cwn1);
            tn2 = tn2 | cwn1;

            tn2 = tn2 & (~cwn2);
            tn = tn | cwn2;
        }

        System.out.println(tn1);

    }

}