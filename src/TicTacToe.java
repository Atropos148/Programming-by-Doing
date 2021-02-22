import java.util.Scanner;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    static char[] players = { 'O', 'X' };
    static int currentPlayer = 0;
    static int filledPositions = 0;
    public static final String PLAYER_WON = "%c wins";

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        initBoard();
        System.out.println(board.length);
        displayBoard();

        do {
            choosePosition(keyboard);
            displayBoard();
            checkBoard();
            nextPlayer();
        } while (filledPositions < 9);

        keyboard.close();
    }

    public static void initBoard() {
        int boardSize = 3;
        // fills up the board with blanks
        for (int r = 0; r < boardSize; r++)
            for (int c = 0; c < boardSize; c++)
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
        try {
            String chosenPosition = keyboard.nextLine();

            if (chosenPosition.length() > 1) {
                String[] splitPosition = chosenPosition.split(" ");

                int row = Integer.parseInt(splitPosition[0]) - 1;
                int column = Integer.parseInt(splitPosition[1]) - 1;

                if ((row <= 2 && row >= 0) && (column <= 2 && column >= 0)) {
                    System.out.println();

                    int[] splitPositionInt = { row, column };
                    updateBoard(splitPositionInt);
                } else {
                    System.out.println("Only type in 2 numbers, between 1 and 3, separated by a space");
                }

            } else {
                System.out.println("Only type in 2 numbers, separated by a space");
            }
        } catch (NumberFormatException e) {
            System.out.println("Only type in 2 numbers, separated by a space");
        }
    }

    public static void updateBoard(int[] position) {
        int row = position[0];
        int column = position[1];

        if (board[row][column] == ' ') {
            board[row][column] = players[currentPlayer];
            filledPositions++;
        } else {
            System.out.println("That position is taken");
        }
    }

    public static void checkBoard() {
        for (char player : players) {

            // row check
            rowCheck(player);

            // column check
            columnCheck(player);

            // cross check
            crossCheck(player);

        }
    }

    public static void rowCheck(char player) {
        for (char[] row : board) {
            int rowPoints = 0;
            for (char characterAtPosition : row) {
                if (characterAtPosition == player) {
                    rowPoints++;
                }

                if (rowPoints == 3) {
                    System.out.printf(PLAYER_WON, player);
                    System.exit(0);
                }
            }
        }
    }

    public static void columnCheck(char player) {
        for (int column = 0; column < board.length; column++) {
            int columnPoints = 0;
            for (int row = 0; row < board[column].length; row++) {
                if (board[row][column] == player) {
                    columnPoints++;
                }
            }

            if (columnPoints == 3) {
                System.out.printf(PLAYER_WON, player);
                System.exit(0);
            }
        }
    }

    public static void crossCheck(char player) {
        // assuming 3x3 grid

        boolean topLeft = board[0][0] == player && board[1][1] == player && board[2][2] == player;
        boolean bottomLeft = board[2][0] == player && board[1][1] == player && board[0][2] == player;
        // top left start
        if (topLeft || bottomLeft) {
            System.out.printf(PLAYER_WON, player);
            System.exit(0);
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