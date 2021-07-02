import java.io.*;
import java.util.*;



public class MatrixChainMultiplication {

	static int[][] mem;
	public static int mcm(int[] arr){

		return 0;
	}

    static int mcm(int[] p, int i, int j){

        if(i == j){
            return 0;
        }

		if(mem[i][j] != 0){
			return mem[i][j];
		}
		
		int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++)
        {
            int count = mcm(p, i, k)
                        + mcm(p, k + 1, j)
                        + p[i - 1] * p[k] * p[j];
 
            if (count < min)
                min = count;
        }
 
		
        return mem[i][j] =  min;
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Scanner scn = new Scanner(System.in);
		// int n = scn.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		mem = new int[n][n];
		for(int i = 0 ; i < n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(mcm(arr,1,n-1));
	}
}