import java.util.function.Consumer;

public class MyStack<E> {
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

    public MyStack() {
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

    public void forEach(Consumer<E> consumer) {
        Node<E> currentElement = this.top;

        while (currentElement != null) {
            consumer.accept(currentElement.element);

            currentElement = currentElement.prev;
        }
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
