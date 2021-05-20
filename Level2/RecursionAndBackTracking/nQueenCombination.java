import java.io.*;

public class nQueenCombination {

    public static boolean isQueenSafe(int[][] chess, int row, int col) {
        
        // top
        for(int i = row - 1, j = col; i >= 0; i-- ){
            if(chess[i][j] != 0)
                return false;
        }
        
        // down
        for(int i = row+1, j = col; i < chess.length; i++){
            if(chess[i][j] != 0)
                return false;
        }
        
        // left
        for(int i = row, j = col - 1; j >= 0; j--) {
            if(chess[i][j] != 0)
                return false;
        }
        
        // right 
        for(int i = row, j = col+1; j < chess.length; j++) {
            if(chess[i][j] != 0)
                return false;
        }
        
        // top left
        for(int i = row-1, j = col - 1; i >= 0 && j >= 0; i--,j--) {
            if(chess[i][j] != 0)
                return false;
        } 
        
        // top right
        for(int i = row-1, j =col + 1; i >= 0 && j < chess.length; i--,j++) {
            if(chess[i][j] != 0)
                return false;
        }
        
        // bl
        for(int i = row + 1, j = col - 1; i < chess.length && j >= 0; i++,j-- ) {
            if(chess[i][j] != 0)
                return false;
        }
        
        // br
        for(int i = row+1, j = col+1; i < chess.length && j < chess.length; i++, j++) {
            if(chess[i][j] != 0)
                return false;
        }
        
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        
        if(qpsf == tq) {
            for(int i = 0; i < tq; i++) {
                for(int j = 0; j < tq; j++) {
                    if(chess[i][j] != 0){
                        System.out.print("q" + chess[i][j] + "\t"); 
                    } else{
                        System.out.print("-\t");
                    }
                    
                }
                System.out.println();
            }  
            System.out.println();
            return;
        }
     
        for(int i = 0; i < tq; i++) {
            for(int j = 0; j < tq; j++) {
                
                if(chess[i][j] == 0 && isQueenSafe(chess,i,j)) {
                    chess[i][j] = qpsf + 1;
                    nqueens(qpsf+1,tq,chess);
                    chess[i][j] = 0;
                }
            }
        }   
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}