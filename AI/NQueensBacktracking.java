class NQueensBacktracking {
    final int N = 8;
    final int PRINT_LIMIT = 4;
    int solutionCount = 0;
    int printedSolutions = 0;

    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check row on left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    void solveNQUtil(int board[][], int col) {
        if (col >= N) {
            solutionCount++;
            if (printedSolutions < PRINT_LIMIT) {
                System.out.println("Solution #" + solutionCount + ":");
                printSolution(board);
                System.out.println();
                printedSolutions++;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                solveNQUtil(board, col + 1);

                board[i][col] = 0; // Backtrack
            }
        }
    }

    void solveNQ() {
        int board[][] = new int[N][N];

        solveNQUtil(board, 0);

        if (solutionCount == 0) {
            System.out.println("Solution does not exist");
            return;
        }

        System.out.println("Total solutions: " + solutionCount);
    }

    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print("- ");
            System.out.println();
        }
    }

    public static void main(String args[]) {
        NQueensBacktracking obj = new NQueensBacktracking();
        obj.solveNQ();
    }
}