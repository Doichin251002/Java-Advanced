package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.data.size() < capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return this.data.removeIf(e -> e.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        return this.data.stream().max(Comparator.comparing(Egg::getStrength)).get();
    }

    public Egg getEgg(String color) {
        return this.data.stream().filter(egg -> egg.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.material).append(" basket contains:\n");
        for (Egg egg : this.data) {
            sb.append(egg).append("\n");
        }

        return sb.toString().trim();
    }
}
