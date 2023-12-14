import java.util.Scanner;

public class Main {
    public static void stringAnalysis(String str) {
        double uppercase = 0, lowercase = 0, digit = 0, specialchar = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch))
                digit++;
            else if (Character.isLowerCase(ch))
                lowercase++;
            else if (Character.isUpperCase(ch))
                uppercase++;
            else
                specialchar++;
        }
        System.out.printf("%.3f%%\n", (uppercase / n) * 100);
        System.out.printf("%.3f%%\n", (lowercase / n) * 100);
        System.out.printf("%.3f%%\n", (digit / n) * 100);
        System.out.printf("%.3f%%\n", (specialchar / n) * 100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        stringAnalysis(str);
    }
}
