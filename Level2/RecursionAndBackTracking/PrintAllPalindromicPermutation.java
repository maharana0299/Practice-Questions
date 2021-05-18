import java.util.*;

public class PrintAllPalindromicPermutation {

	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
		
		
		if(cs > ts) {
		    
		    String rev = "";
		    
		    for(int j = asf.length()-1; j >= 0; j--) {
		        rev += asf.charAt(j);
		    }
		    
		    if(oddc != null) {
		        asf += oddc;
		    }
		    
		    System.out.println(asf+rev);
		    return;
		}
		// for every char in keyset
		for(Character ch : fmap.keySet()) {
		    
		    int freq = fmap.get(ch);
		    
		    if(freq > 0) {
		        fmap.put(ch,freq-1);
		        generatepw(cs+1,ts,fmap,oddc,asf+ch);
		        fmap.put(ch,freq);
		    }
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		
		// make freq half and search for odds
		
		Character oddc = null;
		int of = 0;
		int length = 0;
		for(Character ch : fmap.keySet()) {
		    
		    int fr = fmap.get(ch);
		    
		    if(fr % 2 == 1) {
		        // if contains odd 
		        oddc = ch;
		        of++;
		    }
		    
		    // half the freq 
		    
		    fmap.put(ch,fr/2);
		    length += fr/2;
		}
		
		if(of > 1) {
		    System.out.println("-1");
		} else {
		    generatepw(1,length,fmap,oddc,"");
		}

        scn.close();
		
	}
	
}