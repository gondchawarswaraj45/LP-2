import java.util.*;

public class NQueen {

    static int n;
    static int board[][];
    static boolean row[];
    static boolean upperDiagonal[];
    static boolean lowerDiagonal[];

    static boolean solve(int col) {

        if (col >= n)
            return true;

        for (int i = 0; i < n; i++) {

            if (!row[i] &&
                    !lowerDiagonal[i + col] &&
                    !upperDiagonal[n - 1 + col - i]) {

                board[i][col] = 1;

                row[i] = true;
                lowerDiagonal[i + col] = true;
                upperDiagonal[n - 1 + col - i] = true;

                if (solve(col + 1))
                    return true;

                board[i][col] = 0;

                row[i] = false;
                lowerDiagonal[i + col] = false;
                upperDiagonal[n - 1 + col - i] = false;
            }
        }

        return false;
    }

    static void printBoard() {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        n = sc.nextInt();

        board = new int[n][n];

        row = new boolean[n];
        lowerDiagonal = new boolean[2 * n - 1];
        upperDiagonal = new boolean[2 * n - 1];

        if (solve(0)) {

            System.out.println("Solution:");

            printBoard();
        }

        else {

            System.out.println("No Solution");
        }

        sc.close();
    }
}