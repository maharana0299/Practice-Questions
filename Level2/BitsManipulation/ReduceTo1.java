public class ReduceTo1 {

    public static int solution(int n) {

        int res = 0;

        while (n != 1) {

            if ((n & 1) == 0) {
                // if even
                n = (n >>> 1);
            } else if (n == 3) {
                n = n - 1;
            } else if ((n & 3) == 1) {
                n = n - 1;
            } else if ((n & 3) == 3) {
                n = n + 1;
            }

            res++;
        }
        return res;
    }
}
