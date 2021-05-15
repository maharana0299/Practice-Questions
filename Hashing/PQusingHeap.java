package Hashing;

import java.io.*;
import java.util.*;

public class PQusingHeap {

    public static class PriorityQueue {
        ArrayList<Integer> data;
    
        public PriorityQueue() {
          data = new ArrayList<>();
        }
    
        public void add(int val) {
          data.add(val);
          upHeahpify(data.size()-1);
        }
    
        private void upHeahpify(int i) {
    
            int parentIndex = (i-1)/2;
    
            if(data.get(parentIndex) > data.get(i)) {
                swap(i,parentIndex);
                upHeahpify(parentIndex);
            }
    
        }
    
        private void swap(int i, int j) {
            
            int ith = this.data.get(i);
            int jth = this.data.get(j);
            this.data.set(i, jth);
            this.data.set(j, ith);
        }
    
        public int remove() {
          if(this.size() == 0){
              System.out.println("Underflow");
              return -1;
          } 
          
          swap(0, this.size()-1);
          int val = data.remove(size()-1);
          downheapify(0);
          return val;
        }
    
        private void downheapify(int pi) {
    
            int mini = pi;
            int li = 2*pi + 1;
    
            if(li < data.size() && data.get(li) < data.get(mini)) {
                mini = li;
            }
    
            int ri = 2 * pi + 2;
    
            if(ri < data.size() && data.get(ri)< data.get(mini)) {
                mini = ri;
            }
    
            if(pi != mini) {
                swap(pi,mini);
                downheapify(mini);
            }
        }
    
        public int peek() {
          if(this.size() == 0) {
              System.out.println("Underflow");
              return -1;
          }
    
          return this.data.get(0);
        }
    
        public int size() {
          return data.size();
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("add")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            qu.add(val);
          } else if (str.startsWith("remove")) {
            int val = qu.remove();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("peek")) {
            int val = qu.peek();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("size")) {
            System.out.println(qu.size());
          }
          str = br.readLine();
        }
    }
}
