class MyHashMap {
    private static final int SIZE = 1000000;
    private Node[] nodes;

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        Node node = find(nodes[index], key);
        if (node != null) {
            node.value = value; // Update existing value
        } else {
            Node newNode = new Node(key, value);
            newNode.next = nodes[index];
            nodes[index] = newNode;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        Node node = find(nodes[index], key);
        if (node != null) {
            return node.value;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        Node prev = null;
        Node curr = nodes[index];
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    nodes[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    /** Helper method to compute the index in the array */
    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    /** Helper method to find the node with the given key */
    private Node find(Node head, int key) {
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
}
