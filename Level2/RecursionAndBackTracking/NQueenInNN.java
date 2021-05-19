import java.io.*;

public class NQueenInNN {

    public static void queensCombinations(int qsf, int tq, int row, int col, String asf){
       
       
        if(row == tq) {
            if(qsf == tq) {
                System.out.println(asf);
            }
            
            return;
        }
        int ni = 0;
        int nj = 0;
        
        if(col == tq-1) {
            ni = row+1;
            nj = 0;
            
            queensCombinations(qsf+1,tq,ni,nj,asf + "q\n");
            queensCombinations(qsf,tq,ni,nj,asf + "-\n");
        } else {
            ni = row;
            nj = col + 1;
            queensCombinations(qsf+1,tq,ni,nj,asf + "q");
            queensCombinations(qsf,tq,ni,nj,asf + "-");
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}
