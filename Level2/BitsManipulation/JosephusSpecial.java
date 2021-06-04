import java.util.Scanner;

public class JosephusSpecial {

    public static int solution(int n) {

        int pow = getMaxPow(n);
        int l = n - pow;

        // 2*l + 1
        return (l << 1) + 1;
    }

    public static int getMaxPow(int n) {

        int pow = 1;

        while (pow * 2 <= n) {
            pow = pow * 2;
        }

        return pow;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }
}
