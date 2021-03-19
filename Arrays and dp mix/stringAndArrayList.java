import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class stringAndArrayList {
    public static void main(String[] args) {
        
    }

    /**
     * Every single character is palindrome in itself
     * for others we have to check and print sub palindromic strings
     * @param s
     */
    public static void printAllPalendromicString(String s){
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; i < n; j++) {
                isPalindrome(s.substring(i,j + 1)); // j is taken coz from i to j 
            }
        }
    }

    private static void isPalindrome(String substring) {
        int n = substring.length();

        boolean isPalim = true;
        for (int i = 0; i < n/2; i++){
            if (substring.charAt(i) != substring.charAt(n - i - 1)) {
                isPalim = false;
                break;
            }
        }
        if (isPalim)
            System.out.println(substring);
    }

    public static void ceompressionString(String s){
        String c1 = compression1(s);
        String c2 = compression2(s);

        System.out.println(c1);
        System.out.println(c2);
    }

    private static String compression2(String s) {
        StringBuilder s1 = new StringBuilder();
        int count = 1;
        int i =1;
        s1.append(s.charAt(0));
        while(i < s.length()){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            if (curr == prev){
                count++;
            } else {
                if (count > 1) {
                    s1.append(count);
                    count = 1;
                }
                s1.append(curr);
            }
            i++;
        }

        if (count > 1){
            s1.append(count);
            count = 1;
        }

        return s1.toString();
    }

    public static String compression1(String s) {
        StringBuilder s1 = new StringBuilder();
        s1.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            if (curr != prev){
                s1.append(curr);
            }
        }

        return s1.toString();
    }

    public static String toggleCase(String str){
        
        StringBuilder s = new StringBuilder();

        for (int i = 0 ; i < str.length(); i++){
            char ch =  str.charAt(i);

            ch = Character.isUpperCase(ch)?  Character.toLowerCase(ch) :
            Character.toUpperCase(ch);
            s.append(ch);
        }

		return s.toString();
    }
    
    public static String diffOfEverConsecutiveString(String str){
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < str.length(); i++){
            char c1 = str.charAt(i);
            char c2 = str.charAt(i-1);
            s.append(c2);
            s.append((int)(c1-c2));
        }
        s.append(str.charAt(str.length()-1));
		return s.toString();
    }
    
    // Function to print all the permutations of str 
    public static void printPermutn(String str, String ans) 
    { 
  
        // If string is empty 
        if (str.length() == 0) { 
            System.out.print(ans + " "); 
            return; 
        } 
  
        for (int i = 0; i < str.length(); i++) { 
  
            // ith character of str 
            char ch = str.charAt(i); 
  
            // Rest of the string after excluding  
            // the ith character 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); 
  
            // Recurvise call 
            printPermutn(ros, ans + ch); 
        } 
    } 

    public static void premutation(String str){
        int n = str.length();
        int f = factorial(n);

        for (int i = 0; i < f; i++){
            StringBuilder sb = new StringBuilder(str);
            int temp = i;

            for (int div = n; div >= 1; div--){
                int q = temp/div;
                int r = temp % div;

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);

                temp = q;
            }
            System.out.println();
        }
    }
  
    private static int factorial(int n) {
        int fact = 1;

        for(int i = 1; i <= n; i++) 
            fact *= i;
        return fact;
    }

    public static void removePrimes(List<Integer> ls) {
        List<Integer> primes = new ArrayList<>();

        Iterator<Integer> i = ls.iterator();
    
        if (i.hasNext()){
            int ele = i.next();
            if (!isPrime_(ele))  {
                primes.add(ele);
            }
        }
        
        System.out.println(primes.toArray().toString());
    }

    public static boolean isPrime_(int n) {
        for (int i = 2; i*i <= n; i++)  {
            if (n % i == 0) {
                return false;
            }
        } 
        return true;
    }
    

    public static int minDiffInArraySelectingMnumbers(int[] arr,int n,int m){
        /*
        Given an array A of positive integers of size N, where each value represents number of chocolates in a packet.
        Each packet can have variable number of chocolates. There are M students, the task is to distribute chocolate packets such that :
        1. Each student gets one packet.
        2. The difference between the number of chocolates given to the students having packet with maximum chocolates and
        student having packet with minimum chocolates is minimum.
            
        https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0
        */
        // n is size and m is total students 
	    if (m == 0 || n == 0)
            return 0;
      
        // Sort the given packets
        Arrays.sort(arr);
      
        if (n < m)
           return -1;
      
        // Largest number of chocolates
        int min_diff = Integer.MAX_VALUE;
      
         
        for (int i = 0; i + m - 1 < n; i++)
        {
            int diff = arr[i+m-1] - arr[i];
            if (diff < min_diff)
                min_diff = diff;
        }
        return min_diff;
	   
	}
}

class GFG {
	public static void main (String[] args) {
		//code
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        
        while (testCase-- > 0){
            String str = sc.nextLine();
            System.out.println(findLongestPalindrome(str) );
        }
        sc.close();
	}

    private static String findLongestPalindrome(String str) {
        
        return str;
    }
}