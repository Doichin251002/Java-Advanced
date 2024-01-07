import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        Map <String, Double []> students = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String name = scan.nextLine();
            String [] inputGrades = scan.nextLine().split(" ");
            Double [] grades = new Double[inputGrades.length];

            for (int j = 0; j < grades.length; j++) {
                grades[j] = Double.parseDouble(inputGrades[j]);
            }
            students.put(name, grades);
        }

        DecimalFormat format = new DecimalFormat("0.############");
        for (String studentName : students.keySet()) {
            Double [] grades = students.get(studentName);

            double sum = 0;
            for (Double grade : grades) {
                sum += grade;
            }
            System.out.printf("%s is graduated with %s%n", studentName, format.format(sum / grades.length));
        }
    }
}
