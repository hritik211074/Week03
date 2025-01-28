package Day01_LinkedList;

import java.util.*;

class MovieNode {
    // Data member of MovieNode
    String title, director;
    int year;
    double rating;
    MovieNode next, prev;

    // Constructor to initialize the data member of MovieNode Class
    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}


// Here a MovieManagement class
public class MovieManagement {
    private MovieNode head, tail;

    // Method to add movie
    void addMovie(String title, String director, int year, double rating, int position) {

        // Here a movieNode we are creating
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else if (position == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (position == -1) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to remove movie
    void removeMovie(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current.prev != null) current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;
                if (current == head) head = current.next;
                if (current == tail) tail = current.prev;
                return;
            }
            current = current.next;
        }
    }

    ///  Method to search
    MovieNode searchMovie(String director, Double rating) {
        MovieNode current = head;
        while (current != null) {
            if ((director != null && current.director.equalsIgnoreCase(director)) ||
                    (rating != null && current.rating == rating)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    //  Method to display all the movies
    void displayMovies(boolean reverse) {
        MovieNode current = reverse ? tail : head;
        while (current != null) {
            System.out.println(current.title + ", " + current.director + ", " + current.year + ", " + current.rating);
            current = reverse ? current.prev : current.next;
        }
    }

    // update the rating of movie
    void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {

        MovieManagement mm = new MovieManagement();

        mm.addMovie("Inception", "Nolan", 2010, 8.8, -1);
        mm.addMovie("Avatar", "Cameron", 2009, 7.8, 0);
        mm.addMovie("Interstellar", "Nolan", 2014, 8.6, -1);
        mm.displayMovies(false);
        mm.updateRating("Avatar", 8.0);
        mm.removeMovie("Inception");
        mm.displayMovies(true);
    }
}

