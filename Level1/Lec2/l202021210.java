package Lec2;

public class l202021210 {
   public static void main(String[] args) {
       
   } 

   public static void printDiagonal(int[][] arr){

    for (int gap = 0; gap < arr[0].length; gap++){
       for (int i =0, j = gap; i < arr.length && j < arr[0].length; i++, j++) {
           System.out.println(arr[i][j]);
       } 

    }
   }

   public static void saddlePoint(int arr[][]) {

       /**
        * Point where min of row and max of col
        */
        int m = arr[0].length; // m columns
        int n = arr.length; // n rows
        
        for (int r = 0; r < n; r ++) {
            
            int c = 0;
            int minEle = Integer.MAX_VALUE;

            // check for a row r
            for(int j = 0; j < m; j++) {
                
                if (arr[r][j] < minEle) {
                    minEle = arr[r][j];
                    c = j;
                }
            }

            boolean saddlePoint = true;

            // check for column c
            for (int i = 0; i < n; i++) {
                if (arr[i][c] > minEle) {
                    saddlePoint = false;
                    break;
                }

            }

            if ( saddlePoint ) {
                System.out.println(minEle);
                return ;
            }
        }
        System.out.println("Invalid Input");
    }

    public static void waveTraversal(int[][] arr){
        int m = arr[0].length; // m columns
        int n = arr.length; // n rows

        /**
         *  2 3 4 5 
         *  3 6 7 9 
         *  2 6 7 10
         */

         boolean isUp = false;
         for (int j = 0; j < m; j++) {
             if (!isUp) {
                for(int i = 0; i < n; i++) {
                     System.out.println(arr[i][j]);
                }
                 
             } else {
                 for (int i = n-1; i >= 0; i--) {
                    System.out.println(arr[i][j]);
                 }
             }
             isUp = isUp ? false: true;
         }
    }

    public static void searchInSortedMatrix(int[][] arr, int data) {
        /**
         * start from arr[0][length-1]
         * if data is greater then move down
         * else data is smaller move left
         * else if equal then print and return
         */
        int i = 0, j = arr[0].length - 1;

        while (i < arr.length && j >= 0) {
            if (arr[i][j] == data) {
                System.out.println(i + "\n" + j);
                return;
            } else if (arr[i][j] < data) i++;
            else 
                j--;
        }
        System.out.println("Not Found");
    }

    public static void rotate90(int [][] arr) {
        int n = arr.length;
        //transpose
        for (int i = 0; i < n; i++){

            for (int j = i; j < n; j++) {

                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;

            }
        }

        int c1 = 0, c2 = n -1;

        while(c1<c2) {

            for (int r = 0; r < n; r++){ 
               int e1 = arr[r][c1];
               int e2 = arr[r][c2];

               arr[r][c1] = e2;
               arr[r][c2] = e1; 
            }
            c1++;
            c2--;
        }

    }

    public static void shellRotate(int[][] arr, int shellNumber, int r) {
        int oned[] = shellTo1d(arr, shellNumber);

        rotate(oned, r);
        
        onedToShell(oned,arr,shellNumber);
    }
    
    public static void rotate(int[] oned, int r){
        r = r % oned.length;
        if (r < 0) {
            r += oned.length;
        }
        
        reverseArray(oned, 0,oned.length - r - 1);
        reverseArray(oned, oned.length - r, oned.length - 1);
        reverseArray(oned, 0, oned.length - 1);

    }
    

    private static void onedToShell(int[] oned,int[][] arr, int shellNumber) {
        int rmin = shellNumber - 1;
        int rmax = arr.length - shellNumber;
        int cmin = shellNumber - 1;
        int cmax = arr[0].length - shellNumber;
        int indx = 0;

        for(int r =rmin; r <= rmax; r++) {
             (arr[r][cmin]) = oned[indx++];
           
        }
        cmin++;

        for(int r = cmin; r <= cmax; r++) {
            arr[rmax][r] = oned[indx++];
        }
        rmax--;

        for(int r = rmax; r >= rmin; r--) {
            arr[r][cmax] = oned[indx++];
        }
        cmax--;

        for(int r = cmax; r >= cmin; r--) {
            arr[rmin][r] = oned[indx++];
        }
        rmin++;

    }

    private static void reverseArray(int[] oned, int l, int r) {
        while(l < r) {
            int temp = oned[l];
            oned[l] = oned[r];
            oned[r] = temp;

            l++;
            r--;
        }
    }

    public static int[] shellTo1d(int arr[][], int shellNumber) {
        
        int rmin = shellNumber - 1;
        int rmax = arr.length - shellNumber;
        int cmin = shellNumber - 1;
        int cmax = arr[0].length - shellNumber;
        
        int count = 2 * (rmax - rmin + cmax - cmin);
        
        
        int indx = 0;
        int [] oned = new int[count];
        while (count > 0){

            for(int r =rmin; r <= rmax && count > 0; r++) {
                oned[indx++] = (arr[r][cmin]);
                count--;
            }
            cmin++;

            for(int r = cmin; r <= cmax && count > 0; r++) {
                oned[indx++] = (arr[rmax][r]);
                count--;
            }
            rmax--;

            for(int r = rmax; r >= rmin && count > 0; r--) {
                oned[indx++] = arr[r][cmax];
                count--;
            }
            cmax--;

            for(int r = cmax; r >= cmin && count > 0; r--) {
                oned[indx++] = arr[rmin][r];
                count--;
            }
            rmin++;
        }
        
        return oned;
    }

    public static void spiralDisplay(int[][] arr){

        int n = arr.length;
        int m = arr[0].length;
        int rmin = 0;
        int rmax = n-1;
        int cmin = 0;
        int cmax = m-1;
        int count = m * n;

        while (count != 0) {
            for(int r =rmin; r <= rmax && count > 0; r++) {
                System.out.println(arr[r][cmin]);
                count--;
            }
            cmin++;

            for(int r = cmin; r <= cmax && count > 0; r++) {
                System.out.println(arr[rmax][r]);
                count--;
            }
            rmax--;

            for(int r = rmax; r >= rmin && count > 0; r--) {
                System.out.println(arr[r][cmax]);
                count--;
            }
            cmax--;

            for(int r = cmax; r >= cmin && count > 0; r--) {
                System.out.println(arr[rmin][r]);
                count--;
            }
            rmin++;
        }
    }




public static int LCM(int a, int b, int gcd) {
    return ((a/gcd) * b);
}

public static int GCD (int a, int b) {
    int divisor = a;
    int dividend = b;
    
    while(dividend % divisor != 0) {
        int rem = dividend % divisor;
        dividend = divisor;
        divisor = rem;
    }
    
    return divisor;
}

}