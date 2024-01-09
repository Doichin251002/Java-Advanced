import java.util.function.Consumer;

public class MyLinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node head;
    private int size;

    public void addFirst(int number) {
        Node newNode = new Node(number);

        if (!isEmpty()) {
            newNode.next = this.head;
        }

        this.head = newNode;
        size++;
    }

    public void addLast(int number) {
        if (isEmpty()) {
            addFirst(number);
        } else {
            Node newNode = new Node(number);
            Node currentNode = this.head;

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
            size++;
        }
    }

    public int removeFirst() {
        verifyIsEmpty();

        int element = this.head.value;

        this.head = this.head.next;
        size--;

        return element;
    }

    public int removeLast() {
        verifyIsEmpty();

        Node nextNode = this.head;
        while (nextNode.next.next != null) {
            nextNode = nextNode.next;
        }

        int element = nextNode.next.value;
        nextNode.next = null;
        size--;

        return element;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalStateException("Index is out of bounds.");
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
        int[] array = new int[this.size];

        Node currentElement = this.head;

        for (int i = 0; i < this.size; i++) {
            array[i] = currentElement.value;

            currentElement = currentElement.next;
        }

        return array;
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
