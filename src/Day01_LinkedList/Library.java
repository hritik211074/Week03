package Day01_LinkedList;

class Book {
    String title, author, genre;
    int id;
    boolean isAvailable;
    Book prev, next;

    Book(String t, String a, String g, int i, boolean avail) { // Constructor for a Book
        title = t; author = a; genre = g; id = i; isAvailable = avail;
    }
}

public class Library {
    Book head, tail; // Head and Tail for the doubly linked list

    // Add a new book at the beginning, end, or specific position
    void add(String title, String author, String genre, int id, boolean avail, int pos) {

        Book newBook = new Book(title, author, genre, id, avail);
        if (head == null || pos <= 0) { // Add at the beginning
            newBook.next = head; if (head != null) head.prev = newBook; head = newBook;
            if (tail == null) tail = newBook; return;
        }
        if (pos > 0 && tail != null) { // Add at the end
            newBook.prev = tail; tail.next = newBook; tail = newBook; return;
        }
    }

    // Remove a book by Book ID
    void remove(int id) {
        for (Book temp = head; temp != null; temp = temp.next) {
            if (temp.id == id) {
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                return;
            }
        }
    }

    // Search for a book by Title or Author
    void search(String key) {
        for (Book temp = head; temp != null; temp = temp.next) {
            if (temp.title.equalsIgnoreCase(key) || temp.author.equalsIgnoreCase(key))
                System.out.println(temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.id + ", Available: " + temp.isAvailable);
        }
    }

    // Update a book's Availability Status
    void update(int id, boolean avail) {
        for (Book temp = head; temp != null; temp = temp.next)
            if (temp.id == id) temp.isAvailable = avail;
    }

    // Display all books in forward order
    void displayForward() {
        for (Book temp = head; temp != null; temp = temp.next)
            System.out.println(temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.id + ", Available: " + temp.isAvailable);
    }

    // Display all books in reverse order
    void displayReverse() {
        for (Book temp = tail; temp != null; temp = temp.prev)
            System.out.println(temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.id + ", Available: " + temp.isAvailable);
    }

    // Count the total number of books
    int countBooks() {
        int count = 0;
        for (Book temp = head; temp != null; temp = temp.next) count++;
        return count;
    }

    public static void main(String[] args) {
        Library lib = new Library();
        lib.add("Book1", "Author1", "Fiction", 101, true, 0); // Add at beginning
        lib.add("Book2", "Author2", "Non-Fiction", 102, false, -1); // Add at end
        lib.add("Book3", "Author3", "Mystery", 103, true, 1); // Add at position 1

        // Display all books in forward order
        lib.displayForward();

        // Update availability of Book ID 101
        lib.update(101, false);

        // Search for a book by Author
        lib.search("Author1");

        // Count total books
        System.out.println("Total Books: " + lib.countBooks());

        // Remove Book ID 102
        lib.remove(102);

        // Display books in reverse order
        lib.displayReverse();
    }
}

