package Mix.GeeksQuestion;

public class MaxAndMin {
    public static void main(String[] args) {
        
    }

    public int middle(int a, int b, int c) {
        // let a be the middle element
        int middle = a;
        if ((b > a && b < c) || (b > c && b < a)) middle = b;
        else if ((c > a && c < b)||(c > b) || c < a) middle = c;
        return middle;
    }

    public static void findKthMAxAndMin(int[] arrray){
        /**
         * We have to find kth max and kth minimum in an array 
         * We have to sort 
         */
    } 
}