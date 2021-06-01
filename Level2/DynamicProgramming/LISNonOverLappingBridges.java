import java.util.*;

public class LISNonOverLappingBridges {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // total bridges
        int bno = sc.nextInt();
        Bridge[] bridges = new Bridge[bno];

        // taking inputs
        for (int i = 0; i < bno; i++) {
            bridges[i] = new Bridge();
            bridges[i].north = sc.nextInt();
            bridges[i].south = sc.nextInt();
        }

        int maxNonOverlappingBridges = findMaxNonOverlappingBridges(bridges);
        System.out.println(maxNonOverlappingBridges);
    }

    /**
     * First sort by north bank 
     * then find lis of south bank
     * (for index j < i, north of i is already greater than of j and by fiding lis we make sure south bank is also larger 
     * hence, it is an indirect application of LIS)
     * LIS is very important 
     */
    public static int findMaxNonOverlappingBridges(Bridge[] bridges) {

        // sort the bridges on the basis of north bank
        Arrays.sort(bridges);

        // then find LIS for south bank
        int omax = 0; // initially
        int dp[] = new int[bridges.length]; // stores the LIS relative to south bank till i including i
        for (int i = 0; i < bridges.length; i++) {

            int max = 0;
            for (int j = 0; j < i; j++) {

                if (bridges[j].south <= bridges[i].south) {
                    // then it is valid for sure
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = 1 + max;

            if (dp[i] > omax)
                omax = dp[i];
        }

        return omax;
    }

    private static class Bridge implements Comparable<Bridge> {

        int north;
        int south;

        Bridge() {
        }
        
        public int compareTo(Bridge o) {

            if (this.north != o.north) {
                // if noth banks are not equal then
                return this.north - o.north;
            } else {
                // if they are equal then sort on the basis of south bank
                return this.south - o.south;
            }
        }
    }

}