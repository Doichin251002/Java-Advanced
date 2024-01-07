import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int [][] matrix = new int[size][size];

        fillMatrix(scan, matrix);

        int sumPrimary = getSumPrimaryDiagonal(matrix);
        int sumSecondary = getSumSecondaryDiagonal(matrix);
        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }

    private static int getSumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0, col = matrix.length - 1; row < matrix.length; row++, col--) {
            sum += matrix[row][col];
        }
        return sum;
    }

    private static int getSumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static void fillMatrix(Scanner scan, int [][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scan.nextInt();
            }
        }
    }
}
