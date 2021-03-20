package BinaryTree;

import java.util.Stack;

public class bt {
    
    public static void main(String[] args) {

        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        
        Node root = constructBT(arr);
        display(root);
        traversalPre(root);
        traversalPost(root);
        traversalIn(root);
    }

    private static void display(Node node) {
        
        if (node == null)
            return;
        String str = "";
        str += node.left  == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void traversalPre(Node node) {

        if (node == null)
            return;
        System.out.println(node.data);
        traversalPre(node.left);
        traversalPre(node.right);
    }

    public static void traversalIn(Node node) {

        if (node == null)
            return;
       
        traversalIn(node.left);
        System.out.print(node.data);
        traversalIn(node.right);
    }

    public static void traversalPost(Node node) {

        if (node == null)
            return;
       
        traversalPost(node.left); 
        traversalPost(node.right);
        System.out.println(node.data);
    }

    private static Node constructBT(Integer[] arr) {

        Node node = new Node(arr[0],null,null);
        Node root = node;
        int index = 0;
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
            }
            top.state++;
        }
        return root;
    }

    public static void iterativePrePostInTraversal(Node node) {
        Stack<Pair> mq = new Stack<>();
        mq.add(new Pair(node,1));
        String pre = "";
        String in = "";
        String post = "";
        
        while (mq.size()>0) {
            Pair top = mq.peek();
            
            if (top.state == 1) {
                pre += top.node.data + " ";
                if (top.node.left != null)
                mq.push(new Pair(top.node.left,1));
                top.state++;
            } else if (top.state == 2) {
                post += top.node.data + " ";
                if (top.node.right != null)
                mq.push(new Pair(top.node.right,1));
                top.state++;
            } else {
                in += top.node.data + " ";
                mq.pop();
            }
        }
        
        System.out.println(pre +  "\n" + post + "\n" + in);
      }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        // write your code here
        if (node == null) {
            return new ArrayList<Integer>();
        }
        if (node.data == data) {
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(node.data);
            return ar;
        }
        
        ArrayList<Integer> p1 = nodeToRootPath(node.left,data);
        ArrayList<Integer> p2 = nodeToRootPath(node.right,data);
        
        if (p1.size() > 0){
            p1.add(node.data);
            return p1;
        } else if (p2.size() > 0l) {
            p2.add(node.data);
            return p2;
        } else {
            return new ArrayList<Integer>();
        }
    }

    public static void levelOrder(Node node) {
    
        Queue<Node> mq = new ArrayDeque<>();
        
        mq.add(node);
        mq.add(new Node(-1,null,null));
        
        while (mq.size() > 0) {
            node = mq.remove();
            
            if (node.data == -1) {
                System.out.println();
                
                if (mq.size()>0)
                    mq.add(new Node(-1,null,null));
            } else {
                System.out.print(node.data + " ");
                
                if (node.left != null) 
                    mq.add(node.left);
                if (node.right != null) {
                    mq.add(node.right);
                }
            }
           
        }
    }

    public static void printKLevelsDown(Node node, int k){
        Queue<Node> mq = new ArrayDeque<>();
           
           mq.add(node);
           mq.add(new Node(-1,null,null));
           int ht = -1;
           while (mq.size() > 0) {
               node = mq.remove();
               
               if (ht > k) 
                   break;
               if (node.data == -1) {
                   // System.out.println();
                   ht++;
                   if (mq.size()>0)
                       mq.add(new Node(-1,null,null));
               } else {
                   // System.out.print(node.data + " ");
                   if (ht == k-1) {
                       System.out.println(node.data + " ");
                   }
                   if (node.left != null) 
                       mq.add(node.left);
                   if (node.right != null) {
                       mq.add(node.right);
                   }
               }
              
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