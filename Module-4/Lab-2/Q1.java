import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}


class Solution {
    public List<Integer> smallestTrimmedNumbers(List<String> nums, List<List<Integer>> queries) {
        List<Integer> res = new ArrayList<>();
        for (List<Integer> x : queries) {
            PriorityQueue<Pair<String, Integer>> v = new PriorityQueue<>((a, b) -> a.getKey().compareTo(b.getKey()));
            for (int i = 0; i < nums.size(); i++) {
                int t = nums.get(i).length() - x.get(1);
                String p = nums.get(i).substring(t, t + x.get(1));
                if (v.size() < x.get(0)) {
                    v.offer(new Pair<>(p, i));
                } else {
                    if (v.peek().getKey().compareTo(p) > 0) {
                        v.poll();
                        v.offer(new Pair<>(p, i));
                    }
                }
            }
            int val = v.peek().getValue();
            res.add(val);
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        String input = scanner.nextLine();
        Scanner ss = new Scanner(input);
        List<String> nums = new ArrayList<>();
        while (ss.hasNext()) {
            nums.add(ss.next());
        }

        int q = scanner.nextInt();
        List<List<Integer>> queries = new ArrayList<>();
        for (int i = 0; i < q; ++i) {
            int q0 = scanner.nextInt();
            int q1 = scanner.nextInt();
            List<Integer> query = new ArrayList<>();
            query.add(q0);
            query.add(q1);
            queries.add(query);
        }

        List<Integer> result = solution.smallestTrimmedNumbers(nums, queries);

        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
