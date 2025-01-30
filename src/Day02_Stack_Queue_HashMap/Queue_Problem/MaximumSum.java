package Day02_Stack_Queue_HashMap.Queue_Problem;

import java.util.*;
// Here Maximum class
public class MaximumSum {

    ///  Method to find the maximum within windo of k
    public static int[] maxSlidingWindow(int[] nums, int k) {

        // Make a deque
        Deque<Integer> dq=new ArrayDeque<>();
        int i=0;
        int j=0;
        // traverse the window
        while(i-j!=k){
            while(!dq.isEmpty() && dq.peekFirst()<nums[i]){
                dq.removeFirst();
            }
            if(dq.isEmpty() || dq.peekFirst()>=nums[i]){
                dq.addFirst(nums[i]);
            }
            i++;
        }

        // Store the answer in asn array
        int [] ans=new int[nums.length-k+1];

        ans[j]=dq.peekLast();

        // Traverse in such a way that we can find the maximum in each window
        while(i!=nums.length){
            if(dq.peekLast()==nums[j] ){
                dq.removeLast();
            }
            j++;
            while(!dq.isEmpty() && dq.peekFirst()<nums[i]){
                dq.removeFirst();
            }
            if(dq.isEmpty() || dq.peekFirst()>=nums[i]){
                dq.addFirst(nums[i]);
            }
            i++;
            ans[j]=dq.peekLast();
        }
        return ans;  // Return the ans
    }

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner sc=new Scanner(System.in);

        // Make the instance of MaximumSum class
        MaximumSum max =new MaximumSum();

        System.out.println("Enter the number of values: ");
        int num=sc.nextInt();  // Read the number of value

        int arr[]=new int[num];   // Creating the array to store the num number of values


        System.out.println("Enter the values in array : ");

        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the size of window: ");
        int k=sc.nextInt();

        // Store the ans in ans array

        int ans []=maxSlidingWindow(arr,k);
        // Traverse the ans valu
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
