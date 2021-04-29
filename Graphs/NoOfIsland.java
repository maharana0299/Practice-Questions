import java.io.BufferedReader;

/**
 * IsIsland
 * Application of Connected Component 
 * Find No of Connected Components
 */
public class NoOfIsland {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];
  
        for (int i = 0; i < arr.length; i++) {
           String parts = br.readLine();
           for (int j = 0; j < arr[0].length; j++) {
              arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
           }
        }
  
        int islands = 0;
        // Every cell is conneted to its side 
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] != 1) {
                   islands++;
                   findAllConnected(arr,i,j); 
                }
            }
        }

        System.out.println(islands);
    }

    private static void findAllConnected(int[][] arr, int i, int j) {

        if(arr[i][j] == 1)
            return;
        arr[i][j] = 1;

        if(i > 0)
            findAllConnected(arr, i-1, j);
        if(j > 0)
            findAllConnected(arr, i, j-1);
        if(i < arr.length-1) 
            findAllConnected(arr, i+1, j);
        if(j < arr[0].length-1)
            findAllConnected(arr, i, j+1);
    }
}