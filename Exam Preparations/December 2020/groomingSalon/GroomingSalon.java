package groomingSalon;

import java.util.*;
import java.util.stream.Collectors;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:\n");
        for (Pet pet : this.data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner());
            sb.append("\n");
        }

        return sb.toString();
    }
}
