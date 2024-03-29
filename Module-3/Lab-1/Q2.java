import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Main {
    public int minStepsToReachTargetSweetness(int target, List<Integer> candies) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(candies);

        int steps = 0;
        while (minHeap.peek() < target) {
            int leastSweet = minHeap.poll();
            int secondLeastSweet = minHeap.poll();

            int newSweetness = leastSweet + 2 * secondLeastSweet;
            minHeap.offer(newSweetness);
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String input = scanner.nextLine();
        Scanner candyScanner = new Scanner(input);
        List<Integer> candies = new ArrayList<>();
        while (candyScanner.hasNextInt()) {
            candies.add(candyScanner.nextInt());
        }

        int steps = solution.minStepsToReachTargetSweetness(target, candies);
        System.out.println(steps);
    }
}
