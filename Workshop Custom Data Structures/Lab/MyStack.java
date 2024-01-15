import java.util.Iterator;
import java.util.function.Consumer;

public class MyStack<E> implements Iterable<E> {
    private static class Node<T> {
        private T element;
        private Node<T> prev;

        public Node(T element, Node<T> prev) {
            this.element = element;
            this.prev = prev;
        }
    }

    private Node<E> top;
    private int size;

    public MyStack() {}

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = top;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.prev;
                
                return element;
            }
        };
    }

    public void push(E element) {
        this.top = new Node<>(element, this.top);
        this.size++;
    }

    public E pop() {
        ensureIsNotEmpty();

        E element = this.top.element;

        this.top = this.top.prev;
        size--;

        return element;
    }

    public E peek() {
        ensureIsNotEmpty();

        return this.top.element;
    }

    public int size() {
        return this.size;
    }

    private void ensureIsNotEmpty() {
        if (this.top == null) {
            throw new IllegalStateException("Cannot execute on empty stack.");
        }
    }
}
