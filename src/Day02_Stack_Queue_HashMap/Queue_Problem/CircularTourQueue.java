package Day02_Stack_Queue_HashMap.Queue_Problem;

import java.util.LinkedList;
import java.util.Queue;

class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTourQueue {

    // Function to find the starting petrol pump index using a queue
    public static int findStartingPump(PetrolPump[] pumps) {
        int n = pumps.length;
        Queue<Integer> queue = new LinkedList<>();
        int totalPetrol = 0, totalDistance = 0;
        int surplus = 0, startIndex = 0;

        for (int i = 0; i < n; i++) {
            queue.add(i); // Add pump index to the queue
            totalPetrol += pumps[i].petrol;
            totalDistance += pumps[i].distance;
            surplus += pumps[i].petrol - pumps[i].distance;

            // If surplus is negative, reset the start index and clear queue
            if (surplus < 0) {
                startIndex = i + 1; // Move to next pump
                surplus = 0; // Reset surplus
                queue.clear(); // Reset queue as previous path is invalid
            }
        }

        // If total petrol is sufficient for total distance, return valid start index
        return (totalPetrol >= totalDistance) ? startIndex : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };

        int startIndex = findStartingPump(pumps);

        if (startIndex != -1) {
            System.out.println("Start at petrol pump index: " + startIndex);
        } else {
            System.out.println("Circular tour is not possible");
        }
    }
}