package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class bt {

    public static void main(String[] args) {

        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };

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
        str += node.left == null ? "." : node.left.data + "";
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

        Node node = new Node(arr[0], null, null);
        Node root = node;
        int index = 0;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 1));

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 1) {
                index++;

                if (arr[index] != null) {
                    top.node.left = new Node(arr[index], null, null);
                    st.push(new Pair(top.node.left, 1));
                } else {
                    top.node.left = null;
                }
            } else if (top.state == 2) {
                index++;
                if (arr[index] != null) {
                    top.node.right = new Node(arr[index], null, null);
                    st.push(new Pair(top.node.right, 1));
                } else {
                    top.node.right = null;
                }
            } else {
                st.pop();
            }
            top.state++;
        }
        return root;
    }

    public static void iterativePrePostInTraversal(Node node) {
        Stack<Pair> mq = new Stack<>();
        mq.add(new Pair(node, 1));
        String pre = "";
        String in = "";
        String post = "";

        while (mq.size() > 0) {
            Pair top = mq.peek();

            if (top.state == 1) {
                pre += top.node.data + " ";
                if (top.node.left != null)
                    mq.push(new Pair(top.node.left, 1));
                top.state++;
            } else if (top.state == 2) {
                post += top.node.data + " ";
                if (top.node.right != null)
                    mq.push(new Pair(top.node.right, 1));
                top.state++;
            } else {
                in += top.node.data + " ";
                mq.pop();
            }
        }

        System.out.println(pre + "\n" + post + "\n" + in);
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        // write your code here
        if (node == null) {
            return new ArrayList<Integer>();
        }
        if (node.data == data) {
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(node.data);
            return ar;
        }

        ArrayList<Integer> p1 = nodeToRootPath(node.left, data);
        ArrayList<Integer> p2 = nodeToRootPath(node.right, data);

        if (p1.size() > 0) {
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
        mq.add(new Node(-1, null, null));

        while (mq.size() > 0) {
            node = mq.remove();

            if (node.data == -1) {
                System.out.println();

                if (mq.size() > 0)
                    mq.add(new Node(-1, null, null));
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

    public static void printKLevelsDown(Node node, int k) {
        Queue<Node> mq = new ArrayDeque<>();

        mq.add(node);
        mq.add(new Node(-1, null, null));
        int ht = -1;
        while (mq.size() > 0) {
            node = mq.remove();

            if (ht > k)
                break;
            if (node.data == -1) {
                // System.out.println();
                ht++;
                if (mq.size() > 0)
                    mq.add(new Node(-1, null, null));
            } else {
                // System.out.print(node.data + " ");
                if (ht == k - 1) {
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

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {

        if (node == null) {
            return;
        }

        sum += node.data;
        path += node.data + " ";
        pathToLeafFromRoot(node.left, path, sum, lo, hi);
        pathToLeafFromRoot(node.right, path, sum, lo, hi);

        if (sum > lo && sum < hi && node.right == null && node.left == null) {
            System.out.println(path);
            return;
        }
    }

    /**
     * Ver importent questions
     * 
     * @param node
     * @return
     */
    public static Node createLeftCloneTree(Node node) {

        if (node == null)
            return null;

        createLeftCloneTree(node.left);
        createLeftCloneTree(node.right);

        Node t = node.left;

        node.left = new Node(node.data, null, null);
        node.left.left = t;

        return node;
    }

    public static void printSingleChildNodes(Node node, Node parent) {

        if (node == null)
            return;

        if (parent != null && (parent.right == null || parent.left == null)) {
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    
    public static Node transBackFromLeftClonedTree(Node node) {
        if (node == null) {
            return null;
        }
        Node t = node.left.left;
        node.left = t;
        transBackFromLeftClonedTree(node.left);
        transBackFromLeftClonedTree(node.right);
        return node;
    }

    public static DiaPair diameter2(Node node) {

        if (node == null) {
            // System.out.println("null");
            return new DiaPair(-1, 0);
        }

        DiaPair d1 = diameter2(node.left);
        DiaPair d2 = diameter2(node.right);

        int f = d1.height + d2.height + 2;

        DiaPair mp = new DiaPair();
        mp.height = Math.max(d1.height, d2.height) + 1;
        mp.dia = Math.max(f, Math.max(d1.dia, d2.dia));

        return mp;
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

class BST {
    public static Node removeLeaves(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }

    static int tilt = 0;
  public static int tilt(Node node){
    
    if (node == null)
        return 0;
    int s1 = tilt(node.left);
    int s2 = tilt(node.right);
    
    tilt += Math.abs(s1-s2);
    
    return s1+s2+node.data;
  }

  public static BPair isBST(Node node){
      
    if (node == null) {
        BPair p = new BPair();
        p.isBST = true;
        p.min = Integer.MAX_VALUE;
        p.max = Integer.MIN_VALUE;
        return p;
    }
    BPair b1 = isBST(node.left);
    BPair b2 = isBST(node.right);
    
    BPair mp = new BPair();
    
    mp.isBST = b1.isBST && b2.isBST 
                && (node.data >= b1.max) 
                && (node.data <= b2.min) ;
                
    mp.min = Math.min(node.data, Math.min(b1.min,b2.min));
    mp.max = Math.max(node.data, Math.max(b1.max,b2.max));
    
    return mp;
  }

  public static BPair findLargestBSTBPair(Node node){
      
    if (node == null) {
        BPair p = new BPair();
        p.isBST = true;
        p.min = Integer.MAX_VALUE;
        p.max = Integer.MIN_VALUE;
        return p;
    }
    BPair b1 = findLargestBSTBPair(node.left);
    BPair b2 = findLargestBSTBPair(node.right);
    
    BPair mp = new BPair();
    
    mp.isBST = b1.isBST && b2.isBST 
                && (node.data >= b1.max) 
                && (node.data <= b2.min) ;
                
    mp.min = Math.min(node.data, Math.min(b1.min,b2.min));
    mp.max = Math.max(node.data, Math.max(b1.max,b2.max));
    
    if (mp.isBST){
        mp.maxNode = node;
        mp.maxBSTSize = b1.maxBSTSize + b2.maxBSTSize  +1; 
    } else if (b1.maxBSTSize > b2.maxBSTSize) {
        mp.maxNode = b1.maxNode;
        mp.maxBSTSize = b1.maxBSTSize;
    } else {
        mp.maxNode = b2.maxNode;
        mp.maxBSTSize = b2.maxBSTSize;
    }
    return mp;
  }

  public Node modifyForGreatestSumRoot(Node node)
    {
        Node root = node;
        Pair rtp = new Pair(root, 2);
    
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int sum = 0;
        while (st.size() > 0) {
          Pair top = st.peek();
          if (top.state == 0) {
            st.pop();
           if (top.node.left != null) {
               Pair p = new Pair(top.node.left,2);
               st.push(p);
           }
            
          } else if (top.state == 2) {
             
              if (top.node.right != null) {
                Pair p = new Pair(top.node.right,2);
                st.push(p);
              } 
              top.state--;
          } else if (top.state == 1) {
            
            sum += top.node.data;
            top.node.data = sum;
            
            top.state--;
          }
        }
        
        return root;
    }

    public static void pir(Node node, int d1, int d2) {
    
        if (node == null){
            return;
        }
        if (d1 <= node.data && d2 >= node.data){
            
            pir(node.left,d1,d2);
            System.out.println(node.data);
            pir(node.right,d1,d2);
        } else if (d1 > node.data ) {
            pir(node.right,d1,d2);
        } else {
            pir(node.left,d1,d2);
        }
      }

}

class DiaPair {
    int height;
    int dia;

    DiaPair(){}

    DiaPair(int ht, int dia){
        this.height = ht;
        this.dia = dia;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BPair{
    boolean isBST;
    int max;
    int min;

    //only for bst max question
    Node maxNode;
    int maxBSTSize;
}


class GeeksForGeeksPrintNodesWithoutSibling {
    ArrayList<Integer> noSibling(Node node) {

        Stack<Node> st = new Stack<>();
        st.add(node);
        ArrayList<Integer> ls = new ArrayList<>();
        while (st.size() > 0) {

            node = st.pop();
            // System.out.println(node.data);
            if (node.right != null) {
                st.add(node.right);
                if (node.left == null) {
                    ls.add(node.right.data);
                }
            }
            if (node.left != null) {
                st.add(node.left);
                if (node.right == null) {
                    ls.add(node.left.data);
                }
            }

        }

        if (ls.size() == 0)
            ls.add(-1);

        Collections.sort(ls);
        return ls;
    }
}