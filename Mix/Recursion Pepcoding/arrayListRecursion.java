import java.util.ArrayList;
import java.util.Scanner;

class arrayListRecursion {
    public static void main(String[] args) {
        
    }

    public static ArrayList < String > gss(String str) {
        //ArrayList<String> ls = new ArrayList<>();
        
        return null;
    }

    static String[] keys = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static ArrayList<String> getKPC(String str) {
        
        if (str.length() == 0) {
            ArrayList<String> solution = new ArrayList<>();
            solution.add("");
            return solution;
        }

        ArrayList<String> solution = getKPC(str.substring(1));
        ArrayList<String> solutionNew = new ArrayList<>();
        char key = str.charAt(0);
        String alpha = keys[key - '0'];
        for(int  i = 0; i < alpha.length(); i++){
            char first = alpha.charAt(i);
            for (String rest : solution) {
                solutionNew.add(first + rest);
            }
            
        }
        return solutionNew;
    }

}

class NQueenProblem {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] chess = new int[n][n];
        printNQueens(chess,"",0);
        sc.close();
        
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if (row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }
        for (int i = 0; i < chess.length; i++) 
            if(isSafePos(chess,row,i) == true){
                chess[row][i] = 1;
                printNQueens(chess,qsf + row + "-" + i + ", ",row+1 );
                chess[row][i] = 0;
            }
    }
    
    public static boolean isSafePos(int[][] chess,int row, int col ) {
        
        for (int i = row -  1, j = col; i >= 0; i--)
            if (chess[i][j] == 1)
                return false;
                
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; j--, i--)
            if (chess[i][j] == 1 )
            return false;
        
        for (int i = row-1, j = col+1; i >= 0 && j < chess.length; j++, i--)
            if (chess[i][j] == 1 )
            return false;
            
        return true;
    }
}

class KinghtsTour {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        // knight visit each cell exactyle once
        int chess[][] = new int[n][n];
        printKnightsTour(chess, r, c, 1);
        sc.close();
        
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0)
            return;
            
        if (move == chess.length * chess.length) {
            
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
            return ;
        }
        
        chess[r][c] = move;
        printKnightsTour(chess, r-2, c+1, move+1);
        printKnightsTour(chess, r-1, c+2, move+1);
        printKnightsTour(chess, r+1, c+2, move+1);
        printKnightsTour(chess, r+2, c+1, move+1);
        printKnightsTour(chess, r+2, c-1, move+1);
        printKnightsTour(chess, r+1, c-2, move+1);
        printKnightsTour(chess, r-1, c-2, move+1);
        printKnightsTour(chess, r-2, c-1, move+1);
        chess[r][c] = 0;
        
        return;
        
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}