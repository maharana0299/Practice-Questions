package Leetcode;

import java.util.*;
// 1st implementation

class RandomizedSet {

    HashMap<Integer, Integer> valToInd;
    List<Integer> list;
    int ind = 0;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valToInd = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToInd.containsKey(val)) return false;
        list.add(val);
        valToInd.put(val,list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int ind = valToInd.getOrDefault(val,-1);
        if(ind == -1) return false;
        Collections.swap(list,ind,list.size()-1);
        int swappedWith = list.get(ind);
        valToInd.put(swappedWith,ind);
        list.remove(list.size()-1);
        valToInd.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int max = list.size();
        int min = 0;
        int ind = (int)(Math.random() * (max - min) + min);
        return list.get(ind);
    }
}

// my approach but slow

class RandomizedSet2 {

    /** Initialize your data structure here. */
    HashSet<Integer> set;
    public RandomizedSet2() {
        set = new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        set.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        return getRandomElement(set);
    }
    
    private static <E>E getRandomElement(Set<? extends E> set) {
  
        Random random = new Random();
  
        // Generate a random number using nextInt
        // method of the Random class.
        int randomNumber = random.nextInt(set.size());
  
        Iterator<? extends E> iterator = set.iterator();
  
        int currentIndex = 0;
        E randomElement = null;
  
        // iterate the HashSet
        while (iterator.hasNext()) {
  
            randomElement = iterator.next();
  
            // if current index is equal to random number
            if (currentIndex == randomNumber)
                return randomElement;
  
            // increase the current index
            currentIndex++;
        }
  
        return randomElement;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

