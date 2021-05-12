

import java.util.Arrays;
import java.util.HashSet;

/**
 * GeneticMutation
 */
public class GeneticMutation {

    // this can be considered as the sub problem of word ladded as here we only have 4 options 
    // it is implemented using HashSet and BFs 
    public int minMutation(String beginWord, String endWord, String[] wordList) {
        
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        char[] ways= {'A','C','G','T'};
        
        if(wordSet.isEmpty()) 
            return -1;
        
            if(!wordSet.contains(endWord))
            return -1;
        
            int level = 0;
        HashSet<String> q = new HashSet<>();
        q.add(beginWord);
        
        while(!q.isEmpty()) {
            HashSet<String> temp = new HashSet<>();
            for(String word : q) {
        
                char[] wordArray = word.toCharArray();
                for(int i = 0; i < wordArray.length; i++) {
        
                    char org_char = wordArray[i];
                    for(char ch : ways) {
        
                        if(org_char == ch)
                            continue;
                        wordArray[i] = ch;
                        String newWord= String.valueOf(wordArray);
                        if(newWord.equals(endWord)) {
                            return level+1;
                        }
                        if(wordSet.contains(newWord)) {
                            temp.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    wordArray[i] = org_char;
                }
            }
            q = temp;
            level++;
        }
        return -1;
    }
}