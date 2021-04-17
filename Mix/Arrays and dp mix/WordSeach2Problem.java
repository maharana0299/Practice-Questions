
import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 */

public class WordSeach2Problem {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> ls = new ArrayList<>();
        
        for(String word : words){
            if(exist(board,word)){
                ls.add(word);
            }
        }
        return ls;
    }
    
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) || 
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) || 
           search(board, word, i, j+1, index+1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}

// Lets Solve using Trie

/**
 * SolveUsingTrie
 */
class SolveUsingTrie {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> pw = new ArrayList<>();
        
        TrieNode root = buildTrie(words);
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                isExist(board,i,j,root,pw);
            }
        }
        return pw;
    }
    
    public static void isExist(char[][] board, int i, int j, TrieNode node, List<String> res){
        char c = board[i][j];
        
        if(c == '#' || node.next[c-'a'] == null)
                return;
        node = node.next[c-'a'];
        if(node.word != null){
            res.add(node.word);
            node.word = null;
        }
        
        board[i][j] = '#';
        
        if(i > 0) isExist(board,i-1,j,node,res);
        if(j>0) isExist(board,i,j-1,node,res);
        if(i < board.length-1) isExist(board,i+1,j,node,res);
        if(j < board[0].length-1) isExist(board,i,j+1,node,res);
        
        board[i][j] = c; // mark then unvisited at the end
            
    }
    
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        
        for(String word : words){
            TrieNode t = root;
            
            for(char ch : word.toCharArray()){
                int n = ch - 'a';
                if(t.next[n] == null) {
                    t.next[n] = new TrieNode();
                }
                t = t.next[n];
            }
            t.word = word;
        }
        
        return root;
    }
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}