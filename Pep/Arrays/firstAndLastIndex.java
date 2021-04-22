/**
 * firstAndLastIndex
 */
public class firstAndLastIndex {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int ele = sc.nextInt();
        findIndexAndPrint(arr,ele);
        
    }
    
    public static void findIndexAndPrint(int arr[], int ele){
        int n = arr.length;
        int first = -1;
        int last = -1;
        boolean isFound = false;
        for(int i = 0; i < n; i++) {
            if(arr[i] == ele){
              if(!isFound){
                isFound = true;
                first = i;
                last = i;
              } else {
                last = i;
              }  
            } 
        }
        
        System.out.println(first);
        System.out.println(last);
    }

}