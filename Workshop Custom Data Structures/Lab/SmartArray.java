import java.util.Iterator;
import java.util.function.Consumer;

public class SmartArray<E> implements Iterable<E> {
    private Object[] elements;
    private int size;

    public SmartArray() {
        this.elements = new Object[4];
        this.size = 0;
    }

    private class SmartArrayIterator implements Iterator<E> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public E next() {
            return get(i++);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SmartArrayIterator();
    }

    public void add(E data) {
        if (this.size == this.elements.length) {
            this.elements = expand();
        }

        this.elements[size] = data;
        this.size++;
    }

    public void add(int index, E data) {
        validateIndex(index);

        int lastIndex = this.size - 1;
        E lastElement = get(lastIndex);

        if (lastIndex - index >= 0) {
            System.arraycopy(this.elements, index, this.elements, index + 1, lastIndex - index);
        }

        this.elements[index] = data;
        add((E)lastElement);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        validateIndex(index);

        return (E)this.elements[index];
    }

    public boolean contains(E data) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(data)) {
                return true;
            }
        }

        return false;
    }

    public E remove(int index) {
        validateIndex(index);

        E element = get(index);
        this.size--;

        if (this.size - index >= 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, this.size - index);
        }

        this.elements[this.size] = 0;

        if (this.elements.length / 4 >= this.size || this.elements.length / 4 == 4) {
            this.elements = shrink();
        }

        return element;
    }

    private Object[] expand() {
        Object[] newElements = new Object[this.elements.length * 2];

        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);

        return newElements;
    }

    private Object[] shrink() {
        Object[] newElements = new Object[this.elements.length / 2];

        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);

        return newElements;
    }

    public int size() {
        return this.size;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }
}
