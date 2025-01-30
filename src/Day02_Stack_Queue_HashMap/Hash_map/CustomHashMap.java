package Day02_Stack_Queue_HashMap.Hash_map;

import java.util.LinkedList;

public class CustomHashMap {

    // Define the array of linked lists for separate chaining
    private LinkedList<Node>[] map;

    private int size;

    // Node class representing each key-value pair in the linked list
    private class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the hash map with a given capacity
    public CustomHashMap(int capacity) {
        map = new LinkedList[capacity];
        size = 0;
        for (int i = 0; i < capacity; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function to compute the index in the array
    private int hash(int key) {
        return key % map.length;
    }

    // Insert a key-value pair into the map
    public void insert(int key, int value) {
        int index = hash(key);
        LinkedList<Node> bucket = map[index];

        // Check if the key already exists and update the value
        for (Node node : bucket) {
            if (node.key == key) {
                node.value = value;  // Update existing key's value
                return;
            }
        }

        // If key doesn't exist, add a new node
        bucket.add(new Node(key, value));
        size++;
    }

    // Delete a key-value pair from the map
    public void delete(int key) {
        int index = hash(key);
        LinkedList<Node> bucket = map[index];

        // Find and remove the node with the matching key
        for (Node node : bucket) {
            if (node.key == key) {
                bucket.remove(node);
                size--;
                return;
            }
        }
    }

    // Retrieve the value associated with a key
    public Integer get(int key) {
        int index = hash(key);
        LinkedList<Node> bucket = map[index];

        // Search for the key and return its value
        for (Node node : bucket) {
            if (node.key == key) {
                return node.value;
            }
        }

        // If key is not found, return null
        return null;
    }

    // Display the contents of the hash map (for testing purposes)
    public void display() {
        for (int i = 0; i < map.length; i++) {
            LinkedList<Node> bucket = map[i];
            if (!bucket.isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Node node : bucket) {
                    System.out.print("[" + node.key + "=" + node.value + "] ");
                }
                System.out.println();
            }
        }
    }

    // Return the size of the hash map (number of key-value pairs)
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap(10); // Create a HashMap with capacity 10

        // Inserting key-value pairs
        map.insert(1, 100);
        map.insert(2, 200);
        map.insert(3, 300);
        map.insert(12, 400); // Collision with key 2, both hash to index 2

        // Displaying the map
        map.display();

        // Retrieving values by key
        System.out.println("Value for key 1: " + map.get(1));
        System.out.println("Value for key 2: " + map.get(2));
        System.out.println("Value for key 3: " + map.get(3));

        // Deleting a key-value pair
        map.delete(2);

        // Displaying after deletion
        map.display();
        System.out.println("Value for key 2 (after deletion): " + map.get(2));

        // Display size
        System.out.println("Size of the map: " + map.size());
    }
}

