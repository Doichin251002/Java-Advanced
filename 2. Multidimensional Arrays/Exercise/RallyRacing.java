import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String carNumber = scan.nextLine();
        int km = 0;

        String[][] matrix = new String[size][size];
        fillMatrix(scan, matrix);

        int currentRow = 0;
        int currentCol = 0;
        List<Integer> tunnelsCoordinates = new ArrayList<>();
        findTunnels(matrix, tunnelsCoordinates);

        String direction = scan.nextLine();
        while (!direction.equals("End")) {
            switch (direction) {
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }

            String currentPlace = matrix[currentRow][currentCol];
            if (currentPlace.equals(".")) {
                km += 10;
            } else if (currentPlace.equals("F")) {
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                km += 10;
                break;
            } else if (currentPlace.equals("T")) {
                currentRow = tunnelsCoordinates.get(2);
                currentCol = tunnelsCoordinates.get(3);
                km += 30;

                matrix[tunnelsCoordinates.get(0)][tunnelsCoordinates.get(1)] = ".";
                matrix[tunnelsCoordinates.get(2)][tunnelsCoordinates.get(3)] = ".";
            }
            direction = scan.nextLine();
        }

        if (direction.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }

        System.out.printf("Distance covered %d km.%n", km);
        matrix[currentRow][currentCol] = "C";

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void findTunnels(String[][] matrix, List<Integer> tunnelsCoordinates) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("T")) {
                    tunnelsCoordinates.add(row);
                    tunnelsCoordinates.add(col);
                }
            }
        }
    }

    private static void fillMatrix(Scanner scan, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }
    }
}
