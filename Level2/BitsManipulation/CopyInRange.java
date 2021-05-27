import java.util.*;

public class CopyInRange {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();

    int m = 1 << (right - left + 1);
    m = m - 1;
    m = m << (left - 1);

    m = a & m;

    m = b | m;

    System.out.println(m);
  }

}
