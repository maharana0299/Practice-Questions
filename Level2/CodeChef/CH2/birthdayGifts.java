package CH2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class birthdayGifts {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while(tc-->0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            Integer[] gifts = new Integer[n];
            for(int i = 0; i < n; i++) {
                gifts[i] = sc.nextInt();
            }

            int max = findMaxGiftForOne(gifts,n,k);
            System.out.println(max);
        }
    }

    private static int findMaxGiftForOne(Integer[] gifts, int n, int k) {
        
        Arrays.sort(gifts, Collections.reverseOrder());

        int f = 0;
        int s  = 0;

        int i= 0;

        while(i < 2*k) {
            f += gifts[i++];
            s += gifts[i++];
        }
        s += gifts[i++];

        return Math.max(s,f);
    }
}

/*
3
3 1
1 3 2
3 1
3 1 3
5 2
5 1 3 2 4
*/