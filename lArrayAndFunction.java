import java.util.Arrays;
import java.util.Scanner;

public class lArrayAndFunction {
    public static void main(String[] args) {
        
    }

    public static int getDigitFrequency(int n, int d){
        int count = 0;
        while(n != 0) {
            if (d == n%10)
                ++count;
            
                n /= 10;
        }
        return count;
    }

    public static int getValueInBase(int n, int b){
        int val = 0;

        int p =1;
        while(n > 0) {
            int dig = n%b;
            n /= b;
            val += dig * p;
            p = p * 10;
            
        }

        return val;
    }

    public static int getValueIndecimal(int n, int b){
        int num = 0;

        int p = 0;
        while (n > 0) {
            int dig = n % 10;
            num += Math.pow(b,p) * dig; 
            p++;
            n /= 10;
            
        }

        return num;
    }

    public static int getDifference(int b, int n1, int n2){
        // write your code here
        n1  = getValueIndecimal(n1,b);
        n2 = getValueIndecimal(n2,b);
        int n3 = (n1>n2) ? n1-n2 : n2-n1;
        return getValueInBase(n3,b);
    }

    public static void spanOfArray() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        while (n-- > 0){
            int num = sc.nextInt();
            
            if (min > num)  min = num;
            if (max < num)  max = num;
        }
        sc.close();
        System.out.print(max - min);
    }

    public static void findAnElementInAnArray(){
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int num = sc.nextInt();
        int index = -1;
        for(int i = 0; i < n; i++) {
            if (arr[i] == num) {
                index = i;
                break;
            }
        }
        
        System.out.println(index);
        sc.close();
    }

    public static void barChart() {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            
            if (arr[i] > max)   max = arr[i];
        }
        
        for (int i = max; i > 0; --i) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] >= i) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        sc.close();
    }

    public static void printArray(int[] a) {
        for(int i = 0; i < a.length; i++) {
             System.out.println(a[i]);
        }
        
     }
     
    public static int[] addTwo(int[] a, int[] b) {
    
        int n1 = a.length;
        int n2 = b.length;

        int [] sum = new int[ n1>n2 ? n1 : n2];

        int c = 0;

        int i = a.length - 1;
        int j = b.length - 1;
        int k = sum.length - 1;

        while (k >= 0) {
            int d = c;

            if (i >= 0) {
                d += a[i];
            }

            if(j >= 0) {
                d += b[j];
            }
            
            c = d/10;
            d = d%10;

            sum[k] = d;

            i--;
            j--;
            k--;
        }

        if(c != 0) {
            System.out.println(c);
        }
        
        // printArray(sum);
        return sum;
    }

    public static void differenceOfArray(int[] a, int[] b) {

        int diff[] = new int[b.length];

        int c = 0;
        int i = a.length - 1;
        int j = b.length - 1;
        int k = diff.length - 1;
         
        while (k >= 0) {
            int d = 0 ;
            int av = i >= 0 ? a[i] : 0;
            
            if (b[j] + c >= av) {
                d = b[j] + c - av;
                c=0;
            } else {
                d = b[j] + c + 10 - av;
                c = -1;
            }

            diff[k] = d;

            i--;
            j--;
            k--;
        }

        int index = 0;

        while (index < diff.length) {
            if (diff[index] == 0) {
                index++;
            } else {
                break;
            }
        }

        while (index < diff.length) {
            System.out.println(diff[index]);
            index++;
        }
    }

    public static void reverseArray(int[] arr) {
        int n = arr.length - 1;

        while (n >= 0) {
            System.out.println(arr[n]);
            n--;
        }
    }

    public static void rotateArray(int[] a, int k){
    
        int n = a.length;
         k = k % n;
    
        if (k < 0) 
            k = k + n;
    
        for (int i = n-k; i < n; i++){
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < n - k; i++ ){
            System.out.print(a[i] + " ");
        }
        
    }

    public static int[] inverseOfArray(int arr[]){
        int[] inv = new int[arr.length];

        for (int i = 0 ; i < arr.length; i++) {
            int v = arr[i];
            inv[v] = i;
        }

        return inv;
    }

    public static void subArray(int[] arr){
    
    
        int n=arr.length;
            for (int i=0; i <n; i++) //This loop will select start element
            {
                for (int j=i; j<n; j++)   //This loop will select end element
                {
                    for (int k=i; k<=j; k++) //This loop will print element from start to end
     
                    {
                        System.out.print( arr[k]+"\t"); 
                    }
                    System.out.println();
                }
            }
        
    }


    public static int findFloor(int [] a, int k) {
        int min = Integer.MIN_VALUE;
         
        for(int i: a) {
            if (i <= k) {
                min = Math.max(i,min);
            }
        } 
        
        return min;
     }
     
     public static int findCeil(int[] a,int k){
         
        int max = Integer.MAX_VALUE;
         
        for(int i: a) {
            if (i >= k) {
                max = Math.min(i,max);
            }
        } 
         return max;
    }

    public static void findFirstAndLAstIndex(int[] arr,int k){
        int firstIndex = -1;
        int lastIndex = -1;
        boolean isFirst = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                if (isFirst == true) {
                    firstIndex = i;
                    lastIndex = i;
                    isFirst = false;
                } else {
                    lastIndex = i;
                }

            }
        }

        System.out.println(firstIndex);
        System.out.println(lastIndex);
    }

    public static void subSetOfArray(int[] arr){
        int limit = (int)Math.pow(2,arr.length);

        for(int i = 0; i< limit; i++){
            int temp = i;
            String set = "";
            for (int j = arr.length-1; j >= 0; --j) {
                int r = temp%2;
                temp = temp/2;
                if (r == 0) {
                    set = "-" + "\t" +  set;
                } else {
                    set = arr[j]  + "\t" + set;
                }
            }

            System.out.println(set);
        }
    }

    public static void anyBaseToAnyBase(int num,int b, int d) {
        /**
         * We can change the base by 
         * First convert it into deicmal
         * then convert it into destination base
         */
        
        int val = 0;

        int noOfDig = calculateDigits(num);
         for(int i = 0; i < noOfDig; i++) {
             int dig = num%10;
             val += Math.pow(b, i) * dig;
             num = num/10;
        }

        getValueInBase(val, d);        

    }


    private static int calculateDigits(int n) {
        int count = 0;

        while(n >= 0){
            n /= 10;
            count++;
        }
        return count;
    }

    public static int kadaneAlgorith(int arr[]){
        /**
         * Max Contagious sub array roblem 
         */
        
        int n = arr.length;

        int globalMax = arr[0];
        int localMax = arr[0];

        for (int i  = 1; i < n; i++){
            if (localMax >= 0){
                localMax += arr[0];
            } else {
                localMax = arr[0];
            }

            if (localMax > globalMax) 
                globalMax = localMax;
            
        }
        return globalMax;
    }

    // 

    public int maxProfit(int[] arr) {
        int n = arr.length;
        
        if(n == 0) return 0;
        int buy = arr[0];
        int sell = arr[0];
        
        int profit = 0;
        
        for (int i = 1; i < n; i++){
            if (buy < arr[i] && sell < arr[i]) {
                sell = arr[i];
            } else if (buy > arr[i]) {
                buy = arr[i];
                sell = arr[i];
            }
                       
            profit = Math.max(sell - buy,profit);
        }
        
        return profit;
    }

    public static int findMaxSum(int arr[], int n){
        int inc = arr[0]; // including first elemnt at first
        int exc= 0; // excludiong first elemnt we get 0
        int exc_new = 0; // same logic 
        int i;
        for (i = 1; i < n; i++){
           
            exc_new = Math.max(inc,exc);
            inc = exc + arr[i];
            exc = exc_new;
        }

        return Math.max(exc,inc);
    } 

   

    /**
     * Most Important Question
     */
    int getMinDiff(int a[], int n, int k) {
        Arrays.sort(a); 
        
        int i,mx,mn,ans;
        ans = a[n-1]-a[0];  // this can be one possible solution
        
        int last = a[n-1] - k; // it has only option to decrease
        int first = a[0] + k; // it has only option to increase
        
        
        for(i = 1; i < n; i++){
            if(a[i]>=k)  // since height of tower can't be -ve so taking only +ve heights
            {
                mn = Math.min(first, a[i]-k); // taking min 
                mx = Math.max(last, a[i-1]+k); // taking max 
                ans = Math.min(ans, mx-mn); // get min ans 
            }
        }
        return ans;
    } 

    // https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&page=1&query=category[]Arrayscompany[]Amazonpage1company[]Amazoncategory[]Arrays
    public static void convertToWave(int a[], int n){
        if (n <2)
            return;
        // Your code here
        
        int p = a[1];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                p = a[i];
            else {
                a[i-1] = a[i];
                a[i] = p;
            }
        }
        
    }
}