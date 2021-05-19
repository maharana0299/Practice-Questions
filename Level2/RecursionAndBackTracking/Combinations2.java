import java.io.*;

public class Combinations2 {

  public static void combinations(int[] boxes, int ci, int ti, int lb){
      
      if(ci > ti) {
          
          for(int i : boxes) {
              
              if(i == 1) {
                  System.out.print("i");
              } else {
                  System.out.print("-");
              }
          }
          
          System.out.println();
          
          return;
      }
      
      for(int i = lb; i < boxes.length; i++) {
          
          if(boxes[i] == 0) {
              
              boxes[i] = 1;
              combinations(boxes,ci+1,ti,i+1);
              boxes[i] = 0;
          }
      }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, 0);
  }

}
