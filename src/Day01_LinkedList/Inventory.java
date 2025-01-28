package Day01_LinkedList;

class Node {
    // Name of inventory
    String name;
    // Item ID, Quantity, and Price
    int id, qty, price;
    // Pointer to the next node
    Node next;

    // Constructor to initialize a node
    Node(String n, int i, int q, int p) {
        name = n; id = i; qty = q; price = p;
    }
}

 public class Inventory {
     // Head of the linked list
     Node head;

    // Add an item at a specific position, beginning, or end
    void add(String name, int id, int qty, int price, int pos) {
        Node n = new Node(name, id, qty, price);
        if (pos <= 0 || head == null) { // Add at the beginning
            n.next = head; head = n; return;
        }
        Node temp = head;
        while (--pos > 0 && temp.next != null) temp = temp.next; // Traverse to the position
        n.next = temp.next; temp.next = n; // Insert at position
    }

    // Remove an item based on Item ID
    void remove(int id) {
        Node temp = head, prev = null;

        // Traverse to find the node
        while (temp != null && temp.id != id) {
            prev = temp; temp = temp.next;
        }
        // Item not found
        if (temp == null) return;

        // Remove head
        if (prev == null) head = temp.next;

        // Remove intermediate node
        else prev.next = temp.next;
    }

    // Update the quantity of an item by ID
    void update(int id, int qty) {
        for (Node temp = head; temp != null; temp = temp.next)
            // Update quantity if ID matches
            if (temp.id == id) temp.qty = qty;
    }

    // Search for an item by Item ID or Name
    void search(String key) {
        for (Node temp = head; temp != null; temp = temp.next)
            if (temp.name.equalsIgnoreCase(key) || String.valueOf(temp.id).equals(key))
                System.out.println(temp.name + ", ID: " + temp.id + ", Qty: " + temp.qty + ", Price: " + temp.price);
    }

    // Calculate and display the total value of the inventory
    void totalValue() {
        int total = 0;
        for (Node temp = head; temp != null; temp = temp.next)
            total += temp.qty * temp.price; // Sum of Quantity * Price
        System.out.println("Total Value: " + total);
    }

    // Display all items in the inventory
    void display() {
        for (Node temp = head; temp != null; temp = temp.next)
            System.out.println(temp.name + ", ID: " + temp.id + ", Qty: " + temp.qty + ", Price: " + temp.price);
    }
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        // Add at the beginning
        inv.add("Item1", 101, 5, 100, 0);
        // Add at the end
        inv.add("Item2", 102, 10, 200, -1);

        // Add at position 1
        inv.add("Item3", 103, 2, 50, 1);

        // Display all items
        inv.display();

        // Update quantity for Item ID 101
        inv.update(101, 8);

        // Search for an item by name
        inv.search("Item1");

        // Calculate and display total inventory value
        inv.totalValue();

        // Remove Item ID 102
        inv.remove(102);

        // Display items after removal
        inv.display();
    }
}

