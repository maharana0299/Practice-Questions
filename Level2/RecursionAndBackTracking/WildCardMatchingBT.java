public class WildCardMatchingBT {
    
    int[][] mem;
    public boolean isMatch(String s, String p) {
         
        int m = s.length(), n = p.length();
        char[] ws = s.toCharArray();
        char[] wp = p.toCharArray();
         
         mem = new int[ws.length+1][wp.length+1];
         
         return isValid(ws,wp,0,0);
    }
    
    public boolean isValid(char[] ws, char[] wp, int si, int pi) {
        
         if(mem[si][pi] != 0){
            if(mem[si][pi] == -1)
                return false;
            return true;
            
        }
        
        if(si == ws.length && pi == wp.length) {
            mem[si][pi] = 1;
            return true;
        }
        
        if(pi >= wp.length) {
            mem[si][pi] = -1;
            return false;
        }
        
        if(wp.length == 0){
            mem[si][pi] = -1;
            return false;
        }
        
        // char sc = ws[si];
        char pc = wp[pi];
         if(pc == '*') {
             
             if(si == ws.length)  {
                 
                if(isValid(ws,wp,si,pi+1)){
                    mem[si][pi] = 1;
                    return true;
                } else {
                    mem[si][pi] = -1;
                    return false;    
                }
             }
             
            boolean f = isValid(ws,wp,si+1,pi) || 
                isValid(ws,wp,si,pi+1) ;
             if(f){
                 mem[si][pi] = 1;
             } else {
                 mem[si][pi] = -1;
             }
             return f;
        } 
        
        if(si == ws.length){
            mem[si][pi] = -1;
            return false;
        }
        
        char sc = ws[si];
        if(pc == '?' || sc == pc) {
             
            boolean f = isValid(ws,wp,si+1,pi+1);
            if(f){
                 mem[si][pi] = 1;
             } else {
                 mem[si][pi] = -1;
             }
             return f;
        }
        
        mem[si][pi] = -1;
        return false;
    }
}
