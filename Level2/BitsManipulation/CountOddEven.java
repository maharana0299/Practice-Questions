import java.util.Scanner;

public class CountOddEven {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        int even = 0, odd = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                if (i % 2 == 0) { // if in even place 
                    even++;
                } else {
                    odd++; // if at odd place
                }
            }
        }
        System.out.println(Math.abs(even - odd) % 3 == 0);
    }

}
