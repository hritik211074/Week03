package Day01_LinkedList;

import java.util.*;

class User {
    int id, age;
    String name;

    // List of Friend IDs
    List<Integer> friends = new ArrayList<>();
    User next;

    // Constructor to initialize the data member of user
    User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class SocialMedia {
    User head = null;

    // Add a new user
    void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser; // Add at the beginning
    }

    // Add a friend connection between two users
    void addFriend(int id1, int id2) {
        User u1 = findUserById(id1), u2 = findUserById(id2);
        if (u1 != null && u2 != null && !u1.friends.contains(id2)) {
            u1.friends.add(id2);
            u2.friends.add(id1);
        }
    }

    // Remove a friend connection
    void removeFriend(int id1, int id2) {
        User u1 = findUserById(id1), u2 = findUserById(id2);
        if (u1 != null && u2 != null) {
            u1.friends.remove((Integer) id2);
            u2.friends.remove((Integer) id1);
        }
    }

    // Find mutual friends between two users
    void findMutualFriends(int id1, int id2) {
        User u1 = findUserById(id1), u2 = findUserById(id2);

        if (u1 != null && u2 != null) {
            System.out.print("Mutual Friends: ");
            for (int friend : u1.friends) {
                if (u2.friends.contains(friend)) System.out.print(friend + " ");
            }
            System.out.println();
        }
    }

    // Display all friends of a specific user
    void displayFriends(int id) {
        User user = findUserById(id);
        if (user != null) {
            System.out.print(user.name + "'s Friends: ");
            for (int friend : user.friends) System.out.print(friend + " ");
            System.out.println();
        }
    }

    // Search for a user by Name or User ID
    User findUserById(int id) {
        User curr = head;
        while (curr != null) {
            if (curr.id == id) return curr;
            curr = curr.next;
        }
        return null;
    }

    void searchUser(String name) {
        User curr = head;
        while (curr != null) {
            if (curr.name.equalsIgnoreCase(name)) {
                System.out.println("Found User - ID: " + curr.id + ", Name: " + curr.name + ", Age: " + curr.age);
                return;
            }
            curr = curr.next;
        }
        System.out.println("User not found.");
    }

    // Count the number of friends for each user
    void countFriends() {
        User curr = head;
        while (curr != null) {
            System.out.println(curr.name + " has " + curr.friends.size() + " friends.");
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        //Instance of SociaMedia class to perform some operation
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "suresh", 25);
        sm.addUser(2, "mahesh", 30);
        sm.addUser(3, "joojo", 20);

        sm.addFriend(1, 2); // suresh and mahesh are now friends
        sm.addFriend(2, 3); // mahesh and joojo are now friends

        sm.displayFriends(2); // Display mahesh's friends
        sm.findMutualFriends(1, 3); // Find mutual friends between Alice and Charlie

        sm.removeFriend(1, 2); // Remove friendship between suresh and mahesh
        sm.displayFriends(1); // Display suresh's friends

        sm.searchUser("Charlie"); // Search for joojo
        sm.countFriends(); // Count friends for all users
    }
}

