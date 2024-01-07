import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String [] tokens = scan.nextLine().split(" ");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        for (String name : students.keySet()) {
            System.out.printf("%s -> ", name);
            List<Double> grades = students.get(name);

            double sum = 0;
            for (Double grade : grades) {
                System.out.printf("%.2f ", grade);
                sum += grade;
            }
            double average = sum / grades.size();
            System.out.printf("(avg: %.2f)%n", average);
        }
    }
}
