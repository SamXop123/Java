package DSA.Backtracking;

/*
notes:

this solves the n-queens problem using backtracking. 
the goal is to place n queens on an n×n board such that no two queens attack each other.

approach:
queens are placed row by row. for each row, all columns are tried one by one. 
before placing a queen at (row, col), isSafe() checks if any queen is already present in:
1) same column (vertical attack)
2) left diagonal (↖)
3) right diagonal (↗)

if safe, queen is placed and recursion moves to the next row. 
if placing further queens fails, backtracking happens by removing the queen and trying the next column.

base case:
when row == n, it means all queens are placed successfully, so the board is printed.

important idea:
only previous rows are checked because queens are placed row by row, so future rows are still empty.

time complexity:
very high (roughly O(n!)) because all possible placements are explored, but pruning happens due to isSafe checks.

mental flow:
try → place → recurse → backtrack → try next

example (n=4):
row 0 → try col 0,1,2,3
row 1 → try valid columns only
...
eventually builds valid boards like:
. Q . .
. . . Q
Q . . .
. . Q .

*/


class N_Queens {
    public static void main(String[] args) {
        int n = 4; // change n for different sizes
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0);
    }

    static void solve(char[][] board, int row) {

        if (row == board.length) {
            printBoard(board);
            System.out.println();
            return;
        }

        // Try placing queen in every column
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 'Q'; // place queen

                solve(board, row + 1); // move to next row

                board[row][col] = '.'; // backtrack (remove queen)
            }
        }
    }

    // Check if position is safe
    static boolean isSafe(char[][] board, int row, int col) {

        // Check column (upwards)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check left diagonal (↖)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check right diagonal (↗)
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
