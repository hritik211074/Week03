package Day01_LinkedList;

import java.util.*;

// Class to create TaskNode
class TaskNode {
    // Data member of Class node
    int taskId, priority;
    String taskName, dueDate;
    TaskNode next;

    // Constructor to initialize the taskId, prority , taskName , dueDate
    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

// Here a TaskScheduler class to perform the task
public class TaskScheduler {
    // Starting of LinkeddList
    private TaskNode head = null;

    // Method to add task
    void addTask(int taskId, String taskName, int priority, String dueDate, int position) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;

            // Circular link
            head.next = head;
        } else if (position == 0) {
            TaskNode tail = getTail();
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        } else if (position == -1) {
            TaskNode tail = getTail();
            tail.next = newNode;
            newNode.next = head;
        }
    }

    // Method to remove task
    void removeTask(int taskId) {
        if (head == null) return;
        TaskNode current = head, prev = null;
        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    TaskNode tail = getTail();
                    if (current.next == head) {
                        head = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Methos to  searrch task
    TaskNode searchTask(int priority) {
        if (head == null) return null;
        TaskNode current = head;
        do {
            if (current.priority == priority) return current;
            current = current.next;
        } while (current != head);
        return null;
    }

    // Method to see current and next task
    void viewCurrentAndNextTask(TaskNode currentTask) {
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName);
            System.out.println("Next Task: " + currentTask.next.taskName);
        }
    }

    // Method to display task
    void displayTasks() {
        if (head == null) return;
        TaskNode current = head;
        do {
            System.out.println(current.taskId + ", " + current.taskName + ", " + current.priority + ", " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Method to get the last taask
    private TaskNode getTail() {
        TaskNode current = head;
        while (current.next != head) {
            current = current.next;
        }
        return current;
    }

    // Main method
    public static void main(String[] args) {
        // Instance of TaskScheduler
        TaskScheduler scheduler = new TaskScheduler();

        // Adding the task
        scheduler.addTask(1, "Task A", 1, "2025-01-30", -1);
        scheduler.addTask(2, "Task B", 2, "2025-02-05", 0);
        scheduler.addTask(3, "Task C", 3, "2025-02-10", -1);

        System.out.println("All tasks:");
        scheduler.displayTasks();

        System.out.println("Searching for priority 2:");
        TaskNode found = scheduler.searchTask(2);
        if (found != null) System.out.println("Found Task: " + found.taskName);

        System.out.println("Removing Task A:");
        scheduler.removeTask(1);
        scheduler.displayTasks();
    }
}

