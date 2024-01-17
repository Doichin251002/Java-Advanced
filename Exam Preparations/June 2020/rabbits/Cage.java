package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;

        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(byName(name));
    }

    public boolean removeSpecies(String species) {
        return this.data.removeIf(bySpecies(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = this.data.stream()
                .filter(byName(name))
                .findFirst()
                .get();

        rabbit.setAvailable(false);
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbitsBySpecies = new ArrayList<>();

        this.data.stream().filter(bySpecies(species))
                .forEach(r -> {
                    r.setAvailable(false);
                    rabbitsBySpecies.add(r);
        });

        return rabbitsBySpecies;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder(String.format("Rabbits available at %s:%n", this.name));
        this.data.stream().filter(byAvailability())
                .forEach(r -> result.append(String.format("%s%n", r.toString())));

        return result.toString().trim();
    }

    private Predicate<Rabbit> byName(String name) {
        return r -> r.getName().equals(name);
    }

    private Predicate<Rabbit> bySpecies(String name) {
        return r -> r.getSpecies().equals(name);
    }

    private Predicate<Rabbit> byAvailability() {
        return Rabbit::isAvailable;
    }
}
