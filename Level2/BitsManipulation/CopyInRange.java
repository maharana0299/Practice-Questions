import java.util.*;

public class CopyInRange {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();

    // creating mask 
    // shifting the one to gap length away 
    int m = 1 << (right - left + 1);

    // to get all ones of size gap, subtracting by one 
    m = m - 1;

    // shifting by left to get ones in range of left - > right
    m = m << (left - 1);

    // taking and and copying bits in range
    m = a & m;

    // setting the set bits in a to b in range of left ->  rigth
    m = b | m;

    System.out.println(m);
  }

}
