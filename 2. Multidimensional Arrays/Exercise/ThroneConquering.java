import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = Integer.parseInt(scan.nextLine());
        int size = Integer.parseInt(scan.nextLine());
        String[][] battlefield = new String[size][size];
        fillMatrix(scan, battlefield);

        int parisRow = -1;
        int parisCol = -1;

        for (int row = 0; row < battlefield.length; row++) {
            for (int col = 0; col < battlefield.length; col++) {
                if (battlefield[row][col].equals("P")) {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        String command = scan.nextLine();
        while (true) {
            String [] tokensCommand = command.split("\\s+");
            String direction = tokensCommand[0];
            int enemyRow = Integer.parseInt(tokensCommand[1]);
            int enemyCol = Integer.parseInt(tokensCommand[2]);

            battlefield[parisRow][parisCol] = "-";
            battlefield[enemyRow][enemyCol] = "S";

            switch (direction) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < battlefield.length) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if (parisCol + 1 < battlefield.length) {
                        parisCol++;
                    }
                    break;
            }
            energy--;
            if (energy <= 0) {
                battlefield[parisRow][parisCol] = "X";
                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                printMatrix(battlefield);
                return;
            }

            if (battlefield[parisRow][parisCol].equals("S")) {
                energy -= 2;
                if (energy <= 0) {
                    battlefield[parisRow][parisCol] = "X";
                    System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                    printMatrix(battlefield);
                    return;
                } else {
                    battlefield[parisRow][parisCol] = "-";
                }
            } else if (battlefield[parisRow][parisCol].equals("H")) {
                battlefield[parisRow][parisCol] = "-";
                System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
                printMatrix(battlefield);
                return;
            }

            command = scan.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scan, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split("");
        }
    }
}
