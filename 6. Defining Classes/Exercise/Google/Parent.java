package Google;

public class Parent {
    private String name;
    private String birthdayDate;

    public Parent(String name, String birthdayDate) {
        this.name = name;
        this.birthdayDate = birthdayDate;
    }

    public String toString() {
        return name + " " + birthdayDate;
    }
}
