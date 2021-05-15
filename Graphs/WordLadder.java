package Graphs;


import java.util.*;

/**
 * WordLadder
 */
public class WordLadder {

    public static void main(String[] args) {
        
    }
    // we are using different approaches
    class Solution1 {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
            // we will use bfs traversal 
            Set<String> set = new HashSet<>();
            
            for(String a : wordList){
                set.add(a);
            }
            
            if(!set.contains(endWord))
                return 0;
            
            int level = 1;
            
            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);
            
            while(! q.isEmpty()) {
            
                int size = q.size();
                
                for(int i = 0; i < size; i++) {
                    
                    String word = q.poll();
                    char[] wordArray = word.toCharArray();
                    
                    for(int j = 0; j < wordArray.length; j++) { 
                        
                        char org_char = wordArray[j];
                        
                        for(char c = 'a'; c <= 'z'; c++) {
                            
                            if(org_char == c)   continue;
                            
                            wordArray[j] = c;
                            
                            String new_word = String.valueOf(wordArray);
                            
                            if(new_word.equals(endWord))
                                return level+1;
                            
                            if(set.contains(new_word)){
            
                                q.offer(new_word);
                                set.remove(new_word);
                            }
                        }
                        
                        wordArray[j] = org_char;
                    }
                }
                
                level++;
            }
            
            return 0;
        }
    }

    class SolutionHashset {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            HashSet<String> wordSet = new HashSet<>(wordList);
            
            if(!wordSet.contains(endWord)) 
                return 0;

            int level = 1;
            HashSet<String> q = new HashSet<>();
            q.add(beginWord);

            while(!q.isEmpty()) {
                
                HashSet<String> temp = new HashSet<>();

                for(String word : q) {

                    char[] wordArray = word.toCharArray();

                    for(int i = 0; i < wordArray.length; i++) {
                        char org_char = wordArray[i];

                        for(char ch = 'a'; ch <= 'z'; ch++) {

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
            return 0;
        }
    }

    class SolutionBiDirectional {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
            Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
            qs.add(beginWord);
            if (dict.contains(endWord)) qe.add(endWord); // all transformed words must be in dict (including endWord)
            for (int len = 2; !qs.isEmpty(); len++) {
                Set<String> nq = new HashSet<>();
                for (String w : qs) {
                    for (int j = 0; j < w.length(); j++) {
                        char[] ch = w.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == w.charAt(j)) continue; // beginWord and endWord not the same, so bypass itself
                            ch[j] = c;
                            String nb = String.valueOf(ch);
                            if (qe.contains(nb)) return len; // meet from two ends
                            if (dict.contains(nb) && vis.add(nb)) nq.add(nb); // not meet yet, vis is safe to use
                        }
                    }
                }
                qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
                qe = (qs == nq) ? qe : nq;
            }
            return 0;
        }
    }
}