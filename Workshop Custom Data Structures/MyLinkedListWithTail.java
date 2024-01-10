import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MyLinkedListWithTail {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int number) {
        Node newNode = new Node(number);

        if (!isEmpty()) {
            newNode.next = this.head;
        } else {
            this.tail = newNode;
        }

        this.head = newNode;
        size++;
    }

    public void addLast(int number) {
        if (isEmpty()) {
            addFirst(number);
        } else {
            Node newNode = new Node(number);

            this.tail.next = newNode;
            this.tail = newNode;
            size++;
        }
    }

    public int removeFirst() {
        verifyIsEmpty();

        int element = this.head.value;

        this.head = this.head.next;
        size--;

        if (isEmpty()) {
            this.head = null;
            this.tail = null;
        }

        return element;
    }

    public int removeLast() {
        verifyIsEmpty();

        if (this.size < 2) {
            return removeFirst();
        }

        int element = this.tail.value;

        Node currentNode = this.head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = null;
        this.tail = currentNode;
        size--;

        return element;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalStateException("Index is out of bounds.");
        }

        if (index == this.size - 1) {
            return this.tail.value;
        }

        Node element = this.head;

        for (int i = 0; i < index; i++) {
            element = element.next;
        }

        return element.value;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentElement = this.head;

        while (currentElement != null) {
            consumer.accept(currentElement.value);

            currentElement = currentElement.next;
        }
    }

    public int[] toArray() {
        List<Integer> result = new ArrayList<>();

        forEach(result::add);

        return result.stream().mapToInt(e -> e).toArray();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void verifyIsEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot execute on empty stack.");
        }
    }
}
