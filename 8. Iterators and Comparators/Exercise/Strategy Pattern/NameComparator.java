import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if (first.getName().length() == second.getName().length()) {
            char firstPersonLetter = first.getName().toLowerCase().charAt(0);
            char secondPersonLetter = second.getName().toLowerCase().charAt(0);

            return Character.compare(firstPersonLetter, secondPersonLetter);
        }

        return Integer.compare(first.getName().length(), second.getName().length());
    }
}
