package RandomPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class mergeTwoBinaryTree{
    public static void main(String[] args) {
        
    }

        // Return a integer of integers having all the nodes in both the BSTs in a sorted order.
        public List<Integer> merge(Node root1,Node root2)
        {
            Stack<Node> s1,s2;
            s1 = new Stack<>();
            s2 = new Stack<>();
            ArrayList<Integer> ls = new ArrayList<>();
            Node c1 = root1;
            Node c2 = root2;
            
            while ( 
                !s1.isEmpty() || !s2.isEmpty()
                || c1 != null || c2 !=  null
                ) {
                
                if (c1 != null || c2 != null ) 
                { 
                    // Reach the leftmost node of both BSTs and push ancestors of 
                    // leftmost nodes to stack s1 and s2 respectively 
                    if (c1 != null) 
                    { 
                        
                        s1.push( c1); 
                        c1 = c1.left; 
                    }  
                    if (c2 != null) 
                    { 
                        s2.push( c2); 
                        c2 = c2.left; 
                    } 
        
                } else {
                    
                    if (s1.isEmpty()) 
                    { 
                        while (!s2.isEmpty()) 
                        { 
                            c2 = s2.pop (); 
                            c2.left = null; 
                            inorder(c2,ls); 
                        } 
                        return ls; 
                    } 
                    
                    if (s2.isEmpty() ) {
                        while (!s1.isEmpty()){
                            c1 = s1.pop();
                            c1.left = null;
                            inorder(c1,ls);
                        }
                        return ls;
                    }
                    
                    c1 = s1.pop();
                    c2 = s2.pop();
                    
                    if (c1.data < c2.data) {
                        ls.add(c1.data);
                        c1 = c1.right;
                        s2.push(c2);
                        c2 = null;
                    } else {
                        ls.add(c2.data);
                        c2 = c2.right;
                        s1.push(c1);
                        c1 = null;
                    }
                }
            }
            return ls;
        }
        
        static void inorder(Node root, ArrayList<Integer> ls) 
        { 
            if (root != null) 
            { 
                inorder(root.left,ls); 
                ls.add(root.data); 
                inorder(root.right,ls); 
            } 
        } 
        
    
}

class Node {
    int data;
    Node right;
    Node left;
    
}