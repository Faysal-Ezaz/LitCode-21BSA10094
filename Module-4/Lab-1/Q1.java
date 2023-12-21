import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.Scanner;

public class Main {
    
    public int clumsy(int N) {
        if (N <= 2) {
            return N;
        } else if (N <= 4) {
            return N + 3;
        } else {
            if ((N - 4) % 4 == 0) {
                return N + 1;
            } else if ((N - 4) % 4 <= 2) {
                return N + 2;
            } else {
                return N - 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int N = scanner.nextInt();
        int clumsyFactorial = solution.clumsy(N);
        System.out.println(clumsyFactorial);
    }
}
