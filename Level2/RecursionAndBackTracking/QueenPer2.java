import java.io.*;

// Queen Permutation as 2-D
public class QueenPer2 {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        
        if(row == tq) {
            
            if(qpsf == tq) {
                System.out.println(asf + "\n");
            }
            
            return;
        }
        
        int ni, nj;
        
        String end;
        if(col == tq-1) {
            ni = row+1;
            nj = 0;
            end = "\n";
        } else{
            ni = row;
            nj = col + 1;
            end = "\t";
        }
        
        // if selected 
        
        for(int i = 1; i <= tq; i++) {
            
            if(queens[i-1])
                continue;
                
            queens[i-1] = true;
            queensPermutations(qpsf+1,tq,ni,nj,asf + "q" + i + end,queens);
            queens[i-1] = false;
        }
        
        // if not selected 
        queensPermutations(qpsf,tq,ni,nj,asf + "-" + end,queens);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}