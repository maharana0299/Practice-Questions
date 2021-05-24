import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class WorkKlength4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        Map<Character, Integer> lastVisited = new HashMap<>();
        String unqiueString = "";
        Map<Character, Integer> countMap = new HashMap<>();

        Set<Character> canPlace = new HashSet<>();

        for (char ch : str.toCharArray()) {

            if (!canPlace.contains(ch)) {
                canPlace.add(ch);
                lastVisited.put(ch, -1);
                unqiueString += ch;
                countMap.put(ch, 1);
            } else {
                countMap.put(ch, countMap.get(ch) + 1);
            }
        }

        permutationOfWord(1, k, countMap, "", unqiueString.toCharArray());
    }


    // place / sopt as levels
    public static void permutationOfWord(int cs, int ts, Map<Character, Integer> countMap, String asf,
            char[] unqString) {

        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        for (char ch : unqString) {
            int count = countMap.get(ch);
            if (count > 0) {
                countMap.put(ch, count - 1);
                permutationOfWord(cs + 1, ts, countMap, asf + ch, unqString);
                countMap.put(ch, count);
            }
        }
    }
}

class WordKLength3 {

    public static void generateWords(int cc, String str, int ssf, int ts, Character[] spots,

            HashMap<Character, Integer> lastOccurence) {

        if (cc == str.length()) {
            if (ssf == ts) {
                for (char ch : spots) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            return;
        }

        char ch = str.charAt(cc);
        int lo = lastOccurence.get(ch);
        for (int i = lo + 1; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                lastOccurence.put(ch, i);
                generateWords(cc + 1, str, ssf + 1, ts, spots, lastOccurence);
                lastOccurence.put(ch, lo);
                spots[i] = null;
            }
        }
        if (lastOccurence.get(ch) == -1) {
            generateWords(cc + 1, str, ssf + 0, ts, spots, lastOccurence);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        Character[] spots = new Character[k];
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for (char ch : str.toCharArray()) {
            lastOccurence.put(ch, -1);
        }

        generateWords(0, str, 0, k, spots, lastOccurence);
    }
}