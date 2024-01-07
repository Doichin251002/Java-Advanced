import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] inputDimensions = scan.nextLine().split(" ");
        int firstRows = Integer.parseInt(inputDimensions[0]);
        int firstCols = Integer.parseInt(inputDimensions[1]);

        int[][] firstMatrix = new int[firstRows][firstCols];

        enterMatrixElements(scan, firstRows, firstCols, firstMatrix);

        inputDimensions = scan.nextLine().split(" ");
        int secondRows = Integer.parseInt(inputDimensions[0]);
        int secondCols = Integer.parseInt(inputDimensions[1]);

        if (firstRows != secondRows || firstCols != secondCols) {
            System.out.println("not equal");
            return;
        }

        int[][] secondMatrix = new int[secondRows][secondCols];

        enterMatrixElements(scan, secondRows, secondCols, secondMatrix);

        for (int i = 0; i < firstRows; i++) {
            for (int j = 0; j < firstCols; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");

    }

    private static void enterMatrixElements(Scanner scan, int rows, int cols, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            String [] data = scan.nextLine().split(" ");

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(data[j]);
            }
        }
    }
}