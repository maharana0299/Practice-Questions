package Hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d171220 {
    static final Scanner sc = new Scanner(System.in);
    
    public static void p1(){
        /**
         * https://www.hackerrank.com/challenges/java-arraylist/problem?isFullScreen=true
         */

         int n = sc.nextInt();
         List<List<Integer>> ls = new ArrayList<>();
         List<Integer> a;
         while(n-- > 0){
            int d = sc.nextInt();

            a = new ArrayList<>();
            while(d-- > 0){
                
                a.add(sc.nextInt());
            }

            ls.add(a);
        }

        int d = sc.nextInt();
        while(d-- > 0){
            int q1 = sc.nextInt();
            int q2 = sc.nextInt();

            if(q1 <= ls.size() && q2 <= ls.get(q1).size()) {
                a = (ArrayList<Integer>) ls.get(q1);
                System.out.println(a.get(q2));
            } else {
                System.out.println("ERROR!");
            }

        }

    }

    public static boolean p2(int leap, int[] arr){
        /**
         * https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true&h_r=next-challenge&h_v=zen
         */

        return isSolvable(leap, arr, 0);
    }

    private static boolean isSolvable(int m, int[] arr, int i) {
        if (i < 0 || arr[i] == 1) return false;
        if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

        arr[i] = 1;
        return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
    }

    public static void main(String[] args) {
        
    }
}