package Day02_Stack_Queue_HashMap.Stack_Problem;

import java.util.*;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {

        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while they are smaller than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, all previous prices were smaller
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index onto stack
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {

        // Collection of price
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Your span answer
        int[] span = calculateSpan(prices);

        System.out.println("Stock Span: " + Arrays.toString(span));
    }
}
