import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.Scanner;

public class Main {
    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        for (int i = 1; i <= num; ++i) {
            int t = num - k * i;
            if (t >= 0 && t % 10 == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int k = scanner.nextInt();

                int result = solution.minimumNumbers(num, k);
                if (result == -1) {
                    System.out.println("-1");
                } else {
                    System.out.println(result);
                }
            } else {
                System.out.println("-1");
            }
        } else {
            System.out.println("-1");
        }
    }
}
