import java.util.Scanner;
import java.util.Stack;

class CustomQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public CustomQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void enqueue(int x) {
        inputStack.push(x);
    }

    public void dequeue() {
        if (outputStack.isEmpty()) {
            // Transfer elements from input stack to output stack
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        if (!outputStack.isEmpty()) {
            outputStack.pop();
        }
    }

    public int front() {
        if (outputStack.isEmpty()) {
            // Transfer elements from input stack to output stack
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.isEmpty() ? -1 : outputStack.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomQueue queue = new CustomQueue();

        String input = scanner.nextLine();
        String[] queries = input.split(",");
        for (String query : queries) {
            int type = query.charAt(0) - '0';
            if (type == 1) {
                // Enqueue operation
                int value = Integer.parseInt(query.substring(2));
                queue.enqueue(value);
            } else if (type == 2) {
                // Dequeue operation
                queue.dequeue();
            } else if (type == 3) {
                // Print Front operation
                int frontValue = queue.front();
                System.out.println(frontValue);
            }
        }
    }
}
