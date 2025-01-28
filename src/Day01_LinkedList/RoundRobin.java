package Day01_LinkedList;

class Process {
    int id, burstTime, priority, remainingTime, waitingTime = 0, turnAroundTime = 0;
    Process next;

    // Constructor
    Process(int id, int burst, int priority) {
        this.id = id;
        this.burstTime = this.remainingTime = burst;
        this.priority = priority;
    }
}

public class RoundRobin {
    Process head = null, tail = null;

    // Add a new process at the end of the circular list
    void add(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        // Initialize circular list
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else { // Add to the end
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    // Remove a process by Process ID
    void remove(int id) {
        if (head == null) return; // List is empty
        Process curr = head, prev = tail;
        do {
            if (curr.id == id) {
                if (curr == head) head = head.next; // Updating head
                if (curr == tail) tail = prev; // Updating tail
                prev.next = curr.next; // Remove current process
                if (head == curr) head = null; // Last process removed
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Simulate round-robin scheduling
    void simulate(int timeQuantum) {
        if (head == null) return;
        int totalProcesses = 0, totalWaitingTime = 0, totalTurnAroundTime = 0;

        Process curr = head;
        while (head != null) {
            if (curr.remainingTime > 0) {
                int execTime = Math.min(curr.remainingTime, timeQuantum);
                curr.remainingTime -= execTime;

                // Update waiting time for other processes
                Process temp = curr.next;
                while (temp != curr) {
                    if (temp.remainingTime > 0) temp.waitingTime += execTime;
                    temp = temp.next;
                }

                // Calculate turnaround time if process is done
                if (curr.remainingTime == 0) {
                    curr.turnAroundTime = curr.waitingTime + curr.burstTime;
                    totalWaitingTime += curr.waitingTime;
                    totalTurnAroundTime += curr.turnAroundTime;

                    // Remove finished process
                    remove(curr.id);
                }
            }
            curr = curr.next; // Move to next process
        }

        // Display results
        totalProcesses = totalWaitingTime / timeQuantum + totalTurnAroundTime / timeQuantum;
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / totalProcesses);
        System.out.println("Average Turn-Around Time: " + (double) totalTurnAroundTime / totalProcesses);
    }

    // Display all processes in the circular queue
    void display() {
        if (head == null) return;
        Process curr = head;
        do {
            System.out.println("ID: " + curr.id + ", Burst Time: " + curr.burstTime + ", Remaining Time: " + curr.remainingTime + ", Priority: " + curr.priority);
            curr = curr.next;
        } while (curr != head);
    }
    public static void main(String[] args) {
        RoundRobin rr = new RoundRobin();

        // Add processes
        rr.add(1, 10, 1);
        rr.add(2, 5, 2);
        rr.add(3, 8, 3);

        System.out.println("Initial Processes:");
        rr.display();

        // Simulate round-robin with time quantum 3
        rr.simulate(3);
    }
}
