import java.util.Collections;

public class CustomList<T extends Comparable<T>> extends GenericBox<T> {
    public T remove(int index) {
        validateIndex(index);

        return getElements().remove(index);
    }

    public boolean contains(T data) {
        return getElements().stream().anyMatch(element -> element.toString().contains(data.toString()));
    }

    public T getMax() {
        return Collections.max(getElements());
    }

    public T getMin() {
        return Collections.min(getElements());
    }

    public String getElementsSeparatedByLine() {
        StringBuilder result = new StringBuilder();

        for (T data : getElements()) {
            result.append(data + "\n");
        }

        return result.toString().trim();
    }
}
