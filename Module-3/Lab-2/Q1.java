import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.*;

public class Main {

    public static List<Integer> slidingSubarrayBeauty(List<Integer> arr, int k, int n) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.size(); ++i) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr.get(dq.peekLast()) > arr.get(i)) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= k - 1) {
                result.add(arr.get(dq.peekFirst() + n - 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Scanner ss = new Scanner(input);
        List<Integer> arr = new ArrayList<>();
        while (ss.hasNextInt()) {
            arr.add(ss.nextInt());
        }

        int k = scanner.nextInt();
        int n = scanner.nextInt();

        List<Integer> result = slidingSubarrayBeauty(arr, k, n);

        for (int i = 0; i < result.size(); ++i) {
            System.out.print(result.get(i) + " ");
        }

        System.out.println();
    }
}
