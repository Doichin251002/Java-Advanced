import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] inputData = scan.nextLine().split(", ");
        int size = Integer.parseInt(inputData[0]);
        String pattern = inputData[1];

        int [][] matrix = new int[size][size];

        if (pattern.equals("A")) {
            fillMatrixPatternA(matrix);
        } else if (pattern.equals("B")) {
            fillMatrixPatternB(matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int [][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternB(int [][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if ((col + 1) % 2 == 0) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            } else {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int [][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
    }
}