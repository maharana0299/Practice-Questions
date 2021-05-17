import java.util.Scanner;

public class SudokuSolver {
    
    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[0].length; j++){
            System.out.print(board[i][j] + " ");
          }
          System.out.println();
        }
      }
      
      /**
       *  in a row: digits 1 - 9
       *  in a column: digits 1 - 9
       *  in a 3 * 3 : digits 1 - 9
      **/
      public static void solveSudoku(int[][] board, int i, int j) {
        
        if(i == board.length) {
            display(board);
            return;
        }
        
        // iterate over each element in level order
        int ni;
        int nj;
        
        if(j == board.length-1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }
        
        // if already contained a value then skip 
        if(board[i][j] != 0) {
            solveSudoku(board,ni,nj);
        } else {
            // lets explore possible option 
            for(int po = 1; po <= 9; po++) {
                if(isValidOption(board,i,j,po)) {
                    board[i][j] = po;
                    solveSudoku(board,ni,nj);
                    board[i][j] = 0;
                }
            }
        }
      }
      
      public static boolean isValidOption(int[][] board, int x, int y, int val) {
          
          // look in row
          for(int i = 0; i < board.length; i++) {
              if(board[i][y] == val)
                return false;
          }
          
          // for col 
          for(int j = 0; j < board[0].length; j++) {
              if(board[x][j] == val)
                return false;
          }
          
          // look in the current box
          int smi = x/3 * 3;
          int smj = y/3 * 3;
          
          for(int i = 0; i < 3; i++) {
              for(int j = 0; j < 3; j++) {
                  if(board[smi + i][smj + j] == val) {
                      return false;
                  }
              }
          }
          
          return true;
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            arr[i][j] = scn.nextInt();
          }
        }

        scn.close();
        solveSudoku(arr, 0, 0);
      }
}
