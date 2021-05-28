import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // we also have to reverse the number
        int rev = 0;
        int j = 0;
        // to print the binary of the number
        // starting from msb, after getting the first one start printing
        boolean isFoundFirstOne = false;
        for (int i = 31; i >= 0; i--) {

            // lets check if isFoundFirstOne is true
            if (isFoundFirstOne) {

                // if bit is 1 then print it
                if ((n & (1 << i)) != 0) {

                    // if 1 is found then we have to set the bit
                    rev |= (1 << j);
                    System.out.print(1);

                } else {

                    // if bit is 0 then print zero
                    System.out.print(0);
                }

                // have to inrement j every time
                j++;
            } else {

                // checikng if the bit is 0 or 1

                if ((n & (1 << i)) != 0) {
                    // the bit is one
                    // when the first 1 is found, then we have to set the jth bit to 1
                    rev |= (1 << j);
                    j++; // incrementing j
                    isFoundFirstOne = true; // found the first 1
                    System.out.print(1);
                }
            }

        }

        System.out.println("\n" + rev);
    }
}
