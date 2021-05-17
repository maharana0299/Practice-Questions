import java.util.Scanner;

public class CrossWordPuzzle {
    
    public static void solution(char[][] arr, String[] words, int vidx){
	    
	    if(vidx == words.length) {
	        print(arr);
	        return;
	    }
	    
	    String word = words[vidx];
	    
	    // explore every position 
	    for(int i = 0; i < arr.length; i++) {
	        for(int j = 0; j < arr[0].length; j++) {
	            
	            if(canPlaceWordHorizontally(arr,word,i,j)) {
	                
	                boolean[] itemPlaced = placeWordHorizontally(arr,word,i,j);
	                solution(arr,words,vidx+1);
	                unplaceWordHorizontallty(arr,itemPlaced,i,j);
	            }
	            
	            if(canPlaceWordVertically(arr,word,i,j)){
	                
	                boolean[] itemPlaced = placeWordVertically(arr,word,i,j);
	                solution(arr,words,vidx+1);
	                unplaceWordVertically(arr,itemPlaced,i,j);
	            }
	        }
	    }
	}
	
	public static boolean canPlaceWordHorizontally(char[][] arr, String word, int i, int j) {
	    
	    // in which caxe we cant place the word
	    // if it is in the box and element before first letter is not + then return false
	    if(j-1 >= 0 && arr[i][j-1] != '+')
	        return false;
	   
        // if it is in the box and element after last letter is not + then return false
        if(j + word.length() < arr[0].length && arr[i][j + word.length()] != '+')
           return false;
        
        for(int jj = 0; jj < word.length(); jj++) {
            
            // check if it is out of box or not 
            if(j + jj >= arr[0].length)
                return false;
                
            if(arr[i][j+jj] == '-' || arr[i][j+jj] == word.charAt(jj) )
                continue;
            else return false;
        }
        
        return true;
	}

    public static boolean canPlaceWordVertically(char[][] arr, String word, int i, int j) {
        
        if(i-1 >= 0 && arr[i-1][j] != '+')
            return false;
        
        if(i + word.length() < arr.length && arr[i + word.length()][j] != '+' ){
            return false;
        }
        
        for(int ii = 0; ii < word.length(); ii++) {
            
            if(ii + i >= arr.length)
                return false;
            if(arr[i+ii][j] == '-' || arr[i+ii][j] == word.charAt(ii)) {
                continue;
            } else return false;
        }
        return true;
	}

    public static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j) {
        
        boolean[] wePlaced = new boolean[word.length()];
        int n = word.length();
        
        for(int jj = 0; jj < n; jj++) {
            if(arr[i][j+jj] == '-'){
                wePlaced[jj] = true;
                arr[i][j+jj] = word.charAt(jj);
            }   
        }
        
        return wePlaced;
    }
    
    public static boolean[] placeWordVertically(char[][] arr, String word, int i, int j) {
        
        boolean[] wePlaced = new boolean[word.length()];
        int n = word.length();
        
        for(int ii = 0; ii < n; ii++) {
            if(arr[i+ii][j] == '-'){
                wePlaced[ii] = true;
                arr[i+ii][j] = word.charAt(ii);
            }   
        }
        
        return wePlaced;
    }
    
    public static void unplaceWordHorizontallty(char[][] arr, boolean[] itemPlaced, int i, int j) {
        
        for(int jj = 0; jj < itemPlaced.length; jj++) {
            if(itemPlaced[jj]) {
                arr[i][j + jj] = '-'; // unplcaing the item
            }
        }
    }
    
    public static void unplaceWordVertically(char[][] arr, boolean[] itemPlaced, int i, int j) {
        
        for(int ii = 0; ii < itemPlaced.length; ii++) {
            if(itemPlaced[ii]) {
                arr[i + ii][j] = '-'; // unplcaing the item
            }
        }
    }
    	
	public static void print(char[][] arr){
        
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}
		scn.close();
		solution(arr,words,0);

	}
}
