import java.util.Scanner;

public class CollectGold {
    

    static int max = 0;
	public static void getMaxGoldRec(int[][] arr){
	
		for(int i = 0; i < arr.length; i++) {
		    for(int j = 0; j < arr[0].length; j++) {
		        
		        if(arr[i][j] != 0) {
		            int pro = getProfit(i,j,arr);
		            if(pro > max)
		                max = pro;
		        }
		    }
		}
		
	}
	

    // pure recusive approach
	public static int getProfit(int i, int j, int[][] gold) {
	    
	    if(i < 0 || j < 0 || i >= gold.length || j >= gold[0].length || gold[i][j] == 0)
	        return 0;
	  
	    // 2 op 
	    int ijc = gold[i][j];
	    
	    int ln = ijc;
	    int mU, mD, mL, mR;
	    mU = mR = mD = mL = 0;
	    
	    gold[i][j] = 0;
	    
	    mU = getProfit(i-1,j,gold);
	    mR = getProfit(i,j+1,gold);
	    mL = getProfit(i,j-1,gold);
	    mD = getProfit(i+1,j,gold);
	    
	    int in = ijc + (mU + mR + mL + mD);
	    
	    return Math.max(ln,in);
	}
	
	static int max(int a, int b, int c, int d) {
	    
	    int max = a;
	    
	    if(b > max)
	        max = b;
	    if(c > max)
	        max = c;
        if(d > max)
            max = d;
        return max;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
        scn.close();
	}


    // dfs and list
    private static void getMaxGold(int[][] arr) {
    }
}
