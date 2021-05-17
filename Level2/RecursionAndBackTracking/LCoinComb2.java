import java.util.*;

public class LCoinComb2 {
   
    /*
    Edge case is that we cant have same comb 
    [1,1,4,5]
    1,4
    1,4
    Here repeatiton not allowed  
    */
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs_com(cand, 0, target, path, res);
        return res;
    }
    
    boolean dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return false;
        }
        
        if (target < 0) return false;
        
        /**
         *  [1,1,2,3,4,5] tar 7
         *  1 added -> 1 added -> 2 added -> 3 added
         *           2
         *  for next 1 continue 
         */
        for (int i = cur; i < cand.length; i++){
            if (i > cur && cand[i] == cand[i-1]) continue;
        
            path.add(path.size(), cand[i]);
            boolean canCont = dfs_com(cand, i+1, target - cand[i], path, res);
            path.remove(path.size()-1);

            // if current is already greater than target then next elements will also be 
            // greater than it, hence no need to check them and simole break
            if(!canCont)
                    break;
        
        }
        
        return true;
    }
}