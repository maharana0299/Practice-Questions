package Mix.GeeksQuestion;

public class reverseArray {
    public static void main(String[] args) {
        int array[]= {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println("Hello");
        reverse(array);
        // printArray(array);
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void reverse(int[] array) {
        /**
         * we will reverse the array using its index ... like index 0 will be replaced by index i-1 
         */
        int i =  0;
        int length = array.length;
        while (i < length/2) {
            swap(array,i,length-i-1);
            i++;
        }
        printArray(array);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}