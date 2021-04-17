
import java.util.ArrayList;
import java.util.List;

public class WordSubset {
    public List<String> wordSubsets(String[] A, String[] B) {
        
        int count[] = count("");
        
        for(String b : B) {
            int[] bCount = count(b);
            for(int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i],bCount[i]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        search: for(String a : A) {
            int[] aCount = count(a);
            for(int i = 0; i < 26; i++)
                if(aCount[i] < count[i])
                    continue search; //if count is less then skip 
            ans.add(a);
        }
        
        return ans;
    }
    
    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }    
}
