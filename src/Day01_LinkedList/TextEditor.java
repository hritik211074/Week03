package Day01_LinkedList;

class TextState {
    // Data members of Text State
    String text;
    TextState prev, next;

    TextState(String text) {
        this.text = text;
    }
}

public class TextEditor {
    // Current state
    TextState current;

    // Limit for undo/redo history
    int maxHistory = 10;
    int size = 0;

    // Add a new text state
    void addState(String newText) {
        TextState newState = new TextState(newText);
        if (current != null) current.next = newState;
        newState.prev = current;
        current = newState;

        // Truncate history if size exceeds maxHistory
        size++;
        if (size > maxHistory) {
            TextState head = current;
            // Find the oldest state
            while (head.prev != null) head = head.prev;
            // Remove oldest
            head.next.prev = null;
            head = head.next;
            size--;
        }
    }

    // Revert to the previous state
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Revert to the next state
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display the current state
    void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("No text available.");
        }
    }

    public static void main(String[] args) {

        // Creating the object of TextEditor
        TextEditor editor = new TextEditor();

        // Simulate text editor actions
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.displayCurrentState(); // Display current state

        editor.undo();
        // Undo to previous state
        editor.displayCurrentState();

        editor.redo();
        // Redo to next state
        editor.displayCurrentState();

        editor.addState("Hello, World! How are you?");
        // Add new state and display
        editor.displayCurrentState();


        // Add more states to test max history
        for (int i = 1; i <= 12; i++) editor.addState("State " + i);
        // Verify the latest state
        editor.displayCurrentState();
    }
}

