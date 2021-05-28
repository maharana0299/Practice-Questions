// import java.io.*;
import java.util.*;

public class SudokuUsingBit {

  public static void display(int[][] arr){
    for (int ii = 0; ii < arr.length; ii++) {
      for (int jj = 0; jj < arr.length; jj++) {
        System.out.print(arr[ii][jj] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
   * @param arr -> sudoku comtainer
   * rows -> it represents 9 rows and rwos[i] contains a binary number with 0th bit represents 1, and so on till 8th bit. If any number is present in the 
   * sudoku then its bit is set else it is unset (0)
   * cols -> same as rows 
   * grid -> its a 3*3 matrix witch each gird element represents the sections. In 9*9 matrix, we have 9 sub-sections 
   * each section is represented through its first element which is i/3, j/3 
   * grid[i][j] contains the number contained in that section on the sudoku. If 9 is present in that section then it is set(1) else its bit is unset
   * 
   * for an number, if its not contaned in row[i], col[j] and grid[i/3][j/3] then only it is eligibe to be placed in the sudoku as it is following all tghe rules
   */
  public static void solveSudoku(int[][] arr, int[] rows, int[] cols, int[][] grid, int i, int j) {
    
    
    if(i == arr.length) {
        display(arr);
        return;
    }
    int ni,nj;
    
    if(j == arr.length-1) {
        ni = i+1;
        nj = 0; 
    } else {
        ni = i;
        nj = j+1;
    }
    
    if(arr[i][j] > 0) { // if alredy filled then skip to next
        solveSudoku(arr,rows,cols,grid,ni,nj);
    } else {
        
        for(int num = 1; num <= 9; num++) {
            // if not filled then it have 9 options
            
            // checking if it is valid 
            if(
                (rows[i] & (1<<num)) == 0 &&
                (cols[j] & (1<<num)) == 0 &&
                (grid[i/3][j/3] &  (1<<num)) == 0 
            ){
                arr[i][j] = num;
                rows[i] ^= (1<<num);
                cols[j] ^= (1<<num);
                grid[i/3][j/3] ^= (1<<num);
                solveSudoku(arr,rows,cols,grid,ni,nj);
                arr[i][j] = 0;
                rows[i] ^= (1<<num);
                cols[j] ^= (1<<num);
                grid[i/3][j/3] ^= (1<<num);
            }
        }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[][] grid = new int[3][3];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int digit = scn.nextInt();
        arr[i][j] = digit;
        rows[i] |= (1 << digit);
        cols[j] |= (1 << digit);
        grid[i / 3][j / 3] |= (1 << digit);
      }
    }

    solveSudoku(arr, rows, cols, grid, 0, 0);
  }

}