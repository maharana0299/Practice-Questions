package Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKList {
    
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
        
        // make a pq of pair
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < lists.size(); i++) {
            
            if(lists.get(i).size()>0) {
                Integer ele = lists.get(i).get(0);
                Pair p = new Pair(i,0,ele);
                pq.add(p); // add smallest element of each list in the pq;
            }
        }
        
        while(!pq.isEmpty()){
            
            Pair p = pq.remove();
            rv.add(p.data);
            p.di++;
            if(p.di < lists.get(p.li).size()) {
                p.data = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return rv;
     }
  
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
           ArrayList<Integer> list = new ArrayList<>();
  
           int n = Integer.parseInt(br.readLine());
           String[] elements = br.readLine().split(" ");
           for(int j = 0; j < n; j++){
              list.add(Integer.parseInt(elements[j]));
           }
  
           lists.add(list);
        }
  
        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
           System.out.print(val + " ");
        }
        System.out.println();
     }
     
     /*
     li -> list index
     di -> data index in the list 
     data -> value container at di of li list 
     */
     static class Pair implements Comparable<Pair> {
         
         int li;
         int di;
         int data;
         
         Pair(int li, int di, int data){
             this.li = li;
             this.di = di;
             this.data = data;
         }
         
         public int compareTo(Pair o){
             return this.data - o.data;
         }
     }

     public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head = null;
        ListNode n = head;
        PriorityQueue<NodePair> queue = new PriorityQueue<>();

        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                NodePair np = new NodePair();
                np.node = lists[i];
                queue.offer(np);
            }
        }

        while(!queue.isEmpty()){

            NodePair rp = queue.poll();
            
            if(head == null) {
                ListNode ls = new ListNode();
                ls.val = rp.node.val;
                head = ls;
                n = head;
                ls.next = null;
            } else {
                ListNode ls = new ListNode();
                ls.val = rp.node.val;
                n.next = ls;
                n = n.next;
            }

            if(rp.node.next != null) {
                rp.node = rp.node.next;
                queue.offer(rp);
            }
        }
        return head;
    }

    class NodePair implements Comparable<NodePair> {
        ListNode node;
        @Override
        public int compareTo(NodePair o) {
            return this.node.val - o.node.val;
        }

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}