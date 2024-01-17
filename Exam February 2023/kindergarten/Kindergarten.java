package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.registry.size() < capacity) {
            this.registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        return this.registry.removeIf(c -> c.getFirstName().equals(firstName));
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        return this.registry.stream()
                .filter(c -> c.getFirstName().equals(firstName))
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
    }

    public String registryReport() {
        List<Child> childrenList = this.registry.stream()
                .sorted(Comparator.comparing(Child::getAge))
                .sorted(Comparator.comparing(Child::getFirstName))
                .sorted(Comparator.comparing(Child::getLastName))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder("Registered children in " + this.name + ":\n--\n");
        for (Child child : childrenList) {
            sb.append(child).append("\n--\n");
        }
        return sb.toString().trim();
    }
}
