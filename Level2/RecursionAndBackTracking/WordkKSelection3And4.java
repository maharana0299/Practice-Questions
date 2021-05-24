// package RecursionAndBackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * WordkKSelection3
 */
public class WordkKSelection3And4 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    HashSet<Character> set = new HashSet<>();
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        set.add(ch);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }
    combK(1, k, ustr, unique, "", 0);
  }

  // placed spots on level
  // each spot has option to select last selected charactrer if possible or to
  // select next character
  // this is an combination problem hence we are not exploring all the other
  // options
  public static void combK(int ci, int ts, String str, HashMap<Character, Integer> map, String asf, int lc) {

    if (ci > ts) {
      System.out.println(asf);
      return;
    }

    for (int i = lc; i < str.length(); i++) {

      char ch = str.charAt(i);
      int freq = map.get(ch);

      if (freq > 0) {
        map.put(ch, freq - 1);
        combK(ci + 1, ts, str, map, asf + ch, i);
        map.put(ch, freq);
      }
    }
  }

}

class WorkKSel3 {

  public static void generateSelection(int cc, String ustr, int ssf, int ts, HashMap<Character, Integer> unique,
      String asf) {
    if (cc == ustr.length()) {
      if (ssf == ts) {
        System.out.println(asf);
      }
      return;
    }

    char ch = ustr.charAt(cc);
    for (int i = unique.get(ch); i > 0; i--) {
      char[] fasf = new char[i];
      Arrays.fill(fasf, ch);
      generateSelection(cc + 1, ustr, ssf + i, ts, unique, asf + new String(fasf));
    }
    generateSelection(cc + 1, ustr, ssf + 0, ts, unique, asf);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }

    generateSelection(0, ustr, 0, k, unique, "");
  }
}