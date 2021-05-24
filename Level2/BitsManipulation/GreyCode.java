import java.util.*;

public class GreyCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) {
            ans.add(0);
            return ans;
        }
        backtrack(ans, n);
        return ans;
    }

    static int temp;

    private static void backtrack(List<Integer> ans, int n) {
        if (n == 0) {
            ans.add(temp);
            return;
        }

        // for this half -> 1st element 0 will be added then 
        backtrack(ans, n - 1);
        //                                 00
        // temp will be 0 ^ 1 ->           01 
        // for next temp = 1 ^ 10 ->       11
        // for next                        10
        temp = temp ^ (1 << (n - 1));
        backtrack(ans, n - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<Integer> ans = grayCode(scn.nextInt());
        Collections.sort(ans);
        System.out.println(ans);
        scn.close();
    }

    static List<String> greyCode(int n) {

        if(n == 1) {
            List<String> ls = new ArrayList<>();
            ls.add("0");
            ls.add("1");
            return ls;
        }
        List<String> ans = greyCode(n-1);
        List<String> myres = new ArrayList<>(2*ans.size());
        for(int i = 0; i < ans.size(); i++) {
            myres.add("0" + ans.get(i));
        }

        // in reverse order now 
        for(int i = ans.size()-1; i >= 0; i--) {
            myres.add("1" + ans.get(i));
        }
        return myres;
    }
}