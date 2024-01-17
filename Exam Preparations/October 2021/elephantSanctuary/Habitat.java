package elephantSanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return this.data.stream()
                .filter(e -> e.getRetiredFrom().equals(retiredFrom))
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
    }

    public Elephant getOldestElephant() {
        return this.data.stream().max(Comparator.comparing(Elephant::getAge)).get();
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder("Saved elephants in the park:\n");

        for (Elephant elephant : this.data) {
            sb.append(elephant.getName()).append(" came from: ").append(elephant.getRetiredFrom()).append("\n");
        }

        return sb.toString();
    }
}
