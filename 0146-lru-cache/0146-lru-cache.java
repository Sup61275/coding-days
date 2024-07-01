class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer,Integer>map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map= new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer>entry){
                return size()>capacity;
            }
        };
    }

    public int get(int key) {
      return map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
       map.put(key,value);
    }
}
//In Java, to override a method from a superclass, 
//the method in the subclass must have the same or less restrictive access level.
//The removeEldestEntry method in LinkedHashMap is protected,
//so the overriding method in the anonymous subclass must also be protected.