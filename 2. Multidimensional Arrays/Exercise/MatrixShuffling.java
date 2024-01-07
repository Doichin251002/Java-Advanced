import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] dimensions = scan.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][cols];

        fillMatrix(scan, matrix);

        String command = scan.nextLine();
        while (!command.equals("END")) {
            if (isValidatedCommand(command, rows, cols)) {
                String[] tokens = command.split(" ");
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            command = scan.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidatedCommand(String command, int rows, int cols) {
        String[] tokens = command.split(" ");
        if (tokens.length != 5) {
            return false;
        }
        if (!tokens[0].equals("swap")) {
            return false;
        }
        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);

        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows
                || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }

        return true;
    }

    private static void fillMatrix(Scanner scan, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split(" ");
        }
    }
}
