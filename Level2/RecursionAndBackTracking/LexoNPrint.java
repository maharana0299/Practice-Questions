import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LexoNPrint {
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		for(int i = 1; i < 10; i++)
		    printLexo(i,n);
        scn.close();
	}
	
	public static void printLexo(int i, int n) {
	    
	    if(i > n)
	        return;
	    System.out.println(i);
	    for(int j = 0; j < 10; j++) {
	        printLexo(10*i + j, n);
	    }
	}
    
    public List<Integer> lexicalOrder(int n) {
        
        List<Integer> ls = new ArrayList<>();
        for(int i = 1; i < 10; i++) 
            lexo(i,n,ls);
        
        return ls;
    }
    
    // this is more optimized appraoch!!
    public boolean lexo(int i, int n, List<Integer> ls) {
        
        if(i > n)
            return false;;
        
        ls.add(i);
        for(int j = 0 ; j < 10; j++) {
            if(!lexo(10*i + j, n, ls))
                break;
        }
        
        return true;
    }
}
