
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class GenericTree{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);

        GenericTreeIt iterable = new GenericTreeIt(root);

        Iterator<Integer> it = iterable.iterator();

        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }

    public static class GenericTreeIt implements Iterable<Integer>{
        private Node root;

        GenericTreeIt(Node root) {
            this.root  = root;
        }

        @Override
        public Iterator<Integer> iterator() {
            Iterator<Integer> it = new GenericTreeIterator(root);
            return it;
        }

    }

    public static class GenericTreeIterator implements Iterator<Integer> {
        Integer nextVl;

        Stack<Pair> st;

        GenericTreeIterator(Node root) {
            st = new Stack<>();
            st.push(new Pair(root,-1));
            next();
        }

        @Override
        public boolean hasNext() {
            if (nextVl != null ){
                return true;
            }
            return false;
        }

        @Override
        public Integer next() {
            Integer val = nextVl;
            nextVl = null;

            while(st.size() > 0) {
                Pair top = st.peek();

                if (top.state == -1) {
                    top.state ++;
                    nextVl = top.node.data;
                    break;
                } else if (top.state == top.node.children.size()) {
                    st.pop();
                } else {
                    Pair p = new Pair(
                        top.node.children.get(top.state),-1
                    );
                    st.push(p);
                    top.state++;
                }
            }
            return val;
        }
    }
    
    public static Node construct(int[] arr) {
        Node root = null;
    
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == -1) {
            st.pop();
          } else {
            Node t = new Node();
            t.data = arr[i];
    
            if (st.size() > 0) {
              st.peek().children.add(t);
            } else {
              root = t;
            }
    
            st.push(t);
          }
        }
    
        return root;
    }

    public void displayGenericTree(Node node){
        String str = node.data + "-->" ;
        for (Node child : node.children) {
            str += child.data + ", ";
        }

        str += ".";
        System.out.println(str);
        for (Node child : node.children) {
            displayGenericTree(child);
        }
    }

    /**
     * This method is more efficicent
     */
    public Node linearize2(Node node) {

        if (node.children.size() == 0)
            return node;
        
        Node lkt = linearize2(node.children.get(
            node.children.size() - 1
        ));

        while (node.children.size() > 1) {
            Node last = node.children.remove(
                node.children.size()-1
            );

            Node sl = node.children.get(
                node.children.size()-1
            );

            Node sklt = linearize2(sl);
            
            sklt.children.add(last);
        }
        return lkt;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    
        if (node.data == data) {
            ArrayList<Integer> ls = new ArrayList<>();
            ls.add(data);
            return ls;
        } 
        
        for (Node child : node.children){
            ArrayList<Integer> ls =  nodeToRootPath(child,data);
            if (ls.size() > 0) {
                ls.add(node.data);
                return ls;
            }
        }
        
        return new ArrayList<>();
        
     }

    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> pt1 = nodeToRootPath(node,d1);
        ArrayList<Integer> pt2 = nodeToRootPath(node,d2);
        
        int i = pt1.size()-1;
        int j = pt2.size()-1;
        
        // System.out.println(pt1);
        // System.out.println(pt2);
        while (i >= 0 && j >= 0) {
            if (pt1.get(i) != pt2.get(j) ) {
                return pt1.get(i+1);
            }
            i--;
            j--;
        }
        
        return pt1.get(i+1);
    }

    public static boolean areSimilar(Node n1, Node n2) {
    
    if (
        n1.children.size() != n2.children.size()
        ) {
        return false;
    }
    
    for (int i = 0; i < n1.children.size(); i++) {
        boolean isSimilar = areSimilar(n1.children.get(i), n2.children.get(i) );
        
        if (!isSimilar)
            return isSimilar;
    }
    
    return true;
  }

    public static boolean areMirror(Node n1, Node n2) {
    if (
        n1.children.size() != n2.children.size()
        ) 
        return false;
    
    int s1 = n1.children.size() - 1;
    
    for (int i = 0; i < n1.children.size(); i++) {
        boolean isMirror =
        areMirror(n1.children.get(i), n2.children.get(s1 - i) );
        
        if (!isMirror)
            return isMirror;
    }
    
    return true;
  }

    static Node predecessor;
    static Node successor;
    static boolean isFoundSu = false;
    static boolean isFound = false;

    public static void predecessorAndSuccessor(Node node, int data) {
    
    if (node.data == data){
        isFound = true;
    } else if (isFound && !isFoundSu) {
        successor = node;
        isFoundSu = true;
    } else if (!isFound) {
        predecessor = node;
    }
    
    for (Node child : node.children) {
        predecessorAndSuccessor(child,data);
    }
    
    
  }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreandPostOrder(Node node) {
            Stack<Pair> st = new Stack<>();
            st.add(new Pair(node,-1));
            StringBuilder pre = new StringBuilder("");
            StringBuilder post = new StringBuilder("");
            while (st.size()>0){
            Pair top = st.peek();
            
            if (top.state == -1) {
                pre.append(top.node.data + " ");
                top.state++;
            } else if (top.state == top.node.children.size()){
                post.append(top.node.data + " ");
                st.pop();
            } else {
                Pair p = new Pair(top.node.children.get(top.state),-1);
                st.push(p);
                top.state++;
            }
            }
            
            System.out.println(pre.toString());
            System.out.println(post.toString());
        }
    }

class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();

    Node(){

    }
}