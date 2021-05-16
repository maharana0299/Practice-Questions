package Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class HMImplement {
    
    public static class HashMap<K, V> {
    
        private class HMNode {
          K key;
          V value;
    
          HMNode(K key, V value) {
            this.key = key;
            this.value = value;
          }
        }
    
        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length
        
        public HashMap() {
          initbuckets(4);
          size = 0;
        }
    
        private void initbuckets(int N) {
          buckets = new LinkedList[N];
          for (int bi = 0; bi < buckets.length; bi++) {
            buckets[bi] = new LinkedList<>();
          }
        }
    
        public void put(K key, V value) throws Exception {
          
            int bucketIndex = hashFunction(key);
            int dataIndex = getDataIndex(bucketIndex,key);

            if(dataIndex != -1) {

                HMNode node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            } else {
                
                HMNode node = new HMNode(key, value);
                buckets[bucketIndex].add(node);
                size++;
            }

            double lambda = size * 1.0 / buckets.length;
            
            if(lambda > 2.0 ) {
                rehash();
            }
        }
    
        private void rehash() throws Exception {
            LinkedList < HMNode > [] oldbuckets = buckets;
            initbuckets(2 * oldbuckets.length);
            size = 0;

            //travel each bucket
            for (int bi = 0; bi < oldbuckets.length; bi++) {
                //travel linked list in this bucket
                for (int i = 0; i < oldbuckets[bi].size(); i++) {
                    HMNode node = oldbuckets[bi].get(i);
                    put(node.key, node.value);
                }
            }

        }
        

        private int getDataIndex(int bucketIndex, K key) {
            
            int di = 0;
            for(HMNode node: buckets[bucketIndex]) {
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;
        }

        private int hashFunction(K key) {

            int hashcode = key.hashCode();
            return Math.abs(hashcode) % buckets.length;
        }

        public V get(K key) throws Exception {

            int bi = hashFunction(key);
            int dataIndex = getDataIndex(bi, key);

            if(dataIndex != -1) {
                return buckets[bi].get(dataIndex).value;
            } else {
                return null;
            }
        }
    
        public boolean containsKey(K key) {
          int bi = hashFunction(key);
          int di = getDataIndex(bi,key);

          if(di != -1)  return true;
          else return false;
        }
    
        public V remove(K key) throws Exception {

            int bi = hashFunction(key);
            int di = getDataIndex(bi, key);

            if(di != -1) {

                HMNode node = buckets[bi].get(di);
                buckets[bi].remove(di);
                size--;
                return node.value;
            } else {
                return null;
            }
        }
    
        public ArrayList<K> keyset() throws Exception {

            ArrayList<K> keySet = new ArrayList<>();
            for(LinkedList<HMNode> ls : buckets) {
                for(HMNode node : ls) {
                    keySet.add(node.key);
                }
            }

            return keySet;
        }
    
        public int size() {
          return size;
        }
    
       public void display() {
          System.out.println("Display Begins");
          for (int bi = 0; bi < buckets.length; bi++) {
            System.out.print("Bucket" + bi + " ");
            for (HMNode node : buckets[bi]) {
              System.out.print( node.key + "@" + node.value + " ");
            }
            System.out.println(".");
          }
          System.out.println("Display Ends");
      }
    }

      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<String, Integer> map = new HashMap<>();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("put")) {
            String[] parts = str.split(" ");
            String key = parts[1];
            Integer val = Integer.parseInt(parts[2]);
            map.put(key, val);
          } else if (str.startsWith("get")) {
            String[] parts = str.split(" ");
            String key = parts[1];
            System.out.println(map.get(key));
          } else if (str.startsWith("containsKey")) {
            String[] parts = str.split(" ");
            String key = parts[1];
            System.out.println(map.containsKey(key));
          } else if (str.startsWith("remove")) {
            String[] parts = str.split(" ");
            String key = parts[1];
            System.out.println(map.remove(key));
          } else if (str.startsWith("size")) {
            System.out.println(map.size());
          } else if (str.startsWith("keyset")) {
            System.out.println(map.keyset());
          } else if (str.startsWith("display")) {
            map.display();
          }
          str = br.readLine();
        }
      }
}
