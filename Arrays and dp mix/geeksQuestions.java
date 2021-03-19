public class geeksQuestions {
    public static void main(String[] args) {
        
    }

    public int orangesRotting(int[][] v){
        // Code here
        
        int no = 2;
        boolean changed = false;
        
        int R = v.length;
        int C = v[0].length;
        
        while(true) {
            
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    
                    if (v[i][j] == no) {
                        
                        if (issafe(i+1,j,R,C) && v[i+1][j] == 1) {
                            v[i+1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        
                        if (issafe(i, j + 1, R, C) && 
                                     v[i][j + 1] == 1){
                                v[i][j + 1] = v[i][j] + 1;
                                changed = true;
                            }
                        if (issafe(i - 1, j, R, C) &&
                                 v[i - 1][j] == 1){
                            v[i - 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j - 1, R, C) && 
                                 v[i][j - 1] == 1){
                            v[i][j - 1] = v[i][j] + 1;
                            changed = true;
                        }
                    }
                }
            }
        
            if (!changed)
                break;
                
            changed = false;
            
            no++;
        }
        
        for(int i = 0; i < R; i++){
            
            for(int j = 0; j < C; j++){
                
                // If any orange is found to be
                // not rotten then ans is not possible
                if (v[i][j] == 1)
                    return -1;
            }
        }
     
        // Because initial value for a rotten
        // orange was 2
        return no - 2;
        
    }
    
    static boolean issafe(int i, int j,int R, int C){
        if (i >= 0 && i < R && 
            j >= 0 && j < C)
            return true;
            
        return false;
    }
}