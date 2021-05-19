
import java.io.*;

public class QueenComb2 {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        
        
        if(i == tq) {
            if(tq == qpsf) {
                
                for(int in = 0; in < tq; in++) {
                    for(int jn = 0; jn < tq; jn++) {
                        
                        if(chess[in][jn])
                        System.out.print("q" + "\t");
                        else System.out.print("-\t");
                    }
                    System.out.println();
                }
                
                System.out.println();
            }
            
            return;
        }
        
        int ni, nj;
        
        if(j == tq-1) {
            ni = i+1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }
        
        
    
        chess[i][j] = true;
        queensCombinations(qpsf + 1, tq, chess, ni, nj);
        chess[i][j] = false;

        
        queensCombinations(qpsf,tq,chess,ni,nj);
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, 0);
    }

    // start with j = -1 i = 0
    public static void queensCombinations2(int qpsf, int tq, boolean[][] chess, int i, int j){
        
        
        if(tq == qpsf ) {
            
            for(int in = 0; in < tq; in++) {
                for(int jn = 0; jn < tq; jn++) {
                    
                    if(chess[in][jn])
                    System.out.print("q" + "\t");
                    else System.out.print("-\t");
                }
                System.out.println();
            }
            
            System.out.println();
            return;
        } 
            
        for(int col = j + 1; col < chess.length; col++) {
            chess[i][col] = true;
            queensCombinations2(qpsf+1,tq,chess,i,col);
            chess[i][col] = false;
        }
        
        for(int row = i + 1; row < chess.length; row++) {
           for(int col = 0; col < chess.length; col++) {
                chess[row][col] = true;
                queensCombinations2(qpsf+1,tq,chess,row,col);
                chess[row][col] = false;
            } 
        }
        
    }
}