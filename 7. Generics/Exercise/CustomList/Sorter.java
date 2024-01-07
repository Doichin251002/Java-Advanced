package CustomList;

import java.util.Collections;

public class Sorter {

    public static <E extends Comparable<E>> void sort(CustomList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            E currentElement = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (currentElement.compareTo(list.get(j)) > 0) {
                    list.swap(i, j);
                }
            }
        }
    }
}
