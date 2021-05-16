package Codeforces;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeForce_1481B {
    public static void main(String... args) throws FileNotFoundException {

        File f = new File("input.txt");

        Scanner sc = new Scanner(f);
        
        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            int kPos = flatMountains(arr,k);
            System.out.println(kPos);
        }

        sc.close();
    }

    private static int flatMountains(int[] arr, int k) {
        
        int i = 0;
        int length = arr.length;
        while (i < length -1 && k > 0){
            // if (k == 0) 
            //     return i;

            // if (i == length-1)
            //     return -1;
        
            if (arr[i] >= arr[i+1])
                i++;
            else if (arr[i] < arr[i+1]) {
                k--;
                arr[i] += 1;
                if (k == 0)
                    break;
                if (i != 0) i = i-1;
            }
        }

        if (i == length -1 )
            return -1;
        else return i + 1;
    }




}

// Ab Tree Problem Codeforce

class ADBtree {
    
    // public void inputs() throws FileNotFoundException {
    //     File f = new File("adbtree.txt");

    //     Scanner sc = new Scanner(f);

    //     int n = sc.nextInt();
    //     int x = sc.nextInt();

    //     int arr[] = new int[n];

    //     for (int i = 0; i < n; i++) {
    //         arr[i] = sc.nextInt();
    //     }
    //     Map<Integer,Integer> rootCount = getRootCount(arr);
    //     int stringCount = 0;
    //     int tmp;
    //     for (int i = 0; i < n; i++) {
    //         if (x == 0 && y == 0 )
    //             break;
    //         if (rootCount.get(i) != null) {
    //             tmp = rootCount.get(i);
    //             if (x > tmp) {
    //                 x -= tmp;
    //                 stringCount++;
    //             } else if (y > tmp) {
    //                 y -= tmp;
    //                 stringCount++;
    //             } else {
                    
    //             }
    //         }
    //     }
    //     sc.close();
    // }

    public Map<Integer,Integer> getRootCount(int[] arr) {
        Map<Integer,Integer> m = new HashMap<>();
        
        for (int i : arr) {
            if (m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            } else {
                m.put(i,1);
            }
        }
        return m;
    }

    public static ArrayList<String> getStairPaths(int n) {
        
        if (n == 0) {
            ArrayList<String> ls = new ArrayList<>();
            ls.add("");
            return ls;
        }
        
        if (n < 0) {
             ArrayList<String> ls = new ArrayList<>();
            return ls;
        }
        
        ArrayList<String> getString = getStairPaths(n-1); 
        ArrayList<String> getString1 = getStairPaths(n-2);
        ArrayList<String>getString2 = getStairPaths(n-3);
        
        ArrayList<String> ns = new ArrayList<>();
        for (String i : getString) {
           ns.add("1" + i);
        }
        
       
        for (String i : getString1) {
           ns.add("2" + i);
        }
        
      
        for (String i : getString2) {
           ns.add("3" + i );
        }
        
        return ns;
       
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
        
        if (sc == dc && sr == dr){
            ArrayList<String> solution = new ArrayList<>();
            solution.add("");
            return solution;
        }
        ArrayList<String> horizontal = new ArrayList<>();
        ArrayList<String> vertical  = new ArrayList<>();
        ArrayList<String> diagonal = new ArrayList<>();
        
        ArrayList<String> solution = new ArrayList<>();
        
        if (sc < dc) {
            int m = dc - sc;
            for (int i = 1; i <= m; i++) {
                horizontal = getMazePaths(sr,sc + i,dr,dc);
                for (String in : horizontal) {
                    solution.add("h" + i + in);
                }
            }
        }
        
        if (sr < dr ) {
            int m =  dr - sr;
            for (int i = 1; i <= m; i++) {
                vertical = getMazePaths(sr + i,sc,dr,dc);
                for (String in : vertical) {
                    solution.add("v" + i + in);
                }
            }
        }
        int d = Math.min(dr - sr,dc - sc);
        if (d > 0) {
            for (int i = 1; i <= d; i++) {
                diagonal = getMazePaths(sr + i,sc + i,dr,dc);
                for(String in : diagonal) {
                    solution.add("d" + i + in);
                }
            }
            
        }
       
        
        return solution;
    }

}