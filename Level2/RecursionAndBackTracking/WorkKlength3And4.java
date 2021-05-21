import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorkKlength3And4 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        Map<Character,Integer> lastVisited = new HashMap<>();
        String unqiueString = "";
        Map<Character,Integer> countMap = new HashMap<>();

        Set<Character> canPlace = new HashSet<>();

        for(char ch : str.toCharArray()) {

            if(!canPlace.contains(ch)){
                canPlace.add(ch);
                lastVisited.put(ch,-1);
                unqiueString += ch;
                countMap.put(ch,1);
            } else {
                countMap.put(ch,countMap.get(ch) + 1);
            }
        }

        permutationOfKWord(0, str, lastVisited, canPlace, new Character[k], 0, k);
        System.out.println("*********************************************************************");
        permutationOfWord2(1, k, countMap, "", unqiueString.toCharArray());
    }

    // word as level
    public static void permutationOfKWord(int ci, String word, Map<Character,Integer> lastVisited, 
    Set<Character> toVisit, Character[] ans, int is, int ts) {


        if(ci == word.length()) {
            if(is == ts) {
                for(char ch : ans){
                    System.out.print(ch);
                }
                System.out.println();
            }

            return;
        }
        // for ever char 
        char ch = word.charAt(ci);

        // to place it in every avaliable spots
        int lvi = lastVisited.get(ch);
        if(toVisit.contains(ch)) {
            for(int i = lvi+1; i < ans.length; i++) {

                if(ans[i] == null) {
                    ans[i] = ch;
                    lastVisited.put(ch, i);
                    permutationOfKWord(ci+1, word, lastVisited, toVisit, ans,is+1,ts);
                    lastVisited.put(ch, lvi);
                    ans[i] = null;
                }
            }
        }

        boolean flag = toVisit.contains(ch);

        if(flag)
            toVisit.remove(ch);
        permutationOfKWord(ci+1, word, lastVisited, toVisit, ans,is,ts);
        if(flag)
            toVisit.add(ch);
        return;
    } 

    // place / sopt as levels
    public static void permutationOfWord2(int cs, int ts, Map<Character,Integer> countMap, String asf, char[] unqString) {

        if(cs > ts) {
            System.out.println(asf);
            return;
        }

        for(char ch : unqString) {
            int count = countMap.get(ch);
            if(count > 0 ){
                countMap.put(ch, count-1);
                permutationOfWord2(cs+1, ts, countMap, asf+ch, unqString);
                countMap.put(ch, count);
            }
        }
    }
}
