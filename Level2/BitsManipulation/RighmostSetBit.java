import java.util.Scanner;

public class RighmostSetBit {

    // 0000000000000001000 -> this is rsb
    // x & -x => rsb (-x is 2's complement)

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(Integer.toBinaryString(n & -n));
    }
}
