package Google;

public class Child {
    private String name;
    private String birthdayDate;

    public Child(String name, String birthdayDate) {
        this.name = name;
        this.birthdayDate = birthdayDate;
    }

    public String toString() {
        return name + " " + birthdayDate;
    }
}
