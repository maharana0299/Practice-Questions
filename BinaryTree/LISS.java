package BinaryTree;

/**
 * LISS
 */
public class LISS {

    public int LISS(Node node){
    
        if(node == null)
            return 0;
        int inc = 1;
        int xcl;
        
        
        xcl = LISS(node.right) + LISS(node.left);
        
        
        if(node.left != null){
            inc += LISS(node.left.left) + LISS(node.left.right);
        }
        
        if(node.right != null){
            inc += LISS(node.right.left) + LISS(node.right.right);
        }   
        
        return Math.max(inc,xcl);
    }

    public class Node{
        Node right;
        Node left;
        int data;

        Node(){}
    }
}