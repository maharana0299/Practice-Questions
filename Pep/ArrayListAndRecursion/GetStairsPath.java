import java.util.ArrayList;
import java.util.Scanner;

import jdk.internal.jshell.tool.resources.l10n;

/**
 * GetStairsPath
 */
public class GetStairsPath {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);
        sc.close();
    }

    public static ArrayList<String> getStairPaths(int n) {
        
        if(n < 0)
            return null;
        if(n == 0){
            ArrayList<String> ls = new ArrayList<>();
            ls.add("");
        }
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> l1 = getStairPaths(n-1);

        for(String l : l1) {
            ans.add(1+l);
        }
        l1 = getStairPaths(n-2);

        for(String l : l1) {
            ans.add(1+l);
        }

        l1  = getStairPaths(n-3);

        for(String l : l1) {
            ans.add(1+l);
        }

        return ans;
    }
}