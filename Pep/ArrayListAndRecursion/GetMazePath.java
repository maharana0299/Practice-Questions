import java.util.ArrayList;
import java.util.Scanner;

/**
 * GetMazePaths
 */
public class GetMazePath {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(getMazePaths(0, 0, n, m));
        sc.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
        if(sr == dr && sc == dc){

            ArrayList<String> ls = new ArrayList<>();
            ls.add("");
            return ls;
        } 

        if(sr == dr || sc == dc)
            return new ArrayList<>();

        ArrayList<String> newList; = new ArrayList<>();

        ArrayList<String> ls ;
        
        ls =  getMazePaths(sr, sc+1, dr, dc);
        

        for(String s : ls) {
            newList.add("h" + s);
        }

        ls = getMazePaths(sr+1, sc, dr, dc);

        for(String s : ls) {
            newList.add("v"+s);
        }

        return newList;
    }
}