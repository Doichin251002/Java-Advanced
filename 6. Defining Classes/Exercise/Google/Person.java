package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person() {
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String name, Company company, List<Pokemon> pokemons, List<Parent> parent, List<Child> children, Car car) {
        this.name = name;
        this.company = company;
        this.pokemons = pokemons;
        this.parents = parent;
        this.children = children;
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company: ").append(System.lineSeparator());
        if (company != null) {
            sb.append(this.company).append(System.lineSeparator());
        }

        sb.append("Car: ").append(System.lineSeparator());
        if (car != null) {
            sb.append(this.car).append(System.lineSeparator());
        }

        sb.append("Pokemon: ").append(System.lineSeparator());
        if (pokemons.size() != 0) {
            for (Pokemon pokemon : this.pokemons) {
                sb.append(pokemon).append(System.lineSeparator());
            }
        }

        sb.append("Parents: ").append(System.lineSeparator());
        if (parents.size() != 0) {
            for (Parent parent : this.parents) {
                sb.append(parent).append(System.lineSeparator());
            }
        }

        sb.append("Children: ").append(System.lineSeparator());
        if (children.size() != 0) {
            for (Child child : this.children) {
                sb.append(child).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
