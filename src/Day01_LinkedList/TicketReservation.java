package Day01_LinkedList;

class Ticket {
    // Data members of Ticket class
    int ticketID;
    String customerName, movieName;
    String seatNumber, bookingTime;
    Ticket next;

    //Constructor to initialize the data member of Ticket
    Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

public class TicketReservation {
    // Points to the start of the circular list
    Ticket head = null;
    int totalTickets = 0;

    // Add a new ticket reservation
    void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head; // Circular reference
        } else {
            Ticket temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTicket;
            newTicket.next = head; // Circular linking
        }
        totalTickets++;
    }

    // Remove a ticket by Ticket ID
    void removeTicket(int ticketID) {
        if (head == null) return; // No tickets to remove
        Ticket temp = head, prev = null;

        // Search for the ticket
        do {
            if (temp.ticketID == ticketID) {
                if (temp == head && temp.next == head) {
                    head = null; // Last ticket
                } else {
                    if (temp == head) head = head.next; // Update head
                    if (prev != null) prev.next = temp.next;
                }
                totalTickets--;
                System.out.println("Ticket ID " + ticketID + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Ticket ID " + ticketID + " not found.");
    }

    // Display the current tickets
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +
                    ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket Found: Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No ticket found for query: " + query);
    }

    // Calculate the total number of booked tickets
    int getTotalTickets() {
        return totalTickets;
    }

    public static void main(String[] args) {
        TicketReservation system = new TicketReservation();

        // Adding tickets
        system.addTicket(101, "suresh", "Avengers", "A1", "10:00 AM");
        system.addTicket(102, "mahesh", "Avatar", "B2", "12:00 PM");
        system.addTicket(103, "joojo", "Avengers", "C3", "2:00 PM");

        // Display tickets
        system.displayTickets();

        // Search tickets
        system.searchTicket("Avengers");
        system.searchTicket("ramesh");

        // Remove a ticket
        system.removeTicket(102);

        // Display tickets after removal
        system.displayTickets();

        // Total tickets
        System.out.println("Total Tickets: " + system.getTotalTickets());
    }
}

