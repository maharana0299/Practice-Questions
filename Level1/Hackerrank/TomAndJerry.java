package Hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TomAndJerry {
    
    static int arr[];
    public static void main(String[] args) throws FileNotFoundException {
        
        File f = new File("input.txt");
        Scanner sc = new Scanner(f);
  

        int tomPos = 1;
        int jerryPos = 1000000;
        
        int n = sc.nextInt();
        
        int indices[] = new int[n];
        int in[] = {};
        for(int i = 0; i < n; i++) {
            indices[i] = sc.nextInt();
        }

        int times  = 0;

        Arrays.sort(indices);
        in = indices;
        Arrays.sort(in);
        for(int i = 0; i < indices.length; i++) {

            // System.out.print(in[i] + " ");
            // System.out.println(indices[i]);
            int d1 = Math.abs(indices[i]-tomPos);
            int d2 = Math.abs(indices[i] - jerryPos);

            if(d1 < d2) {
                System.out.println("d1 " + d1);
                times += d1;
                tomPos = tomPos +  d1;
            } else {
                System.out.println("d2 " + d2);
                times += d2;
                jerryPos = jerryPos - d2;
                break;
            }
        }

        System.out.println(times);

        sc.close();
    }
    
}
