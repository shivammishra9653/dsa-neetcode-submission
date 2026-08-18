class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node head;
    Node tail;
    Map<Integer, Node> cache = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void add(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        int res = -1;
       if(cache.containsKey(key)) {
        Node node = cache.get(key);
        res = node.value;
        delete(node);
        add(node);
       }
       return res;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            delete(cache.get(key));
        } else if(capacity == cache.size()) {
            cache.remove(tail.prev.key);
            delete(tail.prev);
        }
        Node node = new Node(key, value);
        add(node);
        cache.put(key, node);
        
    }
}
