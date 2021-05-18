
import java.util.*;

public class LargestNumberKSwap {

	static String max;
	public static void findMaximum(String str, int k) {
		
		if(Integer.parseInt(str) > Integer.parseInt(max)) {
		    max = str;
		} 
		
		if(k == 0) {
		    return;
		}
		
		for(int i = 0; i < str.length(); i++) {
		    for(int j = i+1; j < str.length(); j++) {
		        
		        if(str.charAt(j) > str.charAt(i)) {
		            
		            String sw = swap(str,i,j);
		            findMaximum(sw,k-1);
		        }
		    }
		}
		
	}
	
	public static String swap(String s, int i, int j) {
	    
	    char ith = s.charAt(i);
	    char jth = s.charAt(j);
	    
	    return s.substring(0,i) + jth + s.substring(i+1,j) + ith + s.substring(j+1);
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
        scn.close();
	}

}