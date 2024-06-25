class RandomizedSet {
    List<Integer>list;
    Map<Integer,Integer>map;
    public RandomizedSet() {
        list= new ArrayList<>();
        map= new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int idx_toRemove=map.get(val);
        int lastEle=list.get(list.size()-1);
        list.set(idx_toRemove,lastEle);
        map.put(lastEle,idx_toRemove);
        list.remove(list.size()-1);
        map.remove(val);

        
        return true;
    }
    
    public int getRandom() {
        int randomIdx=(int)(Math.random()*list.size());
        return list.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */