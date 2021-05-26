import java.util.*;

public class NumberOfValidWords {

	public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
	    
	    // create hashmap
	    HashMap<Character, Set<Integer>> map = new HashMap<>();
	    
	    for(char ch = 'a'; ch <= 'z'; ch++){
	        map.put(ch,new HashSet<>());
	    }
	    
	    // for every word create mask and then add to the hashmap
	    
	    for(String word: words) {
	        
	        int mask = 0;
	        for(char ch : word.toCharArray()){
	            // create mask 
	            mask |=  1<<(ch-'a'); // switching on at ith bit 
	        }
	        
	        for(char ch : word.toCharArray()){
	            map.get(ch).add(mask); // by using hashset we ensured that htere is no duplicacy 
	        }
	    }
	    
	    ArrayList<Integer> countT = new ArrayList<>();
	    
	    for(String puzzle : puzzles) {
	        
	        int pmask = 0;
	        
	        // ccreating mask for each puzzle
	        for(char ch : puzzle.toCharArray()){
	            int bit = ch - 'a';
	            pmask |= 1<<bit;
	        }
	        
	        
	        char fch = puzzle.charAt(0);
	        // getting that hashset for first chAR
	        Set<Integer> wordSet = map.get(fch);
	        int count = 0;
	        for(Integer w : wordSet) {
	            if( (w & pmask) == w )
	                count++;
	        }
	        
	        countT.add(count);
	    }
		
		return countT;
	 }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int m = scn.nextInt();
		String[] puzzles = new String[m];
		for(int i = 0 ; i < m ;i++) {
			puzzles[i] = scn.next();
		}
		ArrayList<Integer> ans = findNumOfValidWords(words,puzzles);
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(puzzles[i] + " -> " + ans.get(i));
		}
	}
	
}