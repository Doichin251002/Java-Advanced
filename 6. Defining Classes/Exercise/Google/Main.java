package Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Map<String, Person> peopleInfo = new LinkedHashMap<>();
        while (!command.equals("End")) {
            String [] data = command.split("\\s+");
            String personName = data[0];

            peopleInfo.putIfAbsent(personName, new Person());

            String typeInfo = data[1];
            switch (typeInfo) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    peopleInfo.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peopleInfo.get(personName).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    peopleInfo.get(personName).getParents().add(parent);
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Child child = new Child(childName, childBirthday);
                    peopleInfo.get(personName).getChildren().add(child);
                    break;
                case "car":
                    String carModel = data[2];
                    int carSpeed = Integer.parseInt(data[3]);
                    Car car = new Car(carModel, carSpeed);
                    peopleInfo.get(personName).setCar(car);
                    break;
            }
            command = scan.nextLine();
        }

        String searchedPerson = scan.nextLine();
        System.out.println(searchedPerson);

        Person personalData = peopleInfo.get(searchedPerson);
        System.out.println(personalData);
    }
}
