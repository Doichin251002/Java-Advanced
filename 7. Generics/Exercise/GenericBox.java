import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericBox<E extends Comparable<E>> {
    private List<E> elements;

    public GenericBox () {
        this.elements = new ArrayList<E>();
    }


}
