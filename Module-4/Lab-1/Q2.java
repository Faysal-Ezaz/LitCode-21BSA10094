import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int queries = scanner.nextInt();
        int[] array = new int[size + 1];

        for (int i = 0; i < queries; ++i) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            int value = scanner.nextInt();
            array[left] += value;
            if (right + 1 <= size) {
                array[right + 1] -= value;
            }
        }

        int maxVal = array[1];
        for (int i = 2; i <= size; ++i) {
            array[i] += array[i - 1];
            maxVal = Math.max(maxVal, array[i]);
        }

        System.out.println(maxVal);
    }
}
