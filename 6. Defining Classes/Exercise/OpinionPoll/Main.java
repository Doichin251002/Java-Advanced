package OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countPeople = Integer.parseInt(scan.nextLine());

        List<Person> peopleList = new ArrayList<>();
        for (int i = 0; i < countPeople; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            peopleList.add(person);
        }

        peopleList = peopleList.stream().filter(person -> person.getAge() > 30).collect(Collectors.toList());

        peopleList.sort(Comparator.comparing(Person::getName));

        for (Person person : peopleList) {
            System.out.println(person.toString());
        }
    }
}
