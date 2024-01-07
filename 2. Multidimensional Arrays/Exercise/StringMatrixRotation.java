import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rotation = scan.nextLine();
        int degrees = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        List<String> textList = new ArrayList<>();
        int maxLength = 0;
        String command = scan.nextLine();
        while (!command.equals("END")) {
            textList.add(command);

            if (command.length() > maxLength) {
                maxLength = command.length();
            }
            command = scan.nextLine();
        }

        int rows = textList.size();
        int cols = maxLength;
        char [][] matrix = new char[rows][cols];
        fillMatrix(matrix, textList);

        switch (degrees) {
            case 90:
                for (int col = 0; col < matrix[0].length; col++) {
                    for (int row = matrix.length - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = matrix.length - 1; row >= 0; row--) {
                    for (int col = matrix[0].length - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = matrix[0].length - 1; col >= 0; col--) {
                    for (int row = 0; row < matrix.length; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            default:
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[0].length; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }

    private static void fillMatrix(char[][] matrix, List<String> list) {
        for (int row = 0; row < matrix.length; row++) {
            String currentText = list.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < currentText.length()) {
                    matrix[row][col] = currentText.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }
}
