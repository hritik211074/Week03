package Day02_Stack_Queue_HashMap.Stack_Problem;

import java.util.*;
// Here a main class
public class sortUsingRecursion {
    // Here a method to sort the stack
    static void insertSort(Stack<Integer>st,int target){
        // Check stack is empty or not
        if(st.empty()){
            st.push(target);
            return;
        }
        // Checking the condition where incoming target should be less than top of stack
        if(st.peek()>=target){
            st.push(target);
            return ;
        }
        int temp=st.peek();  // Access the top of stack
        st.pop();  // Remove top element of stack
        insertSort(st,target);
        st.push(temp);
    }
    // Method to reverse the stack
    static void reverseStack(Stack<Integer>st){

        if(st.empty()) return;

        int temp=st.peek();

        st.pop();
        reverseStack(st);
        // Here calling the sorting method to sort stack
        insertSort(st,temp);
    }
    public static void main(String[] args) {
        // Creating a stack
        Stack<Integer>st=new Stack<>();
        st.push(2);
        st.push(6);
        st.push(100);
        st.push(5);
        st.push(1);
        st.push(7);
        // Call method to reverse the stack
        reverseStack(st);
        // Display the stack elements
        while(!st.empty()){
            System.out.print(st.peek() + " ");
            st.pop();
        }
    }

}
