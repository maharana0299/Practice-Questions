package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Fract[] values = new Fract[n];
        

        for (int i = 0; i < values.length; i++) {
            values[i] = new Fract();
            values[i].val = sc.nextInt();
        }

        for (int i = 0; i < values.length; i++) {
            values[i].wt = sc.nextInt();
            values[i].setCost();
        }

        int cap = sc.nextInt();

        double max = fractionalKnapsack(cap,values);
        System.out.println(max);

        sc.close();
    }

    private static double fractionalKnapsack(int cap, Fract[] values) {
        Arrays.sort(values,new Comparator<Fract>(){

        @Override
        public int compare(Fract o1, Fract o2) {
            return o2.cost.compareTo(o1.cost);
        }

        });

        double d = 0D;

        for (Fract fract : values) {
            
            if (cap - fract.wt >= 0) {
                cap -= fract.wt;
                d += fract.val;
            } else {

                d += cap * fract.cost;
                cap = 0;
                break;
            }
        }
        return d;
    }

    static class Fract {
        int val;
        int wt;
        Double cost;

        public void setCost() {
            this.cost = 1.0 * val/wt ;
        }
    }
}