package Day01_LinkedList;

import java.util.*;

class StudentNode {
    // Data member of Student Node
    int roll_number;
    String name;
    int age;
    char grade;
    StudentNode next;

    // Constructor to initialize roll number , name , age , grade
    StudentNode(int roll_number, String name, int age, char grade) {
        this.roll_number = roll_number;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecord {

    // Methos to add student
    StudentNode add(StudentNode head, StudentNode tail, StudentNode data) {
        if (head == null || tail == null) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
        return tail;
    }

    // Method to delete student based on their roll number
    void delete(StudentNode head, int rollNumber) {
        if (head == null) return;

        // If the head node needs to be deleted
        if (head.roll_number == rollNumber) {
            head = head.next;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null) {
            if (temp.next.roll_number == rollNumber) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    // method to search student the  based on their rolll number
    boolean searchNode(StudentNode head, int rollNumber) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll_number == rollNumber) return true;
            temp = temp.next;
        }
        return false;
    }

    // Method to display all student details
    void displayAllNode(StudentNode head) {
        StudentNode temp = head;
        int start = 1;
        while (temp != null) {
            System.out.println("Student " + start + " roll number is " + temp.roll_number +
                    " and name is " + temp.name +
                    ", age is " + temp.age +
                    ", grade is " + temp.grade);
            temp = temp.next;
            start++;
        }
    }

    void updateGrade(StudentNode head, int roll_number, char newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll_number == roll_number) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Creating the instance of student
        StudentRecord student = new StudentRecord();

        // Creating the scanner class object to read user input
        Scanner sc = new Scanner(System.in);

        // Initialize the head and tail with null
        StudentNode head = null;
        StudentNode tail = null;

        System.out.print("Enter the number of students: ");
        int number = sc.nextInt();
        int start = 0;
        // Loop for number of student
        while (start < number) {

            System.out.println("Enter the roll number: ");
            int roll_number = sc.nextInt();

            System.out.println("Enter the name of the student: ");
            String name = sc.next();

            System.out.println("Enter the age of the student: ");
            int age = sc.nextInt();

            System.out.println("Enter the grade of the student: ");
            char grade = sc.next().charAt(0);

            StudentNode st = new StudentNode(roll_number, name, age, grade);
            tail = student.add(head, tail, st);

            if (head == null) {
                head = tail;
            }

            start++;
        }

        student.displayAllNode(head);
        student.searchNode(head,23);
        student.updateGrade(head,2342,'A');
    }
}
