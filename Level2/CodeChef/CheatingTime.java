import java.util.Arrays;
import java.util.Scanner;

public class CheatingTime {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while(tc-->0) {

            int noOfInv = sc.nextInt();
            int googlingTime = sc.nextInt();
            int endingTime = sc.nextInt();
            // Inv[] timeZoneOfInv = new Inv[noOfInv];
            int[] st = new int[noOfInv];
            int[] et = new int[noOfInv];
            for(int i = 0; i < noOfInv; i++){
                st[i] = sc.nextInt();
                et[i] = sc.nextInt();
                // timeZoneOfInv[i] = new Inv();
                // timeZoneOfInv[i].st = sc.nextInt(); // start 
                // timeZoneOfInv[i].et = sc.nextInt(); // end
            }

            if(canGoogle(noOfInv,googlingTime,endingTime, st,et)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    private static boolean canGoogle(int noOfInv, int googlingTime, int endingTime, int[] st, int[] et) {
        Arrays.sort(st);
        Arrays.sort(et);

        int t = 0;
        int ct = 0;

        for(int i = 0; i < noOfInv; i++) {

            if(st[i] > t) {
                ct = st[i] - t;
            }

            if(et[i] > t)
                t = et[i];
        }

        ct += endingTime - t;
        if(ct >= googlingTime)
            return true;
        return false;
    }

    private static boolean canGoogle(int noOfInv, int googlingTime, int endingTime, Inv[] timeZoneOfInv) {

        int t = 0; // initially zero 
        int cheatTime = 0;

        Arrays.sort(timeZoneOfInv);

        for(Inv i : timeZoneOfInv){
            System.out.println(i);       
        }
        for(int i = 0; i < timeZoneOfInv.length; i++) {

            // startime
            int st = timeZoneOfInv[i].st;
            int et = timeZoneOfInv[i].et;

            if(st >= t)
            cheatTime += st - t;

            if(et > t)
            t = et;
        }

        cheatTime += endingTime - t;

        // System.out.println("c" + cheatTime);
        if(cheatTime >= googlingTime)
            return true;
        return false;
    }
}

class Inv implements Comparable<Inv>{
    int st;
    int et;

    Inv(){}
   @Override
   public int compareTo(Inv o) {
       return this.st - o.st;
   }

   @Override
   public String toString() {
       
       return st + ":" + et  + ", ";
   }
}

/*
3
1 10 10
0 10
2 2 10
0 5
7 10
2 2 100
0 5
5 10
*/