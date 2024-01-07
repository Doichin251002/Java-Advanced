import java.util.Scanner;

public class MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();

        if (rows + cols > 27) {
            return;
        }

        String [][] matrix = new String[rows][cols];

        generateMatrixData(matrix);

        printMatrix(matrix);
    }

    private static void printMatrix(String [][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void generateMatrixData(String [][] matrix) {
        char startLetter = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = (char)(startLetter + row) + ""
                        + (char)(startLetter + row + col) + ""
                        + (char)(startLetter + row) + "";
            }
        }
    }
}
