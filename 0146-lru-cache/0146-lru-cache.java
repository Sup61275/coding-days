class LRUCache {
    private int capacity;
    private LinkedList<ListNode> list;
    private Map<Integer, ListNode> map; // Store key to ListNode mapping
    class ListNode {
        int key;
        int value;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        list.remove(node); // Remove from current position
        list.addFirst(node); // Add to front as it is most recently used
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            list.remove(node); // Remove old node
            node.value = value; // Update value
            list.addFirst(node); // Add updated node to front
        } else {
            if (list.size() == capacity) {
                ListNode remove = list.removeLast(); // Remove least recently used node
                map.remove(remove.key); // Remove from map
            }
            ListNode newNode = new ListNode(key, value);
            list.addFirst(newNode); // Add new node to front
            map.put(key, newNode); // Put new node in map
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */