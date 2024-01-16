import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListyIterator implements Iterable<String>{
    private List<String> elements;
    private int currentIndex;


    public ListyIterator(String... elements) {
        this.elements = List.of(elements);
        this.currentIndex = 0;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int i = 0;
            @Override
            public boolean hasNext() {
                return this.i < elements.size();
            }

            @Override
            public String next() {
                return elements.get(i++);
            }
        };
    }

    public boolean hasNext() {
        return currentIndex < this.elements.size() - 1;
    }
    public boolean move() {
        if (hasNext()) {
            this.currentIndex++;
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation");
        }
        System.out.println(this.elements.get(currentIndex));
    }

    public void printAll() {
        System.out.println(String.join(" ", this.elements));
    }
}
