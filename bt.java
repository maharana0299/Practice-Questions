import java.util.Stack;

public class bt {
    
    public static void main(String[] args) {

        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        int index = 0;
        Node node = new Node(arr[0],null,null);
        Stack<Pair> st = new Stack<>();
        st.push(
            new Pair(node,1)
        );

        while (st.size() > 0){
            Pair top = st.peek();

            if (top.state == 1) {
                index++;

                if (arr[index]!= null) {
                    top.node.left = new Node(arr[index],null,null);
                    st.push(new Pair(top.node.left,1));
                } else {
                    top.node.left = null;
                }
            } else if (top.state == 2) {
                index++;
                if (arr[index]!=null){
                    top.node.right = new Node(arr[index],null,null);
                    st.push(new Pair(top.node.right,1));
                } else{
                    top.node.right = null;
                }
            } else {
                Pair p = st.pop();
                System.out.println(p.node.data);
            }
            top.state++;
        }
    }
}

class Pair {
    Node node; 
    int state;

    Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }
}
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right ){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }