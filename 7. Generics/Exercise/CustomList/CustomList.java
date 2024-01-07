package CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<E extends Comparable<E>> implements Iterable<E> {
    private List<E> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(E element) {
        this.data.add(element);
    }

    public E remove(int index) {
        checkIndex(index);
        return this.data.remove(index);
    }

    public boolean contains(E element) {
        return this.data.contains(element);
    }

    public void swap(int index1, int index2) {
        checkIndex(index1);
        checkIndex(index2);

        E firstElement = this.data.get(index1);
        E secondElement = this.data.get(index2);

        this.data.set(index1, secondElement);
        this.data.set(index2, firstElement);
    }

    public int countGreaterThan(E element) {
        int count = 0;
        for (E e : this.data) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public E getMax() {
        checkEmpty();

        E max = this.data.get(0);
        for (E e : this.data) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }
    public E getMin() {
        checkEmpty();

        E min = this.data.get(0);
        for (E e : this.data) {
            if (e.compareTo(min) < 0) {
                min = e;
            }
        }
        return min;
    }

    private void checkEmpty() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException();
        }
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= this.data.size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return this.data.iterator();
    }

    public int size() {
        return this.data.size();
    }

    public E get(int i) {
        checkIndex(i);
        return this.data.get(i);
    }
}
