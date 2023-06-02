class MyHashSet {

    List<Integer> ls;
    public MyHashSet() {
        ls = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!ls.contains(key)){
            ls.add(key);
        }
    }
    
    public void remove(int key) {
        for(int i = 0 ; i<ls.size();i++){
            if(ls.get(i) == key){
                ls.remove(i);
            }
        }
    }
    
    public boolean contains(int key) {
        if(ls.contains(key)){
            return true;
        }
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