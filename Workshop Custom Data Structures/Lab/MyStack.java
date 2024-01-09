import java.util.function.Consumer;

public class MyStack {
    private static class Node {
        private int element;
        private Node prev;

        public Node(int element, Node prev) {
            this.element = element;
            this.prev = prev;
        }
    }

    private Node top;
    private int size;

    public MyStack() {
    }

    public void push(int element) {
        this.top = new Node(element, this.top);
        this.size++;
    }

    public int pop() {
        ensureIsNotEmpty();

        int element = this.top.element;

        this.top = this.top.prev;
        size--;

        return element;
    }

    public int peek() {
        ensureIsNotEmpty();

        return this.top.element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentElement = this.top;

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
