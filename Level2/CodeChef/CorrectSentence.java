import java.util.Scanner;


public class CorrectSentence {
    
    // 1st land range = {a,m}
    // 2nd lang = {N,Z}
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-->0) {

            // total words
            int tw = sc.nextInt();
            String words[] = (sc.nextLine()).split(" ");
            if(isSentenceCorrect(words,tw)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isSentenceCorrect(String[] words, int tw) {
        char bl1[] = {'a','m'};
        char bl2[] = {'N','Z'};

        for(String word: words){

            if(word.length() == 0)
                continue;
            char ch = word.charAt(0);

            if(ch >= bl1[0] && ch <= bl1[1]){

                for(int i = 1; i < word.length(); i++) {
                    if(word.charAt(i) < bl1[0] || word.charAt(i) > bl1[1])
                        return false;
                }
            } else if(ch >= bl2[0] && ch <= bl2[1]){

                for(int i = 1; i < word.length(); i++) {
                    if(word.charAt(i) < bl2[0] || word.charAt(i) > bl2[1])
                        return false;
                }
            } else {
                return false;
            }
        }
        
        return true;
    }
}
