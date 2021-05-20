import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Queen2Das1D {
    
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        
        
        if(qpsf == tq){
            
            for(int i = 0; i < tq; i++) {
                for(int j = 0; j < tq; j++) {
                    
                    if(chess[i][j]) {
                        System.out.print("q\t");
                    } else{
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int cell = lcno + 1; cell < tq * tq; cell++) {
            
            int r = cell/tq;
            int c = cell % tq;
            
            chess[r][c] = true;
            queensCombinations(qpsf  + 1, tq,chess,cell);
            chess[r][c] = false;
        }
        
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
