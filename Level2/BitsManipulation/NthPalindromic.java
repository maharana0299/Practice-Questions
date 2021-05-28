import java.util.Scanner;

public class NthPalindromic {

    public static int NthPalindromicBinary(int n) {

        // let calculate then grounp/ len
        int count = 1;
        int len = 1;

        while (count < n) {
            len++; // increasing the length by 1;
            int elForThisLen = (1 << (len - 1) / 2); // elements contained in this group is 2^(x-1)/2
            count += elForThisLen; // increasing the count
        }

        count -= (1 << (len - 1) / 2); // goint to the starting of the group
        int offset = n - count - 1; // getting the offset number

        int ans = (1 << (len - 1)); // shifting the one to last bit as it will always be one

        ans |= (offset << (len / 2)); // addint the offset value to the number

        // now its reverse will be our answer
        int valFR = (ans >> (len / 2)); // shiting the bits to end
        // thenn reversing it
        int rev = reverseBit(valFR);

        // taking and to get the final ans
        ans |= rev;
        return ans;
    }

    static int reverseBit(int n) {

        int rev = 0;

        // while n is not 0
        while (n != 0) {

            // cheicking lowest bit is 0 or not
            if ((n & 1) != 0) {
                rev |= 1;
            }

            // then shit no to right and rev to left
            rev <<= 1;
            n >>= 1;
        }

        // as shifted one time extra hence reversing the shit by 1
        rev >>= 1;
        return rev;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NthPalindromicBinary(n));
    }

}
