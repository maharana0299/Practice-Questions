import java.util.Scanner;

public class NQueenBranchAndBound {
    
    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];        
        printNQueenPath(0,board,"");
        scn.close();
    }
    
    public static void printNQueenPath(int i, boolean[][] board, String psf) {
        
        if(i == board.length) {
            System.out.println(psf+".");
        }
        for(int c = 0; c < board.length; c++) {
            
            if(isSafe(i,c,board)) {
                board[i][c] = true;
                printNQueenPath(i+1,board,psf+i+"-"+c+", ");
                board[i][c] = false;
            }
        }
    }
    
    public static boolean isSafe(int r, int c, boolean[][] board) {
        
        for(int i = r-1; i >= 0; i--){
            if(board[i][c])
                return false;
        }
        
        for(int j = c-1; j >= 0; j--) {
            if(board[r][j])
                return false;
        }
        
        for(int i = r-1, j = c-1; i >= 0 && j >= 0; i--,j--) {
            if(board[i][j])
                return false;
        }
        
        for(int i = r-1, j = c+1; i >= 0 && j < board[0].length; i--,j++) {
            if(board[i][j])
                return false;
        }
        return true;
    }

}
