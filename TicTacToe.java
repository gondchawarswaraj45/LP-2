
import java.util.*;

public class TicTacToe {

    static char[][] b = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };

    static Scanner sc = new Scanner(System.in);

    static void show() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print(b[i][j]);

                if (j < 2)
                    System.out.print(" | ");
            }

            System.out.println();

            if (i < 2)
                System.out.println("---------");
        }

        System.out.println();
    }

    static boolean win(char p) {

        for (int i = 0; i < 3; i++) {

            if ((b[i][0] == p && b[i][1] == p && b[i][2] == p) ||
                    (b[0][i] == p && b[1][i] == p && b[2][i] == p))
                return true;
        }

        if ((b[0][0] == p && b[1][1] == p && b[2][2] == p) ||
                (b[0][2] == p && b[1][1] == p && b[2][0] == p))
            return true;

        return false;
    }

    static boolean full() {

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (b[i][j] == ' ')
                    return false;

        return true;
    }

    static int minimax(boolean ai) {

        if (win('O'))
            return 1;

        if (win('X'))
            return -1;

        if (full())
            return 0;

        int best = ai ? -100 : 100;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (b[i][j] == ' ') {

                    b[i][j] = ai ? 'O' : 'X';

                    int score = minimax(!ai);

                    b[i][j] = ' ';

                    if (ai)
                        best = Math.max(best, score);
                    else
                        best = Math.min(best, score);
                }
            }
        }

        return best;
    }

    static void computerMove() {

        int best = -100, row = 0, col = 0;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (b[i][j] == ' ') {

                    b[i][j] = 'O';

                    int score = minimax(false);

                    b[i][j] = ' ';

                    if (score > best) {

                        best = score;
                        row = i;
                        col = j;
                    }
                }
            }
        }

        b[row][col] = 'O';
    }

    public static void main(String[] args) {

        while (true) {

            show();

            int r, c;

            System.out.print("Enter row and column: ");
            r = sc.nextInt();
            c = sc.nextInt();

            if (b[r][c] == ' ') {

                b[r][c] = 'X';

                if (win('X')) {

                    show();
                    System.out.println("Player Wins");
                    break;
                }

                if (full()) {

                    show();
                    System.out.println("Draw");
                    break;
                }

                computerMove();

                if (win('O')) {

                    show();
                    System.out.println("Computer Wins");
                    break;
                }

                if (full()) {

                    show();
                    System.out.println("Draw");
                    break;
                }
            }
        }

        sc.close();
    }
}