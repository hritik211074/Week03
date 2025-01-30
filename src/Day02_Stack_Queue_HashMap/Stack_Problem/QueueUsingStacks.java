package Day02_Stack_Queue_HashMap.Stack_Problem;


import java.util.*;

class QueueUsingStacks {

    Stack<Integer> s1 = new Stack<>(); // Main stack for enqueue
    Stack<Integer> s2 = new Stack<>(); // Temporary stack for dequeue

    // Enqueue operation
    public void enqueue(int x) {
        s1.push(x);
    }

    // Dequeue operation
    public int dequeue() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) return -1; // Queue is empty
            while (!s1.isEmpty()) s2.push(s1.pop()); // Transfer s1 -> s2
        }
        return s2.pop(); // Pop from s2 (front of queue)
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue()); // 1
        q.enqueue(4);
        System.out.println(q.dequeue()); // 2
        System.out.println(q.dequeue()); // 3
        System.out.println(q.dequeue()); // 4
    }
}


