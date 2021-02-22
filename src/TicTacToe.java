import java.util.Scanner;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    static char[] players = { 'O', 'X' };
    static int currentPlayer = 0;
    static int filledPositions = 0;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        initBoard();
        displayBoard();

        do {
            choosePosition(keyboard);
            displayBoard();
            nextPlayer();
        } while (filledPositions < 9);

        keyboard.close();
    }

    public static void initBoard() {
        // fills up the board with blanks
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';
    }

    public static void displayBoard() {
        System.out.println("  1  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  3  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     1 2 3 ");
        System.out.println();
    }

    public static void nextPlayer() {
        currentPlayer++;
        if (currentPlayer > players.length - 1) {
            currentPlayer = 0;
        }
    }

    public static void choosePosition(Scanner keyboard) {
        System.out.printf("%c, choose your location (row column) > ", players[currentPlayer]);
        String[] chosenPosition = keyboard.nextLine().split(" ");

        System.out.println();

        updateBoard(chosenPosition);
    }

    public static void updateBoard(String[] position) {
        int row = Integer.parseInt(position[0]) - 1;
        int column = Integer.parseInt(position[1]) - 1;

        if (board[row][column] == ' ') {
            board[row][column] = players[currentPlayer];
            filledPositions++;
        } else {
            System.out.println("That position is taken");
        }
    }

    public static void displayBoard2() {
        for (int r = 0; r < 3; r++) {
            System.out.print("\t" + r + " ");
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("\t  0 1 2 ");
    }
}