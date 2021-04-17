/**
 * UniquePath
 * On a 2-dimensional grid, there are 4 types of squares:
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 */
public class UniquePath {

    public int uniquePathsIII(int[][] g) {
        int x = 0, y = 0, empty = 0;
        for(int i=0; i < g.length; i++)
            for(int j=0; j < g[0].length; j++)
                if(g[i][j] == 0)
                    ++empty;
                else if(g[i][j] == 1){
                    x = i;
                    y = j;
                }

        return dfs(g, x, y, -1, empty);
    }
    private int dfs(int[][] g, int i, int j, int count, int need){
        if(i < 0 || i == g.length || j < 0 || j == g[0].length || g[i][j] == -1) return 0;
        if(g[i][j] == 2){
            if(count == need)
                return 1;
            else
                return 0;
        }
        g[i][j] = -1;
        int total = dfs(g, i-1, j, count+1, need);
        total += dfs(g, i, j+1, count+1, need);
        total += dfs(g, i+1, j, count+1, need);
        total += dfs(g, i, j-1, count+1, need);
        g[i][j] = 0;
        return total;
    }
}