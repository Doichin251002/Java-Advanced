import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] dimensions = scan.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int [][] matrix = new int[rows][cols];

        enterMatrixElement(scan, rows, cols, matrix);

        int search = Integer.parseInt(scan.nextLine());

        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == search) {
                    isFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }

    private static void enterMatrixElement(Scanner scan, int rows, int cols, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            String [] data = scan.nextLine().split(" ");

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(data[j]);
            }
        }
    }
}
