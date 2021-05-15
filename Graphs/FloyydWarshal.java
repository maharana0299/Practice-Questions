package Graphs;

/**
 * FloyydWarshal
 */
public class FloyydWarshal {

    public static void main(String[] args) {
        
        int V = 4;

        int [][] graph = { 
                            { 0, 3, 1000, 7 }, 
                            { 8, 0, 2, 1000 }, 
                            { 5, 1000, 0, 1 }, 
                            { 2, 1000, 1000, 0 }
                        };

        int dist[][] = new int[V][V];

        for(int i = 0; i < dist.length; i++) {

            for(int j =0; j < dist[0].length; j++) {
                
                dist[i][j] = graph[i][j];
            }
        }

        System.out.println("Initial:");
        display(dist);

        for(int src = 0; src < V; src++) {
            
            for(int i =0; i < V; i++) {
                
                for(int j = 0; j < V; j++) {
                    
                    int oc = dist[i][j];
                    int nc = dist[i][src] + dist[src][j];

                    if(nc < oc) {
                        dist[i][j] = nc;
                    }
                }
            }

            // display(dist);
        }

        System.out.println("After:");
        display(dist);
    }

    private static void display(int[][] dist) {

        System.out.println("************************************");
        for(int i = 0; i < dist.length; i++) {
            
            for(int j = 0; j < dist[0].length; j++) {
                
                System.out.print(dist[i][j] + "\t");
            }
            
            System.out.println();
        }

        System.out.println("****************************************");
    }
}