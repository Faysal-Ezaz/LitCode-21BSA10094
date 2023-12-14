import java.util.Scanner;

public class Main {
    public static boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; ++i) {
            if (board[row][i] == num || board[i][col] == num || board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean solveSudoku(char[][] board) {
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; ++num) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        char[][] board = new char[size][size];
        for (int i = 0; i < size; ++i) {
            String line = scanner.next();
            for (int j = 0; j < size; ++j) {
                board[i][j] = line.charAt(j);
            }
        }

        if (solveSudoku(board)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
