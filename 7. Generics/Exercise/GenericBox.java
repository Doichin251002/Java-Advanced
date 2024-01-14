import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericBox<E extends Comparable<E>> {
    private List<E> elements;

    public GenericBox () {
        this.elements = new ArrayList<E>();
    }

    public void add(E data) {
        this.elements.add(data);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(this.elements, firstIndex, secondIndex);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (E data : elements) {
            result.append(String.format("%s: %s\n", data.getClass().getName(), data.toString()));
        }

        return result.toString().trim();
    }

    public long countOccursWith(E o) {

        return elements.stream().filter(data -> data.compareTo(o) > 0).count();
    }

}
