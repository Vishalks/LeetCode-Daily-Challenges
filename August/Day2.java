//SC: O(1)
//TC: O(1)
class MyHashSet {
    
    int[] arr;

    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new int[1000001];
        for(int i = 0; i < 1000001; i++)
            arr[i] = -1;
    }
    
    public void add(int key) {
        if(arr[key] == -1)
            arr[key] = key;
    }
    
    public void remove(int key) {
        if(arr[key] != -1)
            arr[key] = -1;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(arr[key] != -1)
            return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */