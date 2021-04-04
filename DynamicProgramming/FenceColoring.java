package DynamicProgramming;

import java.util.Scanner;

/**
 * FenceColoring
 */
public class FenceColoring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fence = sc.nextInt();
        int k = sc.nextInt();

        int ways = colorFence(fence,k);
        System.out.println(ways);
        sc.close();
    }

    private static int colorFence(int fence, int k) {

        int total[] = new int[fence+1];
        int[] ss = new int[fence+1];
        int[] sd = new int[fence+1];

        ss[1] = k;
        sd[1] = sd[0] * (k-1);
        for (int j = 2; j <= fence; j++) {
            ss[j] = sd[j-1];
            sd[j] = total[j-1] * (k-1);

            total[j] = sd[j] + ss[j];
        }
        return total[fence];
    }
}