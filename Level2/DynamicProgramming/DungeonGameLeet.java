class DungeonProblem {
    
    public int calculateMinimumHP(int[][] dungeon) {

        mem = new Integer[dungeon.length][dungeon[0].length];
        return healthReq(dungeon,0,0);
        // return healthReq(dungeon);
    }
    
    /**
     * Solved using Dynamic Programming 
     * @param dn
     * @return
     */
    int healthReq(int[][] dn) {
        
        int n = dn.length;
        int m = dn[0].length;
        
        // for x(i,j) it stores the min health req to go from x to destination 
        
        int dp[][] = new int[n][m];
        
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                
                int healthB = dn[i][j];
                // cases 
                if(i == n-1 && j == m-1) {
                    // base case 
                    if(healthB > 0) {
                        dp[i][j] = 1; // it its health is already positive then min heath rq is 1
                    } else {
                        dp[i][j] = -healthB + 1; // if health is negative or zero,  then we need to return 1 + -(health) as min health req is 1 not zero** 
                    }
                } else if(i == n-1){
                    if(healthB >= dp[i][j+1]){
                        dp[i][j] = 1;   // if healthBonus is self suff. then min for next will be one 
                    } else {
                        dp[i][j] = -healthB + dp[i][j+1];
                    }
                } else if(j == m-1) {
                    if(healthB >= dp[i+1][j]){   // if healthBonus is self suuff then min for next will be one 
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = -healthB + dp[i+1][j];
                    }
                } else {
                //  cal min heath from next possile spots 
                    int min = Math.min(dp[i][j+1],dp[i+1][j]);
                    if(healthB >= min){   // if healthBonus is self suuff then min for next will be one 
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = -healthB + min;
                    }
                }
            }
        }
        
        return dp[0][0];
    }
    Integer mem[][];
    // try building the recursive code 
    public int healthReq(int[][] dn, int i, int j) {
        
        
        if(i == dn.length-1 && j == dn[0].length-1) {
            if(dn[i][j] > 0)
                return 1;
            else return -dn[i][j] + 1;
        }
        
        if(mem[i][j] != null)
            return mem[i][j];
        // getting min health -> it will always be positve
        // it means if we have this health then we can easily move to end 
        int minR =  (j == dn[0].length-1) ? Integer.MAX_VALUE :  healthReq(dn,i,j+1);
        int minD = (i == dn.length - 1) ? Integer.MAX_VALUE : healthReq(dn,i+1,j);
        
        // taking min of both 
        int min = Math.min(minR,minD);

       if(dn[i][j] >= min) {
            // if i am fulfilling the need required then from my end i only need a min value, which is 1 
            return mem[i][j] = 1;
        } else {    // (min > dn[i][j])
           // after subtracting my health bonus if i still need more heath then i am not enough, so return the value after being subtracted
            return mem[i][j] = -dn[i][j] + min;
        } 
    }
}